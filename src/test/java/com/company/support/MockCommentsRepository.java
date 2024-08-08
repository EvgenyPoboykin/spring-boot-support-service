package com.company.support;

import com.company.support.dto.model.CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MockCommentsRepository {
    @Autowired
    private MockComments repository;

    public List<CommentEntity> findByIssueId(UUID issueId, int limit, Long offset) {
        return repository.comments.stream().filter(c -> c.getIssueId() == issueId).collect(Collectors.toList());
    }

    public long findByIssueIdCount(UUID issueId) {
        return repository.comments.stream().filter(c -> c.getIssueId() == issueId).count();
    }

    public <S extends CommentEntity> S save(S entity) {
        repository.comments.add(new CommentEntity(
                UUID.randomUUID(),
                entity.getIssueId(),
                entity.getDescription(),
                LocalDateTime.now(),
                repository.clientId_1,
                repository.clientName_1
        ));
        return null;
    }

    public boolean existsById(UUID id) {
        return repository.comments.stream().filter(c -> c.getId() == id).count() == 1;
    }

}
