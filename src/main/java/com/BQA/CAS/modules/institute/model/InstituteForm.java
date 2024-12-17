package com.BQA.CAS.modules.institute.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "tbl_institute_form")
@NoArgsConstructor
@AllArgsConstructor
public class InstituteForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_id", nullable = false)
    private Long formId;

    @Column(name = "form_unique_id")
    private Long formUniqueId;

    @Column(name = "institute_name")
    private String institutionName;

    @Column(name = "inst_app_lic_no")
    private String instAppLicNo;

    @Column(name = "license_type")
    private Integer licenseType;

    @Column(name = "others_data")
    private String othersData;

    @Column(name = "not_applicable")
    private String notApplicable;


    @Column(name = "approval_doc_path")
    private String approvalDocFile;

    @Column(name = "issue_date")
    private Long issueDate;

    @Column(name = "exp_date")
    private Long expDate;

    @Column(name = "is_bqa_reviewed")
    private Integer isBqaReviewed;

    @Column(name = "bqa_review_comment")
    private String bqaReviewComment;

    @Column(name = "review_issue_date")
    private Long reviewIssueDate;

    @Column(name = "review_jud_result")
    public String reviewJudResult;


    @Column(name = "is_offering_nan_loc_course_qa")
    public Integer isOfferingNanLocCourseQa;

    @Column(name = "offering_description")
    private String offeringDescription;

    @Column(name = "planned_sub_date")
    private String plannedSubDate;

    @Column(name = "random_date")
    private Long randomDate;

    @Column(name = "poc_name")
    private String contactPersonName;

    @Column(name = "poc_email")
    private String contactPersonEmail;

    @Column(name = "poc_cn_number")
    private String contactPersonNumber;

    @Column(name = "poc_title")
    private String contactPersonTitle;

    @Column(name = "status")
    private Integer status;

    @Column(name = "sub_status")
    private Integer subStatus;
    @Column(name = "completed_status")
    private String completedStatus;

    @Column(name = "resubmit_status")
    private Integer resubmitStatus;

    @Column(name = "resubmit_count")
    private Long resubmitCount;

    @Column(name = "last_resubmit_date")
    public Long lastResubmitDate;

    @Column(name = "current_submit_date")
    public Long currentSubmitDate;

    @Column(name = "current_stage")
    private Integer current_stage;

    @Column(name = "date_ext_status")
    private Integer dateExtensionStatus;

    @Column(name = "date_ext_reason")
    private String dateExtensionReason;

    @Column(name = "reqsted_ext_date")
    private Long requestedExtensionDate;

    @Column(name = "is_extenstion_requested")
    private Integer isDateExtensionRequested;

    @Column(name = "form_flow_history")
    private String form_flow_history;



    /*** Additional column added  */
    @Column(name = "assigned_app_manager")
    private Long assignedAppManager;

    @Column(name = "institution_id")
    private Long institutionId;

    @Column(name = "factual_accuracy_file")
    private String factualAccuracyFile;

    @Column(name = "factual_accuracy_comment")
    private String factualAccuracyComment;

    @Column(name = "inst_factual_accuracy_dead_line")
    private Long instituteFactualAccuracyDeadLine;

    @Column(name = "inst_appeal")
    private Integer institutionAppeal;

    @Column(name = "inst_appeal_approve")
    private Integer institutionAppealApprove;

    @Column(name = "inst_appeal_exp")
    private Long institutionAppealExpiry;

    @Column(name = "over_all_approve_history")
    private String overAllApproveHistory;

    @Column(name = "current_status_due_date")
    private Long currentStatusDueDate;

    @Column(name = "regulatory_other_data")
    private String regulatoryOthersData;

    @Column(name = "licenced_by_other_data")
    private String licencedByOthersData;

    @Column(name = "institution_type_other_data")
    private String institutionTypeOtherData;

    @Column(name = "field_other_data")
    private String fieldOtherData;

    @Column(name = "rejection_reason")
    private String rejectionReason;

    @Column(name = "rejection_date")
    private Long rejectionDate;

    @Column(name = "Rejected_by_user_type")
    private Integer RejectedByUserType;

    @Column(name = "terminated_mail_sent")
    private Integer terminatedMailSent;

    @Column(name = "remainder_mail_sent")
    private Integer remainderMailSent;

    @Column(name = "created_ip")
    private String createdIp;

    @Column(name = "updated_ip")
    private String updatedIp;

    @Column(name = "created_app_id")
    private Long createdAppId;

    @Column(name = "updated_app_id")
    private Long updatedAppId;

    @Column(name = "created_time")
    private Long createdTime;

    @Column(name = "updated_time")
    private Long updatedTime;

    @PrePersist
    public void prePersist() {
        createdTime = System.currentTimeMillis();
        updatedTime = System.currentTimeMillis();
    }

    @PreUpdate
    public void preUpdate() {
        updatedTime = System.currentTimeMillis();
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public Long getFormUniqueId() {
        return formUniqueId;
    }

    public void setFormUniqueId(Long formUniqueId) {
        this.formUniqueId = formUniqueId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstAppLicNo() {
        return instAppLicNo;
    }

    public void setInstAppLicNo(String instAppLicNo) {
        this.instAppLicNo = instAppLicNo;
    }

    public Integer getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(Integer licenseType) {
        this.licenseType = licenseType;
    }

    public String getOthersData() {
        return othersData;
    }

    public void setOthersData(String othersData) {
        this.othersData = othersData;
    }

    public String getNotApplicable() {
        return notApplicable;
    }

    public void setNotApplicable(String notApplicable) {
        this.notApplicable = notApplicable;
    }

    public String getApprovalDocFile() {
        return approvalDocFile;
    }

    public void setApprovalDocFile(String approvalDocFile) {
        this.approvalDocFile = approvalDocFile;
    }

    public Long getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Long issueDate) {
        this.issueDate = issueDate;
    }

    public Long getExpDate() {
        return expDate;
    }

    public void setExpDate(Long expDate) {
        this.expDate = expDate;
    }

    public Integer getIsBqaReviewed() {
        return isBqaReviewed;
    }

    public void setIsBqaReviewed(Integer isBqaReviewed) {
        this.isBqaReviewed = isBqaReviewed;
    }

    public String getBqaReviewComment() {
        return bqaReviewComment;
    }

    public void setBqaReviewComment(String bqaReviewComment) {
        this.bqaReviewComment = bqaReviewComment;
    }

    public Long getReviewIssueDate() {
        return reviewIssueDate;
    }

    public void setReviewIssueDate(Long reviewIssueDate) {
        this.reviewIssueDate = reviewIssueDate;
    }

    public String getReviewJudResult() {
        return reviewJudResult;
    }

    public void setReviewJudResult(String reviewJudResult) {
        this.reviewJudResult = reviewJudResult;
    }

    public Integer getIsOfferingNanLocCourseQa() {
        return isOfferingNanLocCourseQa;
    }

    public void setIsOfferingNanLocCourseQa(Integer isOfferingNanLocCourseQa) {
        this.isOfferingNanLocCourseQa = isOfferingNanLocCourseQa;
    }

    public String getOfferingDescription() {
        return offeringDescription;
    }

    public void setOfferingDescription(String offeringDescription) {
        this.offeringDescription = offeringDescription;
    }

    public String getPlannedSubDate() {
        return plannedSubDate;
    }

    public void setPlannedSubDate(String plannedSubDate) {
        this.plannedSubDate = plannedSubDate;
    }

    public Long getRandomDate() {
        return randomDate;
    }

    public void setRandomDate(Long randomDate) {
        this.randomDate = randomDate;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }

    public void setContactPersonEmail(String contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
    }

    public String getContactPersonNumber() {
        return contactPersonNumber;
    }

    public void setContactPersonNumber(String contactPersonNumber) {
        this.contactPersonNumber = contactPersonNumber;
    }

    public String getContactPersonTitle() {
        return contactPersonTitle;
    }

    public void setContactPersonTitle(String contactPersonTitle) {
        this.contactPersonTitle = contactPersonTitle;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(Integer subStatus) {
        this.subStatus = subStatus;
    }

    public String getCompletedStatus() {
        return completedStatus;
    }

    public void setCompletedStatus(String completedStatus) {
        this.completedStatus = completedStatus;
    }

    public Integer getResubmitStatus() {
        return resubmitStatus;
    }

    public void setResubmitStatus(Integer resubmitStatus) {
        this.resubmitStatus = resubmitStatus;
    }

    public Long getResubmitCount() {
        return resubmitCount;
    }

    public void setResubmitCount(Long resubmitCount) {
        this.resubmitCount = resubmitCount;
    }

    public Long getLastResubmitDate() {
        return lastResubmitDate;
    }

    public void setLastResubmitDate(Long lastResubmitDate) {
        this.lastResubmitDate = lastResubmitDate;
    }

    public Long getCurrentSubmitDate() {
        return currentSubmitDate;
    }

    public void setCurrentSubmitDate(Long currentSubmitDate) {
        this.currentSubmitDate = currentSubmitDate;
    }

    public Integer getCurrent_stage() {
        return current_stage;
    }

    public void setCurrent_stage(Integer current_stage) {
        this.current_stage = current_stage;
    }

    public Integer getDateExtensionStatus() {
        return dateExtensionStatus;
    }

    public void setDateExtensionStatus(Integer dateExtensionStatus) {
        this.dateExtensionStatus = dateExtensionStatus;
    }

    public String getDateExtensionReason() {
        return dateExtensionReason;
    }

    public void setDateExtensionReason(String dateExtensionReason) {
        this.dateExtensionReason = dateExtensionReason;
    }

    public Long getRequestedExtensionDate() {
        return requestedExtensionDate;
    }

    public void setRequestedExtensionDate(Long requestedExtensionDate) {
        this.requestedExtensionDate = requestedExtensionDate;
    }

    public Integer getIsDateExtensionRequested() {
        return isDateExtensionRequested;
    }

    public void setIsDateExtensionRequested(Integer isDateExtensionRequested) {
        this.isDateExtensionRequested = isDateExtensionRequested;
    }

    public String getForm_flow_history() {
        return form_flow_history;
    }

    public void setForm_flow_history(String form_flow_history) {
        this.form_flow_history = form_flow_history;
    }

    public Long getAssignedAppManager() {
        return assignedAppManager;
    }

    public void setAssignedAppManager(Long assignedAppManager) {
        this.assignedAppManager = assignedAppManager;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public String getFactualAccuracyFile() {
        return factualAccuracyFile;
    }

    public void setFactualAccuracyFile(String factualAccuracyFile) {
        this.factualAccuracyFile = factualAccuracyFile;
    }

    public String getFactualAccuracyComment() {
        return factualAccuracyComment;
    }

    public void setFactualAccuracyComment(String factualAccuracyComment) {
        this.factualAccuracyComment = factualAccuracyComment;
    }

    public Long getInstituteFactualAccuracyDeadLine() {
        return instituteFactualAccuracyDeadLine;
    }

    public void setInstituteFactualAccuracyDeadLine(Long instituteFactualAccuracyDeadLine) {
        this.instituteFactualAccuracyDeadLine = instituteFactualAccuracyDeadLine;
    }

    public Integer getInstitutionAppeal() {
        return institutionAppeal;
    }

    public void setInstitutionAppeal(Integer institutionAppeal) {
        this.institutionAppeal = institutionAppeal;
    }

    public Integer getInstitutionAppealApprove() {
        return institutionAppealApprove;
    }

    public void setInstitutionAppealApprove(Integer institutionAppealApprove) {
        this.institutionAppealApprove = institutionAppealApprove;
    }

    public Long getInstitutionAppealExpiry() {
        return institutionAppealExpiry;
    }

    public void setInstitutionAppealExpiry(Long institutionAppealExpiry) {
        this.institutionAppealExpiry = institutionAppealExpiry;
    }

    public String getOverAllApproveHistory() {
        return overAllApproveHistory;
    }

    public void setOverAllApproveHistory(String overAllApproveHistory) {
        this.overAllApproveHistory = overAllApproveHistory;
    }

    public Long getCurrentStatusDueDate() {
        return currentStatusDueDate;
    }

    public void setCurrentStatusDueDate(Long currentStatusDueDate) {
        this.currentStatusDueDate = currentStatusDueDate;
    }

    public String getRegulatoryOthersData() {
        return regulatoryOthersData;
    }

    public void setRegulatoryOthersData(String regulatoryOthersData) {
        this.regulatoryOthersData = regulatoryOthersData;
    }

    public String getLicencedByOthersData() {
        return licencedByOthersData;
    }

    public void setLicencedByOthersData(String licencedByOthersData) {
        this.licencedByOthersData = licencedByOthersData;
    }

    public String getInstitutionTypeOtherData() {
        return institutionTypeOtherData;
    }

    public void setInstitutionTypeOtherData(String institutionTypeOtherData) {
        this.institutionTypeOtherData = institutionTypeOtherData;
    }

    public String getFieldOtherData() {
        return fieldOtherData;
    }

    public void setFieldOtherData(String fieldOtherData) {
        this.fieldOtherData = fieldOtherData;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public Long getRejectionDate() {
        return rejectionDate;
    }

    public void setRejectionDate(Long rejectionDate) {
        this.rejectionDate = rejectionDate;
    }

    public Integer getRejectedByUserType() {
        return RejectedByUserType;
    }

    public void setRejectedByUserType(Integer rejectedByUserType) {
        RejectedByUserType = rejectedByUserType;
    }

    public Integer getTerminatedMailSent() {
        return terminatedMailSent;
    }

    public void setTerminatedMailSent(Integer terminatedMailSent) {
        this.terminatedMailSent = terminatedMailSent;
    }

    public Integer getRemainderMailSent() {
        return remainderMailSent;
    }

    public void setRemainderMailSent(Integer remainderMailSent) {
        this.remainderMailSent = remainderMailSent;
    }

    public String getCreatedIp() {
        return createdIp;
    }

    public void setCreatedIp(String createdIp) {
        this.createdIp = createdIp;
    }

    public String getUpdatedIp() {
        return updatedIp;
    }

    public void setUpdatedIp(String updatedIp) {
        this.updatedIp = updatedIp;
    }

    public Long getCreatedAppId() {
        return createdAppId;
    }

    public void setCreatedAppId(Long createdAppId) {
        this.createdAppId = createdAppId;
    }

    public Long getUpdatedAppId() {
        return updatedAppId;
    }

    public void setUpdatedAppId(Long updatedAppId) {
        this.updatedAppId = updatedAppId;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }
}
