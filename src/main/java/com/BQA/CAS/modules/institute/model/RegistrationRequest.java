package com.BQA.CAS.modules.institute.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class RegistrationRequest {
    @NotBlank(message = "institutionName is required")
    private String institutionName;

    @NotBlank(message = "approvalLicense is required")
    private String instAppLicNo;

    @NotNull(message = "licenseType is required")
    private int licenseType;

    private String regulatoryOthersData;

    @NotBlank(message = "expiryDateNotApplicable is required")
    private String expiryDateNotApplicable;

    @NotBlank(message = "licenseFile is required")
    private String approvalDocFile;

    @NotNull(message = "issueDate is required")
    private Long issueDate;

    @NotNull(message = "expiryDate is required")
    private Long expiryDate;

    @NotNull(message = "bqaReviewed is required")
    private Integer isBqaReviewed;

    private Long bqaReviewIssueDate;

    private String bqaReviewResult;

    private String bqaReviewComment;

    @NotNull(message = "courseOffered is required")
    private Integer isOfferingNanLocCourseQa;

    private String offeringDescription;

    @NotNull(message = "plannedSubmissionDate is required")
    private Long plannedSubmissionDate;

    @NotBlank(message = "contactName is required")
    private String contactName;

    @NotBlank(message = "positionTitle is required")
    private String positionTitle;

    @NotBlank(message = "contactNo is required")
    private String contactNo;

    @NotBlank(message = "emailId is required")
    private String emailId;


    private String licencedByOthersData;

    private String institutionTypeOtherData;

    private String fieldOtherData;

    public ArrayList<NationalQualificationRequest> nationalQualifications = new ArrayList<>(0);

    public ArrayList<ForeignQualificationRequest> foreignQualifications = new ArrayList<>(0);

    public @NotBlank(message = "institutionName is required") String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(@NotBlank(message = "institutionName is required") String institutionName) {
        this.institutionName = institutionName;
    }

    public @NotBlank(message = "approvalLicense is required") String getInstAppLicNo() {
        return instAppLicNo;
    }

    public void setInstAppLicNo(@NotBlank(message = "approvalLicense is required") String instAppLicNo) {
        this.instAppLicNo = instAppLicNo;
    }

    @NotNull(message = "licenseType is required")
    public int getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(@NotNull(message = "licenseType is required") int licenseType) {
        this.licenseType = licenseType;
    }

    public String getRegulatoryOthersData() {
        return regulatoryOthersData;
    }

    public void setRegulatoryOthersData(String regulatoryOthersData) {
        this.regulatoryOthersData = regulatoryOthersData;
    }

    public @NotBlank(message = "expiryDateNotApplicable is required") String getExpiryDateNotApplicable() {
        return expiryDateNotApplicable;
    }

    public void setExpiryDateNotApplicable(@NotBlank(message = "expiryDateNotApplicable is required") String expiryDateNotApplicable) {
        this.expiryDateNotApplicable = expiryDateNotApplicable;
    }

    public @NotBlank(message = "licenseFile is required") String getApprovalDocFile() {
        return approvalDocFile;
    }

    public void setApprovalDocFile(@NotBlank(message = "licenseFile is required") String approvalDocFile) {
        this.approvalDocFile = approvalDocFile;
    }

    public @NotNull(message = "issueDate is required") Long getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(@NotNull(message = "issueDate is required") Long issueDate) {
        this.issueDate = issueDate;
    }

    public @NotNull(message = "expiryDate is required") Long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(@NotNull(message = "expiryDate is required") Long expiryDate) {
        this.expiryDate = expiryDate;
    }

    public @NotNull(message = "bqaReviewed is required") Integer getIsBqaReviewed() {
        return isBqaReviewed;
    }

    public void setIsBqaReviewed(@NotNull(message = "bqaReviewed is required") Integer isBqaReviewed) {
        this.isBqaReviewed = isBqaReviewed;
    }

    public Long getBqaReviewIssueDate() {
        return bqaReviewIssueDate;
    }

    public void setBqaReviewIssueDate(Long bqaReviewIssueDate) {
        this.bqaReviewIssueDate = bqaReviewIssueDate;
    }

    public String getBqaReviewResult() {
        return bqaReviewResult;
    }

    public void setBqaReviewResult(String bqaReviewResult) {
        this.bqaReviewResult = bqaReviewResult;
    }

    public String getBqaReviewComment() {
        return bqaReviewComment;
    }

    public void setBqaReviewComment(String bqaReviewComment) {
        this.bqaReviewComment = bqaReviewComment;
    }

    public @NotNull(message = "courseOffered is required") Integer getIsOfferingNanLocCourseQa() {
        return isOfferingNanLocCourseQa;
    }

    public void setIsOfferingNanLocCourseQa(@NotNull(message = "courseOffered is required") Integer isOfferingNanLocCourseQa) {
        this.isOfferingNanLocCourseQa = isOfferingNanLocCourseQa;
    }

    public String getOfferingDescription() {
        return offeringDescription;
    }

    public void setOfferingDescription(String offeringDescription) {
        this.offeringDescription = offeringDescription;
    }

    public @NotNull(message = "plannedSubmissionDate is required") Long getPlannedSubmissionDate() {
        return plannedSubmissionDate;
    }

    public void setPlannedSubmissionDate(@NotNull(message = "plannedSubmissionDate is required") Long plannedSubmissionDate) {
        this.plannedSubmissionDate = plannedSubmissionDate;
    }

    public @NotBlank(message = "contactName is required") String getContactName() {
        return contactName;
    }

    public void setContactName(@NotBlank(message = "contactName is required") String contactName) {
        this.contactName = contactName;
    }

    public @NotBlank(message = "positionTitle is required") String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(@NotBlank(message = "positionTitle is required") String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public @NotBlank(message = "contactNo is required") String getContactNo() {
        return contactNo;
    }

    public void setContactNo(@NotBlank(message = "contactNo is required") String contactNo) {
        this.contactNo = contactNo;
    }

    public @NotBlank(message = "emailId is required") String getEmailId() {
        return emailId;
    }

    public void setEmailId(@NotBlank(message = "emailId is required") String emailId) {
        this.emailId = emailId;
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

    public ArrayList<NationalQualificationRequest> getNationalQualifications() {
        return nationalQualifications;
    }

    public void setNationalQualifications(ArrayList<NationalQualificationRequest> nationalQualifications) {
        this.nationalQualifications = nationalQualifications;
    }

    public ArrayList<ForeignQualificationRequest> getForeignQualifications() {
        return foreignQualifications;
    }

    public void setForeignQualifications(ArrayList<ForeignQualificationRequest> foreignQualifications) {
        this.foreignQualifications = foreignQualifications;
    }
}
