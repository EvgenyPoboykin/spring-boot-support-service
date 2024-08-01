package com.company.support.controllers;

import com.company.support.constants.Stages;
import com.company.support.interfaces.OptionsServiceInterface;
import com.company.support.model.IssueStage;
import com.company.support.repository.postgres.PostgresRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "OptionsController", description = "Дополнительные методы")
@RestController
@RequestMapping("/api/v1")
public class OptionsServiceController implements OptionsServiceInterface {

    @Operation(summary = "Получить список этапов обработки")
    @GetMapping(path = "/options/stages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<IssueStage> getStages() {
        return new Stages().getList();
    }

}
