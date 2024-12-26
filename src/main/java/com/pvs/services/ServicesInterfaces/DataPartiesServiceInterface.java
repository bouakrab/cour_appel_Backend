package com.pvs.services.ServicesInterfaces;

import com.pvs.entities.DataParties;
import com.pvs.repositories.DataPartiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface DataPartiesServiceInterface{

    public List<DataParties> getByListOfNumCarts(@PathVariable(name = "numCarts") List<String> numCarts);
    List<DataParties> getAll();

    // get a specific Pv by it Id:
    public Optional<DataParties> retrieveStudent(@PathVariable(name = "id") Long id);
    DataParties getDataPartieByNumCart(@PathVariable(name = "numCart") String numCart);
    // Add new Pv:
    public DataParties add(DataParties dataPartie);
    public List<DataParties> addList(List<DataParties>  dataParties);
    // update an existing pv using its Id:
    public DataParties update(@PathVariable(name = "id") Long id,@RequestBody DataParties dataPartie);
    DataParties updateByNumCart(String numCart,DataParties dataPartie);
    // Delete Pv :
    public void delete(Long id);
}
