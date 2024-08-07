package com.company.support.dto.request;

import com.company.support.dto.model.StagesEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIssueParamsDto {

  @Enumerated(EnumType.STRING)
  private StagesEnum stage;

}
