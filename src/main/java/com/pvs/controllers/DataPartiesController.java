package com.pvs.controllers;

import com.pvs.entities.DataParties;
import com.pvs.services.ServicesInterfaces.DataPartiesServiceInterface;
import com.pvs.services.servicesImplementations.DataPartiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/dataparties")
@RestController
public class DataPartiesController {

    @Autowired
    private DataPartiesServiceInterface dataPartiesService;

    // get all data parties:
    @GetMapping(path = "/all")
    public List<DataParties> getPvs() {
        return dataPartiesService.getAll();
    }


    // add new data partie
    @PostMapping(path = "/add")
    public void NewPv(@RequestBody DataParties dataPartie){
        dataPartiesService.add(dataPartie);
    }

    // add new list data partie
    @PostMapping(path = "/addList")
    public void NewDpList(@RequestBody List<DataParties>  dataPartie){
        dataPartiesService.addList(dataPartie);
    }

    // delete data partie
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        dataPartiesService.delete(id);
    }
    @GetMapping("/getByNumCart/{numCart}")
    public Optional<DataParties> getByNumCart(@PathVariable(name = "numCart") String numCart){
       return Optional.ofNullable(dataPartiesService.getDataPartieByNumCart(numCart));
    }

    @PutMapping(path = "/updateDp/{id}")
    public void updateDP(@PathVariable(name = "id") Long id,@RequestBody DataParties  dataPartie){
        dataPartiesService.update(id,dataPartie);
    }

    @GetMapping("/getByListNumCart/{numCarts}")
    public List<DataParties> getListByNumCart(@RequestParam(value = "numCarts[]") List<String> numCarts){
        return (List<DataParties>) dataPartiesService.getDataPartieByNumCart(String.valueOf(numCarts));
    }
}
