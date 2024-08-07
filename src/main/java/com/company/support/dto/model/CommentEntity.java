package com.company.support.dto.model;

import jakarta.persistence.*;
import jakarta.validation.executable.ValidateOnExecution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Comment")
@Table(name = "comment")
public class CommentEntity {

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
