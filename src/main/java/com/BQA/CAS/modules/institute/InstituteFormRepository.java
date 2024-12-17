package com.BQA.CAS.modules.institute;

import com.BQA.CAS.modules.institute.model.InstituteForm;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstituteFormRepository extends JpaRepository<InstituteForm,Long> {
    Boolean existsByContactPersonEmail(String contactPersonEmail);
    InstituteForm getByFormId(Long formId);

    List<InstituteForm> findByContactPersonEmail(String contactPersonEmail);


    @Query("SELECT i.status FROM InstituteForm i WHERE i.formId = :id")
    Integer findStatusById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE InstituteForm i SET i.status = :status WHERE i.formId = :formId")
    int updateStatusById(@Param("status") Integer status, @Param("formId") Long formId);
}
