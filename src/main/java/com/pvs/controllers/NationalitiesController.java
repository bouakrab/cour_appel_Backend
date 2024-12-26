package com.pvs.controllers;

import com.pvs.entities.DataParties;
import com.pvs.entities.Nationalites;
import com.pvs.repositories.NationalitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class NationalitiesController {
    @Autowired
    private NationalitiesRepository nationalitiesRepository;

    // get all pvs:
    public List<Nationalites> getAll(){
        return nationalitiesRepository.findAll();
    }

    // get a specific Pv by it I
    // d:
    public Optional<Nationalites> retrieveStudent(@PathVariable(name = "id") Long id){
        return nationalitiesRepository.findById(id);
    }

    // Add new Pv:
    public Nationalites add(Nationalites dataPartie){
        return nationalitiesRepository.save(dataPartie);

    }

    public List<Nationalites> addList(List<Nationalites>  dataParties){
        return nationalitiesRepository.saveAll(dataParties);

    }

    // update an existing pv using its Id:
    public Nationalites update(@PathVariable(name = "id") Long id,@RequestBody Nationalites dataPartie){
        dataPartie.setId(id);
        return nationalitiesRepository.save(dataPartie);
    }


}
