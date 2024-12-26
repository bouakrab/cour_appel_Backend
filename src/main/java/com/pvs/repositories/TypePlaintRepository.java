package com.pvs.repositories;

import com.pvs.entities.TypePlaints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePlaintRepository extends JpaRepository<TypePlaints,Long> {
}
