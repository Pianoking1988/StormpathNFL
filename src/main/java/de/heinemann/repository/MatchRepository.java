package de.heinemann.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.heinemann.domain.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {

	public List<Match> findAllByOrderByIdAsc();
	
}
