package com.pvs.repositories;

import com.pvs.entities.SourcePlaints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface SourcePlaintsRepository extends JpaRepository<SourcePlaints,Long> {
}
