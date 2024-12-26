package com.pvs.controllers;

import com.pvs.entities.TypePoliceJudic;
import com.pvs.services.servicesImplementations.TypePoliceJudicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/typepolicejudic")
@RestController
public class TypePoliceJudicController {
    @Autowired
    private TypePoliceJudicService typePoliceJudicService;
    // get all pv:
    @GetMapping(path = "/all")
    public List<TypePoliceJudic> getSourcePvs() {
        return typePoliceJudicService.getTypePoliceJudic();
    }


    // add new pv
    @PostMapping(path = "/add")
    public void NewPv(@RequestBody TypePoliceJudic typePoliceJudic){
        typePoliceJudicService.addNewTypePoliceJudic(typePoliceJudic);
    }



    @DeleteMapping("/deletePv/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        typePoliceJudicService.deleteTypePoliceJudic(id);
    }

}
