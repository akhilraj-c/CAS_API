package com.BQA.CAS.modules.institute;

import com.BQA.CAS.common.response.CommonResponse;
import com.BQA.CAS.common.response.PostSuccessResponse;
import com.BQA.CAS.modules.institute.model.ApproveEduscribeRequest;
import com.BQA.CAS.modules.institute.model.InstituteForm;
import com.BQA.CAS.modules.institute.model.RegistrationRequest;
import com.BQA.CAS.modules.institute.model.RegistrationResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.BQA.CAS.common.constants.ApiUrls;

import java.util.List;

@RestController
public class InstituteFormController {

    @Autowired
    InstitutionFormService service;

    @PostMapping(ApiUrls.INSTITUTION_REGISTRATION)
    public ResponseEntity<CommonResponse<RegistrationResponse>> userRegistration(@Valid @RequestBody RegistrationRequest request,
                                                                                 BindingResult bindingResult) {
        try {
            final CommonResponse<RegistrationResponse> response = service.institutionRegistration(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping(ApiUrls.APPROVE_INSTITUTE)
    public ResponseEntity<CommonResponse<PostSuccessResponse>>approveInstitute(@RequestParam Long id) {
        try {
            CommonResponse<PostSuccessResponse> response = service.approveInstitute(id,1 );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    @PostMapping(ApiUrls.REJECT_INSTITUTE)
    public ResponseEntity<CommonResponse<PostSuccessResponse>>rejectInstitute(@RequestParam Long id) {
        try {
            CommonResponse<PostSuccessResponse> response = service.approveInstitute(id,0 );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping(ApiUrls.APPROVE_EDUSCRIBE)
    public ResponseEntity<CommonResponse<PostSuccessResponse>> approveEduscribe(@RequestBody ApproveEduscribeRequest request) {
        try {
            CommonResponse<PostSuccessResponse> response = service.updateStatusByEmail(request.getTempListingID(),7);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping(ApiUrls.GET_ALL_INSTITUTES)
    public ResponseEntity<CommonResponse<List<InstituteForm>>> getInstitutes() {
        try {
            final CommonResponse response = service.getAllInstituteForms();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping(ApiUrls.GET_INSTITUTE_BY_EMAIL)
    public ResponseEntity<CommonResponse<List<InstituteForm>>> getInstitutesByEmail() {
        try {
            final CommonResponse<List<InstituteForm>> response = service.getInstituteFormsByEmail();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw e;        }
    }

    @GetMapping(ApiUrls.GET_INSTITUTE_DETAILS)
    public ResponseEntity<CommonResponse<InstituteForm>> getInstitutesDetails(@RequestParam Long formId) {
        try {
            final CommonResponse<InstituteForm> response = service.getInstituteDetails(formId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw e;        }
    }

}
