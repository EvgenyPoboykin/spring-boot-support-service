package com.company.support.repository;

import com.company.support.dto.model.CommentEntity;
import com.company.support.dto.model.IssueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CommentRepositoryInterface extends JpaRepository<CommentEntity, UUID> {

  @Query(value = "select u from Comment u where u.issueId = :issueId order by u.createdAt desc limit :limit offset :offset")
  List<CommentEntity> findByIssueId(@Param("issueId") UUID issueId, @Param("limit") int limit,
      @Param("offset") Long offset);

  @Query(value = "select count(u) from Comment u where u.issueId = :issueId")
  long findByIssueIdCount(@Param("issueId") UUID issueId);

}
