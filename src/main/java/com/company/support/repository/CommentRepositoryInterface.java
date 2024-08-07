package com.company.support.repository;

import com.company.support.dto.model.CommentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CommentRepositoryInterface extends CrudRepository<CommentEntity, UUID> {

  @Query(value = "select u from Comment u where u.issueId = :issueId order by u.createdAt desc")
  List<CommentEntity> findByIssueId(@Param("issueId") UUID issueId);

  @Query(value = "select count(u) from Comment u where u.issueId = :issueId")
  long findByIssueIdCount(@Param("issueId") UUID issueId);

}
