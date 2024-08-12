
package com.company.support.dto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Issue")
@Table(name = "issue")
public class IssueEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", insertable = false, updatable = false)
  private UUID id;
  @Column(name = "target_uri", updatable = false)
  private String targetUri;
  @Column(name = "image", updatable = false)
  private String image;
  @Column(name = "description", updatable = false)
  private String description;
  @Enumerated(EnumType.STRING)
  @Column(name = "stage")
  private StagesEnum stage = StagesEnum.NEW;
  @Column(name = "client_id", updatable = false)
  private UUID clientId;
  @Column(name = "client_name", updatable = false)
  private String clientName;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @CreationTimestamp
  @Column(name = "created_at", insertable = false, updatable = false)
  private LocalDateTime createdAt;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @UpdateTimestamp
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

}
