package com.company.support.repository;

import com.company.support.dto.model.CommentEntity;
import com.company.support.mock.MockAssets;
import org.junit.runner.RunWith;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CommentRepositoryInterfaceTest {

    private final MockAssets assets = new MockAssets();

    @Autowired
    CommentRepositoryInterface commentRepository;

    @Test
    void itShouldCreateSaveComment() {
        CommentEntity c = commentRepository.save(assets.comment_0);
        commentRepository.flush();

        assertEquals(c.getIssueId(), assets.comment_0.getIssueId());
        assertEquals(c.getDescription(), assets.comment_0.getDescription());
        assertEquals(c.getClientId(), assets.comment_0.getClientId());
        assertEquals(c.getClientName(), assets.comment_0.getClientName());
    }

    @Test
    void findByIssueId() {
        // given
        commentRepository.save(assets.comment_0);
        commentRepository.save(assets.comment_1);
        commentRepository.flush();
        // where
        List<CommentEntity> comments = commentRepository.findByIssueId(assets.issueId_0, 1, (long)25);

        // then
        System.out.print("Issue after insert --------------------\n");
        System.out.print(comments);
        System.out.print("\n--------------------\n");

        CommentEntity first = comments.getFirst();

        assertEquals(first.getIssueId(), assets.issueId_0);
    }

    @Test
    void findByIssueIdCount() {
    }
}