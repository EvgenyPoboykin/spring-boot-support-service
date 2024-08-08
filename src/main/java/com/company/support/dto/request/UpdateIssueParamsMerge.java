package com.company.support.dto.request;

import com.company.support.dto.model.StagesEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UpdateIssueParamsMerge {

  @NotNull
  @NotBlank(message = "stage is required field")
  @Enumerated(EnumType.STRING)
  private StagesEnum stage;
  @NotNull
  @NotBlank(message = "issueId is required field")
  private UUID issueId;
  @NotNull
  @UpdateTimestamp
  private LocalDateTime updatedAt;

}
