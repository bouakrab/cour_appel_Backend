package com.pvs.repositories;

import com.pvs.entities.DataParties;
import com.pvs.entities.Pv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DataPartiesRepository extends JpaRepository<DataParties,Long> {
    DataParties findByNumCart(String numCart);
    List<DataParties>   findAllByPv(Optional<Pv> pv);
    @Query("select d from DataParties d where d.numCart in :numCarts")
    List<DataParties> findByListOfNumCart(@Param("numCarts") List<String> numCarts);
}
