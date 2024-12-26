package com.pvs.controllers;

import com.pvs.entities.SourcePlaints;
import com.pvs.entities.SourcePvs;
import com.pvs.repositories.SourcePlaintsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/sourcePlaints")
@RestController
public class SourcePlaintsController {
    @Autowired
    private SourcePlaintsRepository plaintsRepository;

    @GetMapping(path = "/all")
    public List<SourcePlaints> getSourcePvs(){
        return plaintsRepository.findAll();
    }


    // Add new SourcePvs:
    public SourcePlaints addNewSourcePvs(SourcePlaints sourcePlaints){
        return plaintsRepository.save(sourcePlaints);

    }

    // update an existing SourcePvs using its Id:
    public SourcePlaints updatePv(@PathVariable(name = "id") Long id, @RequestBody SourcePlaints sourcePlaints){
        sourcePlaints.setId(id);
        return plaintsRepository.save(sourcePlaints);
    }

    // Delete SourcePvs :
    public void deleteSourcePvs(Long id){
        plaintsRepository.deleteById(id);
    }
}
