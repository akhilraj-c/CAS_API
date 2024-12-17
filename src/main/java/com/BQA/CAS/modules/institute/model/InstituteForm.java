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

}
