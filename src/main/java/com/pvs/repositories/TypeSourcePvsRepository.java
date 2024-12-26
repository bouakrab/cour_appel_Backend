package com.pvs.repositories;

import com.pvs.entities.TypeSourcePvs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeSourcePvsRepository extends JpaRepository<TypeSourcePvs,Long> {
}
