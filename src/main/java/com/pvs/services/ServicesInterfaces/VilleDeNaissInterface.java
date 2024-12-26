package com.pvs.services.ServicesInterfaces;

import com.pvs.entities.Pv;
import com.pvs.entities.VilleDeNaiss;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface VilleDeNaissInterface {

    public List<VilleDeNaiss> getAll();
    public Optional<VilleDeNaiss> retrieve(@PathVariable(name = "id") Long id);
    public VilleDeNaiss add(VilleDeNaiss villeDeNaiss);
    public VilleDeNaiss update(@PathVariable(name = "id") Long id,@RequestBody VilleDeNaiss villeDeNaiss);
    public void delete(Long id);
}
