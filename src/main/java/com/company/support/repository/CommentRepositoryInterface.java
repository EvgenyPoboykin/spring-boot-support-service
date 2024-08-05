package com.company.support.repository;

import com.company.support.dto.model.CommentEntityDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CommentRepositoryInterface extends CrudRepository<CommentEntityDto, UUID> {

  @Query(value = "select u from Comment u where u.issueId = ?1 order by u.createdAt desc")
  List<CommentEntityDto> findByIssueId(@Param("issueId") UUID issueId);

}
