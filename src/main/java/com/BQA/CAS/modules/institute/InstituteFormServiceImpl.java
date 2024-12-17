package com.BQA.CAS.modules.institute;

import com.BQA.CAS.authentication.JwtUtils;
import com.BQA.CAS.common.response.CommonResponse;
import com.BQA.CAS.common.response.PostSuccessResponse;
import com.BQA.CAS.modules.auth.User;
import com.BQA.CAS.modules.auth.UserRepository;
import com.BQA.CAS.modules.institute.model.InstituteForm;
import com.BQA.CAS.modules.institute.model.RegistrationRequest;
import com.BQA.CAS.modules.institute.model.RegistrationResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.BQA.CAS.common.constants.Enum.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.BQA.CAS.common.constants.Enum.ApplicationStatus;

import java.util.Comparator;
import java.util.List;

@Service
public class InstituteFormServiceImpl implements InstitutionFormService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  InstituteFormRepository repository;

    @Autowired
    private JwtUtils jwtUtils;


    @Override
    @Transactional
    public CommonResponse<RegistrationResponse> institutionRegistration(RegistrationRequest request) {
        Boolean checkExists = repository.existsByContactPersonEmail(request.getEmailId());
        Boolean checkUserExists = userRepository.existsByEmail(request.getEmailId());
        if (checkExists || checkUserExists) {
            throw new ServiceException("Already registered with given emailId: " + request.getEmailId());
        }
        InstituteForm institutionDetails = new InstituteForm();
        institutionDetails.setInstitutionName(request.getInstitutionName());
        institutionDetails.setBqaReviewComment(request.getBqaReviewComment());
        institutionDetails.setInstAppLicNo(request.getInstAppLicNo());
        institutionDetails.setLicenseType(request.getLicenseType());

        institutionDetails.setNotApplicable(request.getExpiryDateNotApplicable());
        institutionDetails.setApprovalDocFile(request.getApprovalDocFile());
        institutionDetails.setIssueDate(request.getIssueDate());
        institutionDetails.setExpDate(request.getExpiryDate());
        institutionDetails.setIsBqaReviewed(request.getIsBqaReviewed());
        institutionDetails.setIsOfferingNanLocCourseQa(request.getIsOfferingNanLocCourseQa());
        institutionDetails.setRandomDate(request.getPlannedSubmissionDate());
//        institutionDetails.setStatus();
        if (request.getIsBqaReviewed() == 1) {
            institutionDetails.setReviewIssueDate(request.getBqaReviewIssueDate());
            institutionDetails.setReviewJudResult(request.getBqaReviewResult());
        }
        if (request.getIsOfferingNanLocCourseQa() == 1) {
            institutionDetails.setOfferingDescription(request.getOfferingDescription());
        }

        institutionDetails.setContactPersonName(request.getContactName());
        institutionDetails.setContactPersonTitle(request.getPositionTitle());
        institutionDetails.setContactPersonNumber(request.getContactNo());
        institutionDetails.setContactPersonEmail(request.getEmailId());

        institutionDetails.setInstitutionTypeOtherData(request.getInstitutionTypeOtherData());
        institutionDetails.setFieldOtherData(request.getFieldOtherData());
        institutionDetails.setRegulatoryOthersData(request.getRegulatoryOthersData());
        institutionDetails.setLicencedByOthersData(request.getLicencedByOthersData());
        institutionDetails.setStatus(ApplicationStatus.INSTITUTION_REGISTERED.getCode());
        repository.save(institutionDetails);

        CommonResponse response = new CommonResponse();
        RegistrationResponse data = new RegistrationResponse();
        data.setFormId(institutionDetails.getFormId());
        data.setMessage("Registered Successfully");
        response.setData(data);
        return response;
    }


    @Override
    @Transactional
    public Integer updateStatusByEmail(Long id, Integer status) {
        Integer currentStatus = repository.findStatusById(id);
        if (currentStatus == null) {
            throw new EntityNotFoundException("No record found for email: " + id);
        }
        if (currentStatus.equals(status)) {
            throw new IllegalStateException("The record is already Approved: ");
        }

        int rowsUpdated = repository.updateStatusById(status, id);
        if (rowsUpdated == 0) {
            throw new EntityNotFoundException("No record found for email: " + id);
        }
        return rowsUpdated;
    }


    @Override
    @Transactional
    public CommonResponse<PostSuccessResponse> approveInstitute(Long id,int approveStatus) {
        InstituteForm instituteForm = repository.getByFormId(id);
        if (instituteForm==null ) {
            throw new EntityNotFoundException("No record found");
        }
        if(instituteForm.getStatus()>1){
            throw new IllegalStateException("Action already performed. No further action is allowed.");
        }

        Integer status;
        if(approveStatus==1){
            status = ApplicationStatus.DFO_ADMIN_APPROVED.getCode();
            User instUser = new User();
            instUser.setCreatedAppId(1L);
            instUser.setUpdatedAppId(1L);
            instUser.setEmail(instituteForm.getContactPersonEmail());
            instUser.setPassword("1234");
            instUser.setUserType(UserType.INSTITUTION.getCode());
            instUser.setSubType(UserSubType.ADMIN.getCode());
            userRepository.save(instUser);
        }else{
            status = ApplicationStatus.DFO_ADMIN_REJECTED.getCode();
        }
        int rowsUpdated = repository.updateStatusById(status, id);
        //Approve User

         CommonResponse<PostSuccessResponse> response = new CommonResponse();
        PostSuccessResponse resData = new PostSuccessResponse();

        resData.setMessage(approveStatus==1?"Approved Successfully":"Rejected Successfully");

        response.setData(resData);
        return response;
    }

    @Override
    @Transactional
    public CommonResponse<List<InstituteForm>> getAllInstituteForms() {
        List<InstituteForm> data = repository.findAll();

        if (data.isEmpty()) {
            throw new EntityNotFoundException("No institutes found");
        }
        data.sort(Comparator.comparing(InstituteForm::getUpdatedTime).reversed());
        CommonResponse<List<InstituteForm>> response = new CommonResponse<>();
        response.setData(data);

        return response;
    }

    @Override
    @Transactional
    public CommonResponse<List<InstituteForm>> getInstituteFormsByEmail() {
        String email = getUserNameRequest();
        if(email==null){
            throw new RuntimeException("No user found");
        }
        List<InstituteForm> data =  repository.findByContactPersonEmail(email);
        if(data.get(0).getStatus() < 2 ){
            throw new EntityNotFoundException("No record found for email: " + email);
        }
        CommonResponse response = new CommonResponse();
        response.setData(data);
        return response;
    }


    public String getUserNameRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String username = jwtUtils.getUsernameFromToken(authorizationHeader.substring(7));
            return username; // Removes "Bearer " prefix

        }
        return null; // Return null if no Bearer token is found
    }
}
