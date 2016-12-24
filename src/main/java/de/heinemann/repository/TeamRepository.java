package de.heinemann.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.heinemann.domain.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

	public List<Team> findAllByOrderByIdAsc();
	
}
