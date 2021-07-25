package com.serranoz.baserestapi.service;

import com.serranoz.baserestapi.domain.entity.audit.DateAudit;
import com.serranoz.baserestapi.repository.BaseRepository;

import java.util.List;

public abstract class BaseService<
    E extends DateAudit, ID extends Long, R extends BaseRepository<E, ID>> {

  private final R repository;

  protected BaseService(R repository) {
    this.repository = repository;
  }

  public R getRepository() {
    return repository;
  }

  public List<E> findAll() {
    return repository.findAll();
  }

  public E findById(ID id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Entity with id: " + id + " not found"));
  }

  public E save(E e) {
    return repository.save(e);
  }

  public E deleteById(ID id) {
    E e = findById(id);
    repository.delete(e);
    return e;
  }
}
