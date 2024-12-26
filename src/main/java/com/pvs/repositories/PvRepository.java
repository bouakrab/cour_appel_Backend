package com.pvs.repositories;

import com.pvs.entities.Pv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PvRepository extends  JpaRepository<Pv,Long>{
     public Pv findByUuid(@Param(value="uuid") String uuid);
     Pv findPvById(long id);
}
