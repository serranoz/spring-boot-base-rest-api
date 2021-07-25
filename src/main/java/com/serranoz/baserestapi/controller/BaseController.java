package com.serranoz.baserestapi.controller;

import com.serranoz.baserestapi.domain.entity.audit.DateAudit;
import com.serranoz.baserestapi.repository.BaseRepository;
import com.serranoz.baserestapi.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<
    E extends DateAudit, ID extends Long, R extends BaseRepository<E, ID>> {

  private final BaseService<E, ID, R> service;

  protected BaseController(BaseService<E, ID, R> service) {
    this.service = service;
  }

  public BaseService<E, ID, R> getService() {
    return service;
  }

  @GetMapping
  public ResponseEntity<List<E>> findAll() {
    return ResponseEntity.ok().body(service.findAll());
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<E> findById(@PathVariable ID id) {
    return ResponseEntity.ok().body(service.findById(id));
  }

  @PostMapping
  public ResponseEntity<E> create(@RequestBody E e) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(e));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<E> deleteById(@PathVariable ID id) {
    return ResponseEntity.ok().body(service.deleteById(id));
  }
}
