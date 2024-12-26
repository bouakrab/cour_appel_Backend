package com.pvs.services.servicesImplementations;

import com.pvs.entities.DataParties;
import com.pvs.entities.Pv;
import com.pvs.repositories.DataPartiesRepository;
import com.pvs.repositories.PvRepository;
import com.pvs.services.ServicesInterfaces.PvServiceInterface;
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
public class PvService implements PvServiceInterface {

    @Autowired
    private PvRepository pvRepository;

    @Autowired
    private DataPartiesRepository dataPartiesRepository;
    public Pv getPvByUuid(@PathVariable String uuid){
        Pv pv= pvRepository.findByUuid(uuid);
        return pv;
    }

    // get all pvs:
    public List<Pv> getAll(){
        return pvRepository.findAll();
    }

    // get a specific Pv by it Id:
    public Optional<Pv> retrieveStudent(@PathVariable(name = "id") Long id){
        return pvRepository.findById(id);
    }

    // Add new Pv:
    public Pv add(Pv pv){
        return pvRepository.save(pv);

    }

   // update an existing pv using its Id:
    public Pv update(@PathVariable(name = "id") Long id,@RequestBody Pv pv){
        pv.setId(id);
        return pvRepository.save(pv);
    }

    // Delete Pv :
    public void delete(Long id){
        pvRepository.deleteById(id);
    }

    public  void pvToDp( String numCart,int id){
        Pv pv =pvRepository.findPvById(id);
        DataParties dataParties=dataPartiesRepository.findByNumCart(numCart);
        if (pv.getDataParties()!=null) {
            pv.getDataParties().add(dataParties);
            dataParties.getPv().add(pv);
        }
        //pvRepository.save(pv);
    }

}
