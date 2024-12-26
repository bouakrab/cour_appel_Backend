package com.pvs.services.servicesImplementations;

import com.pvs.entities.VilleDeNaiss;
import com.pvs.repositories.VilleDeNaissRepository;
import com.pvs.services.ServicesInterfaces.VilleDeNaissInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VilleDeNaissService implements VilleDeNaissInterface {
    @Autowired
    private VilleDeNaissRepository villeDeNaissRepository;
    @Override
    public List<VilleDeNaiss> getAll() {
        return villeDeNaissRepository.findAll();
    }

    @Override
    public Optional<VilleDeNaiss> retrieve(Long id) {
        return Optional.empty();
    }

    @Override
    public VilleDeNaiss add(VilleDeNaiss villeDeNaiss) {
        return villeDeNaissRepository.save(villeDeNaiss);
    }

    @Override
    public VilleDeNaiss update(Long id, VilleDeNaiss villeDeNaiss) {
        villeDeNaiss.setId(id);
        return villeDeNaissRepository.save(villeDeNaiss);
    }

    @Override
    public void delete(Long id) {
        villeDeNaissRepository.deleteById(id);
    }
}
