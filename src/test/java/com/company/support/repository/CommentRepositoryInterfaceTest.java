package com.company.support.repository;

import com.company.support.dto.mappers.CommentMapper;
import com.company.support.dto.mappers.CommentMapperInterface;
import com.company.support.dto.mappers.IssueMapper;
import com.company.support.dto.mappers.IssueMapperInterface;
import com.company.support.dto.model.CommentEntity;
import com.company.support.dto.model.CommentJsonDto;
import com.company.support.mock.MockComments;
import com.company.support.mock.MockAssets;
//import jakarta.transaction.Transactional;
//import org.junit.runner.RunWith;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CommentRepositoryInterfaceTest {

    private final MockAssets assets = new MockAssets();
    private final MockComments mockComments = new MockComments();

    CommentMapperInterface commentMapper;
    IssueMapperInterface issueMapper;

    @Autowired
    CommentRepositoryInterface commentRepository;

    @BeforeEach
    public void setup() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        this.commentMapper = new CommentMapper(modelMapper);
        this.issueMapper = new IssueMapper(modelMapper);
    }


    @Test
    void itShouldCreateSaveComment() {
        CommentEntity c = commentRepository.save(commentMapper.mapCreateCommentJsonToEntity(mockComments.comment_1()));

        System.out.print(c);

        assertEquals(c.getIssueId(), assets.issueId_0());
        assertEquals(c.getDescription(), "testing");
        assertEquals(c.getClientId(), assets.clientId_1());
        assertEquals(c.getClientName(), assets.clientName_1);
    }

    @Test
    void itShouldFindByIssueIdAndHaveZeroComments() {
        Pageable pageable = PageRequest.of(1, 25);

        List<CommentEntity> comments = commentRepository.findByIssueId(assets.issueId_0(), pageable.getPageSize(), pageable.getOffset());

        List<CommentJsonDto> commentJsonDto = comments.stream().map(commentMapper::mapEntityToJson).toList();

        assertEquals(commentJsonDto.size(), 0);
    }

    @Test
    void findByIssueId() {
        // given
        Pageable pageable = PageRequest.of(1, 25);

        commentRepository.save(commentMapper.mapCreateCommentJsonToEntity(mockComments.comment_1()));
        // where
        List<CommentEntity> comments = commentRepository.findByIssueId(assets.issueId_0(), pageable.getPageSize(), pageable.getOffset());

        List<CommentJsonDto> commentJsonDto = comments.stream().map(commentMapper::mapEntityToJson).toList();

        // then
        System.out.print("Issue after insert --------------------\n");
        System.out.print(commentJsonDto);
        System.out.print("\n--------------------\n");

        assertEquals(commentJsonDto.stream().count(), 1);
    }

    @Test
    void findByIssueIdCount() {
    }
}