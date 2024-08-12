package com.company.support.dto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.UpdateTimestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Comment")
@Table(name = "comment")
public class CommentEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", insertable = false, updatable = false)
  UUID id;
  @Column(name = "issue_id", updatable = false)
  UUID issueId;
  @Column(name = "description", updatable = false)
  String description;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @UpdateTimestamp
  @Column(name = "created_at", insertable = false, updatable = false)
  LocalDateTime createdAt;
  @Column(name = "client_id", updatable = false)
  UUID clientId;
  @Column(name = "client_name", updatable = false)
  String clientName;

}
