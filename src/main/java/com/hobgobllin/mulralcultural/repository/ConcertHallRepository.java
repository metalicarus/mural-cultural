package com.hobgobllin.mulralcultural.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hobgobllin.mulralcultural.entity.ConcertHall;

@Repository
public interface ConcertHallRepository extends JpaRepository<ConcertHall, Long> {}