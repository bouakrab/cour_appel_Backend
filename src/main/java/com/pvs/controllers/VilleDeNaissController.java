package com.pvs.controllers;

import com.pvs.entities.Pv;
import com.pvs.entities.VilleDeNaiss;
import com.pvs.services.ServicesInterfaces.PvServiceInterface;
import com.pvs.services.ServicesInterfaces.VilleDeNaissInterface;
import com.pvs.services.servicesImplementations.VilleDeNaissService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/VilleDeNaiss")
@RestController
public class VilleDeNaissController {

    @Autowired
    private VilleDeNaissInterface villeDeNaissInterface;

    @GetMapping(path = "/all")
    public List<VilleDeNaiss> getPvs() {
        return villeDeNaissInterface.getAll();
    }


    // add new pv
    @PostMapping(path = "/add")
    public VilleDeNaiss NewPv(@RequestBody VilleDeNaiss villeDeNaiss){
        villeDeNaissInterface.add(villeDeNaiss);
        return villeDeNaiss;
    }



    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        villeDeNaissInterface.delete(id);
    }

}
