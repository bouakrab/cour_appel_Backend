package com.pvs.controllers;

import com.pvs.entities.TypeSourcePvs;
import com.pvs.services.servicesImplementations.TypeSourcePvsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/typesourcepvs")
@RestController
public class TypeSourcePvsController {

    @Autowired
    private TypeSourcePvsService typeSourcePvsService;
    // get all TypeSourcePvs:
    @GetMapping(path = "/all")
    public List<TypeSourcePvs> getSourcePvs() {
        return typeSourcePvsService.getTypeSourcePvs();
    }


    // add new TypeSourcePvs:
    @PostMapping(path = "/add")
    public void NewPv(@RequestBody TypeSourcePvs typeSourcePvs){
        typeSourcePvsService.addNewTypeSourcePvs(typeSourcePvs);
    }


    // Delete TypeSourcePvs:
    @DeleteMapping("/deletePv/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        typeSourcePvsService.deleteTypeSourcePvs(id);
    }
}
