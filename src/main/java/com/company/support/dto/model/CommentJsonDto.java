package com.company.support.dto.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentJsonDto {

  @NotNull
  private UUID id;
  @NotNull
  private UUID issueId;
  @NotNull
  private String description;
  @NotNull
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @CreationTimestamp
  private LocalDateTime createdAt;
  @NotNull
  private String clientName;

}
