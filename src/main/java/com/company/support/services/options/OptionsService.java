package com.company.support.services.options;

import com.company.support.dto.model.StageJsonDto;
import com.company.support.dto.model.StagesEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionsService implements OptionsServiceInterface {

  public List<StageJsonDto> getStages() {
    return List.of(
        StagesEnum.NEW.object,
        StagesEnum.DONE.object,
        StagesEnum.IN_PROCESS.object,
        StagesEnum.REJECTED.object);
  }

}
