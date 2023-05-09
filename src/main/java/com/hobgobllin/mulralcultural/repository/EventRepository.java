package com.hobgobllin.mulralcultural.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hobgobllin.mulralcultural.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {}