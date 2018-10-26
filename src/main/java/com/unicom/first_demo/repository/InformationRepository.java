package com.unicom.first_demo.repository;

import com.unicom.first_demo.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InformationRepository extends JpaRepository<Information,Long> {

    @Query("select t from Information t where t.state = :state and t.is_valid=1")
    List<Information> findByState(@Param("state") String state);

    @Query("select t from Information t where t.is_valid=1")
    List<Information> findByAll();

    @Modifying(clearAutomatically = true)
    @Query(value="update t_bsstocb_procedure t set t.state = :state where t.id = :id",nativeQuery = true)
    void update_State(@Param("state") String state,@Param("id") long id);

    @Modifying(clearAutomatically = true)
    @Query(value = "update t_bsstocb_procedure t set t.info = :info where t.id = :id",nativeQuery = true)
    void update_Info(@Param("info") String info,@Param("id") long id);
}
