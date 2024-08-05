package com.company.support.controllers;

import com.company.support.api.OptionsControllerInterface;
import com.company.support.dto.model.StageJsonDto;
import com.company.support.services.options.OptionsServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "OptionsController", description = "Дополнительные методы")
@RestController
@RequiredArgsConstructor
public class OptionsController implements OptionsControllerInterface {

  public final OptionsServiceInterface optionsService;

  @Operation(summary = "Получить список этапов обработки")
  public List<StageJsonDto> getStages() {

    return optionsService.getStages();

  }

}
