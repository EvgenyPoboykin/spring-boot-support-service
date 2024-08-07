
package com.company.support.dto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Issue")
@Table(name = "issue")
public class IssueEntity {

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
  private StagesEnum stage = StagesEnum.NEW;
  @Column(name = "client_id")
  private UUID clientId;
  @Column(name = "client_name")
  private String clientName;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @CreationTimestamp
  @Column(name = "created_at")
  private Date createdAt;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @UpdateTimestamp
  @Column(name = "updated_at")
  private Date updatedAt;

}
