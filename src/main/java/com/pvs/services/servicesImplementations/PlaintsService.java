package com.pvs.services.servicesImplementations;

import com.pvs.entities.DataParties;
import com.pvs.entities.Plaints;
import com.pvs.entities.Pv;
import com.pvs.repositories.DataPartiesRepository;
import com.pvs.repositories.PlaintsRepository;
import com.pvs.services.ServicesInterfaces.PlaintsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaintsService implements PlaintsServiceInterface {
    @Autowired
     private PlaintsRepository plaintsRepository;
    @Autowired
    private DataPartiesRepository dataPartiesRepository;

    @Override
    public List<Plaints> getAll() {
        return plaintsRepository.findAll();
    }

    @Override
    public Optional<Plaints> getById(Long id) {
        return plaintsRepository.findById(id);
    }

    @Override
    public Plaints add(Plaints plaints) {
        return plaintsRepository.save(plaints);
    }

    @Override
    public Plaints update(Long id, Plaints plaints) {
        plaints.setId(id);
        return plaintsRepository.save(plaints);
    }

    @Override
    public void delete(Long id) {
        plaintsRepository.deleteById(id);
    }

    public  void pvToDp( String numCart,int id){
        Plaints plaints =plaintsRepository.findPlaintsById(id);
        DataParties dataParties=dataPartiesRepository.findByNumCart(numCart);
        if (plaints.getDataParties()!=null) {
            plaints.getDataParties().add(dataParties);
            dataParties.getPlaints().add(plaints);
        }
        //pvRepository.save(pv);
    }
}
