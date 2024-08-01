package com.company.support.constants;


import com.company.support.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stages {
    List<IssueStage> stages = new ArrayList<IssueStage>();

    IssueStage newStage = new IssueStage(StagesEnum.NEW, StagesEnum.NEW.label);
    IssueStage doneStage = new IssueStage(StagesEnum.DONE, StagesEnum.DONE.label);
    IssueStage inProcessStage = new IssueStage(StagesEnum.IN_PROCESS, StagesEnum.IN_PROCESS.label);
    IssueStage rejectedStage = new IssueStage(StagesEnum.REJECTED, StagesEnum.REJECTED.label);

    public List<IssueStage> getList() {
        stages.add(newStage);
        stages.add(doneStage);
        stages.add(inProcessStage);
        stages.add(rejectedStage);

        return stages;
    }

    public Optional<IssueStage> findStageByValue(StagesEnum value) {
        return getList().stream().filter((stage) -> stage.getValue() == value).findFirst();
    }
}
