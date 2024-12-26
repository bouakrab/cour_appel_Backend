package com.pvs.controllers;

import com.pvs.entities.SourcePlaints;
import com.pvs.entities.TypePlaints;
import com.pvs.repositories.SourcePlaintsRepository;
import com.pvs.repositories.TypePlaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/typePlaints")
@RestController
public class TypePlaintsController {

    @Autowired
    private TypePlaintRepository typePlaintRepository;

    @GetMapping(path = "/all")
    public List<TypePlaints> getSourcePvs(){
        return typePlaintRepository.findAll();
    }


    // Add new SourcePvs:
    public TypePlaints addNewSourcePvs(TypePlaints typePlaints){
        return typePlaintRepository.save(typePlaints);

    }

    // update an existing SourcePvs using its Id:
    public TypePlaints updatePv(@PathVariable(name = "id") Long id, @RequestBody TypePlaints typePlaints){
        typePlaints.setId(id);
        return typePlaintRepository.save(typePlaints);
    }

    // Delete SourcePvs :
    public void deleteSourcePvs(Long id){
        typePlaintRepository.deleteById(id);
    }
}
