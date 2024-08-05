
package com.company.support.dto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@Entity(name = "Issue")
@Table(name = "issue")
public class IssueEntityDto {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  private UUID id;
  @Column(name = "target_uri")
  private String targetUri;
  @Column(name = "image")
  private String image;
  @Column(name = "description")
  private String description;
  @Enumerated(EnumType.STRING)
  @Column(name = "stage")
  @ColumnDefault(value = "NEW")
  private StagesEnum stage;
  @Column(name = "client_id")
  private UUID clientId;
  @Column(name = "client_name")
  private String clientName;
  @CreationTimestamp
  @Column(name = "created_at")
  private Date createdAt;
  @UpdateTimestamp
  @Column(name = "updated_at")
  private Date updatedAt;

}
