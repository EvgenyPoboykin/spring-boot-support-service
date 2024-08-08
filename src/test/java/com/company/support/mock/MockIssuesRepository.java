package com.company.support.mock;

import com.company.support.dto.model.IssueEntity;
import com.company.support.dto.model.StagesEnum;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MockIssuesRepository {
  public List<IssueEntity> findByClientId(UUID clientId, int limit, Long offset) {
    return List.of();
  }

  public long findByClientIdCount(UUID clientId) {
    return 0;
  }

  public List<IssueEntity> findByAdmin(int limit, Long offset) {
    return List.of();
  }

  public long findByAdminCount() {
    return 0;
  }

  public void updateIssue(StagesEnum stage, LocalDate updateAt, UUID id) {

  }

  public void deleteIssue(UUID id, UUID clientId) {

  }

  public <S extends IssueEntity> S save(S entity) {
    return null;
  }

  public <S extends IssueEntity> Iterable<S> saveAll(Iterable<S> entities) {
    return null;
  }

  public Optional<IssueEntity> findById(UUID uuid) {
    return Optional.empty();
  }

  public boolean existsById(UUID uuid) {
    return false;
  }

  public Iterable<IssueEntity> findAll() {
    return null;
  }

  public Iterable<IssueEntity> findAllById(Iterable<UUID> uuids) {
    return null;
  }

  public long count() {
    return 0;
  }

  public void deleteById(UUID uuid) {

  }

  public void delete(IssueEntity entity) {

  }

  public void deleteAllById(Iterable<? extends UUID> uuids) {

  }

  public void deleteAll(Iterable<? extends IssueEntity> entities) {

  }

  public void deleteAll() {

  }
}
