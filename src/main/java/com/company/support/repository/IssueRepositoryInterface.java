package com.company.support.repository;

import com.company.support.dto.model.IssueEntity;

import com.company.support.dto.model.StagesEnum;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface IssueRepositoryInterface extends CrudRepository<IssueEntity, UUID> {

  @Query(value = "select u from Issue u where u.clientId = :clientId order by u.createdAt desc limit :limit offset :offset")
  List<IssueEntity> findByClientId(@Param("clientId") UUID clientId, @Param("limit") int limit,
      @Param("offset") Long offset);

  @Query(value = "select count(u) from Issue u where u.clientId = :clientId")
  long findByClientIdCount(@Param("clientId") UUID clientId);

  @Query(value = "select u from Issue u order by u.createdAt desc limit :limit offset :offset")
  List<IssueEntity> findByAdmin(@Param("limit") int limit, @Param("offset") Long offset);

  @Query(value = "select count(u) from Issue u")
  long findByAdminCount();

  @Modifying(clearAutomatically = true)
  @Query(value = "update Issue u set u.stage = :stage , u.updatedAt = :updatedAt where u.id = :id")
  @Transactional
  void updateIssue(@Param("stage") StagesEnum stage, @Param("updatedAt") LocalDate updateAt, @Param("id") UUID id);

  @Modifying(clearAutomatically = true)
  @Query(value = "delete Issue u where u.id = :id and u.clientId = :clientId")
  @Transactional
  void deleteIssue(@Param("id") UUID id, @Param("clientId") UUID clientId);

}
