package com.pvs.repositories;


import com.pvs.entities.VilleDeNaiss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface VilleDeNaissRepository extends JpaRepository<VilleDeNaiss,Long>{
}
