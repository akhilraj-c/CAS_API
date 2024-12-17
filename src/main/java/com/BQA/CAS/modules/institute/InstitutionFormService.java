package com.BQA.CAS.modules.institute;

import com.BQA.CAS.common.response.CommonResponse;
import com.BQA.CAS.common.response.PostSuccessResponse;
import com.BQA.CAS.modules.institute.model.InstituteForm;
import com.BQA.CAS.modules.institute.model.RegistrationRequest;
import com.BQA.CAS.modules.institute.model.RegistrationResponse;

import java.util.List;

public interface InstitutionFormService {
    CommonResponse<RegistrationResponse> institutionRegistration(RegistrationRequest request);
    CommonResponse<PostSuccessResponse> updateStatusByEmail(Long id, Integer status);
    CommonResponse<PostSuccessResponse> approveInstitute(Long id,int approveStatus);
    CommonResponse<List<InstituteForm>> getAllInstituteForms();
    CommonResponse<List<InstituteForm>> getInstituteFormsByEmail();
    CommonResponse<InstituteForm> getInstituteDetails(Long formId);
}
