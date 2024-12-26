package com.pvs.repositories;

import com.pvs.entities.SourcePvs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourcePvsRepository extends JpaRepository<SourcePvs,Long> {
}
