package com.company.support.repository;

import com.company.support.dto.mappers.IssueMapper;
import com.company.support.dto.mappers.IssueMapperInterface;
import com.company.support.mock.MockAssets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.NOT_SUPPORTED)
@DataJpaTest
class IssueRepositoryInterfaceTest {

    public final MockAssets assets = new MockAssets();

    ModelMapper modelMapper;
    IssueMapperInterface mapper;

    @Autowired
    IssueRepositoryInterface issueRepository;

    @BeforeEach
    public void setup() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        this.mapper = new IssueMapper(modelMapper);
        this.modelMapper = modelMapper;

    }

    @Test
    void findByClientId() {

    }

    @Test
    void findByClientIdCount() {
    }

    @Test
    void findByAdmin() {
    }

    @Test
    void findByAdminCount() {
    }

    @Test
    void updateIssue() {
    }

    @Test
    void deleteIssue() {
    }
}