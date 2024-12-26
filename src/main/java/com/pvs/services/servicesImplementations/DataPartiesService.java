package com.pvs.services.servicesImplementations;

import com.pvs.entities.DataParties;
import com.pvs.repositories.DataPartiesRepository;
import com.pvs.services.ServicesInterfaces.DataPartiesServiceInterface;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Data
@Getter
@Setter
@Service
public class DataPartiesService  implements DataPartiesServiceInterface {

    @Autowired
    private DataPartiesRepository dataPartiesRepository;

    @Override
    public List<DataParties> getByListOfNumCarts(List<String> numCarts) {
        return dataPartiesRepository.findByListOfNumCart(numCarts);
    }

    // get all pvs:
    public List<DataParties> getAll(){
        return dataPartiesRepository.findAll();
    }

    // get a specific Pv by it Id:
    public Optional<DataParties> retrieveStudent(@PathVariable(name = "id") Long id){
        return dataPartiesRepository.findById(id);
    }

    @Override
    public DataParties getDataPartieByNumCart(String numCart) {
        return dataPartiesRepository.findByNumCart(numCart);
    }

    // Add new Pv:
    public DataParties add(DataParties dataPartie){
        return dataPartiesRepository.save(dataPartie);

    }

    public List<DataParties> addList(List<DataParties>  dataParties){
        return dataPartiesRepository.saveAll(dataParties);

    }

    // update an existing pv using its Id:
    public DataParties update(@PathVariable(name = "id") Long id,@RequestBody DataParties dataPartie){
        dataPartie.setId(id);
        return dataPartiesRepository.save(dataPartie);
    }

    @Override
    public DataParties updateByNumCart(String numCart, DataParties dataPartie) {
       DataParties dp= getDataPartieByNumCart(numCart);
        dataPartie.setId(dp.getId());
        return dataPartiesRepository.save(dataPartie);
    }

    // Delete Pv :
    public void delete(Long id){
        dataPartiesRepository.deleteById(id);
    }
}
