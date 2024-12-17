package com.BQA.CAS.modules.institute.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class RegistrationResponse {
    private String message;

    private Integer code;

    private Long formUniqueId;

    private Long formId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Long getFormUniqueId() {
        return formUniqueId;
    }

    public void setFormUniqueId(Long formUniqueId) {
        this.formUniqueId = formUniqueId;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }
}
