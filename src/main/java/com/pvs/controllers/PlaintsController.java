package com.pvs.controllers;

import com.pvs.entities.DataParties;
import com.pvs.entities.Plaints;
import com.pvs.entities.Pv;
import com.pvs.repositories.DataPartiesRepository;
import com.pvs.repositories.PlaintsRepository;
import com.pvs.services.ServicesInterfaces.PlaintsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/plaints")
@RestController
public class PlaintsController {

    @Autowired
    private PlaintsServiceInterface plaintsServiceInterface;
    @Autowired
    private PlaintsRepository plaintsRepository;
    @Autowired
    private DataPartiesRepository dataPartiesRepository;
    // get all pv:
    @GetMapping(path = "/all")
    public List<Plaints> getPvs() {
        return plaintsServiceInterface.getAll();
    }


    // add new pv
    @PostMapping(path = "/add")
    public Plaints NewPv(@RequestBody Plaints plaints){
        plaintsServiceInterface.add(plaints);
        return plaints;
    }



    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        plaintsServiceInterface.delete(id);
    }




    @PutMapping("/plaintToDp/{numCart}/{id}")
    public Plaints plaintToDp(@PathVariable String numCart, @PathVariable Long id){
        Plaints plaints =plaintsRepository.findPlaintsById(id);
        DataParties dataParties=dataPartiesRepository.findByNumCart(numCart);
        if (plaints.getDataParties()!=null) {
            plaints.getDataParties().add(dataParties);
            dataParties.getPlaints().add(plaints);
        }
        return plaintsRepository.save(plaints);
    }
}
