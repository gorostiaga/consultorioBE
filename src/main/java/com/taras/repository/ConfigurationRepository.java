package com.taras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taras.model.Configuration;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {

}
