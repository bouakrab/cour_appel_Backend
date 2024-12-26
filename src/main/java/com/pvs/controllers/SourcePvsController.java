package com.pvs.controllers;

import com.pvs.entities.SourcePvs;
import com.pvs.services.servicesImplementations.SourcePvsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/sourcepvs")
@RestController
public class SourcePvsController {
    @Autowired
    private SourcePvsService sourcePvsService;
    // get all pv:
    @GetMapping(path = "/all")
    public List<SourcePvs> getSourcePvs() {
        return sourcePvsService.getSourcePvs();
    }


    // add new pv
    @PostMapping(path = "/add")
    public void NewPv(@RequestBody SourcePvs sourcePvs){
        sourcePvsService.addNewSourcePvs(sourcePvs);
    }



    @DeleteMapping("/deletePv/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        sourcePvsService.deleteSourcePvs(id);
    }

}
