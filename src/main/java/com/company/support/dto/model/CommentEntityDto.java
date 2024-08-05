package com.company.support.dto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@Entity(name = "Comment")
@Table(name = "comment")
public class CommentEntityDto {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  private UUID id;
  @Column(name = "issue_id")
  private UUID issueId;
  @Column(name = "description")
  private String description;
  @Column(name = "created_at")
  @CreationTimestamp
  private Date createdAt;
  @Column(name = "client_id")
  private UUID clientId;
  @Column(name = "client_name")
  private String clientName;

}
