package com.company.support.api;

import com.company.support.dto.model.StageJsonDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1")
public interface OptionsControllerInterface {

  @GetMapping(path = "/options/stages", produces = MediaType.APPLICATION_JSON_VALUE)
  List<StageJsonDto> getStages();

}
