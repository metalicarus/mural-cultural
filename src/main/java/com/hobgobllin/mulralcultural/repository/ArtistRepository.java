package com.hobgobllin.mulralcultural.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hobgobllin.mulralcultural.entity.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {}