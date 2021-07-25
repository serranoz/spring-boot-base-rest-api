package com.serranoz.baserestapi.repository;

import com.serranoz.baserestapi.domain.entity.audit.DateAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E extends DateAudit, ID extends Long>
    extends JpaRepository<E, ID> {}
