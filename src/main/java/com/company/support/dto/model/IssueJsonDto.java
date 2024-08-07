package com.company.support.dto.model;

import java.sql.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IssueJsonDto {

  @NotNull
  private UUID id;
  @NotNull
  private String targetUri;
  private String image;
  @NotNull
  private String description;
  @NotNull
  @Enumerated(EnumType.STRING)
  private StagesEnum stage;
  @NotNull
  private String clientName;
  @NotNull
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createdAt;
  @NotNull
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date updatedAt;

}
