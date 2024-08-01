package com.company.support.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IssueUpdate {
    @NotBlank(message = "stage is required field")
    private StagesEnum stage;
}