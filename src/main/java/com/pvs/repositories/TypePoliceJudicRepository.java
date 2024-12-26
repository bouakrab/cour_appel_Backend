package com.pvs.repositories;

import com.pvs.entities.TypePoliceJudic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePoliceJudicRepository extends JpaRepository<TypePoliceJudic,Long> {
}
