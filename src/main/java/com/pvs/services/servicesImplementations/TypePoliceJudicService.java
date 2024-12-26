package com.pvs.services.servicesImplementations;

import com.pvs.entities.TypePoliceJudic;
import com.pvs.repositories.TypePoliceJudicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TypePoliceJudicService {
    @Autowired
    private TypePoliceJudicRepository typePoliceJudicRepository;

    // get all TypePoliceJudic:
    public List<TypePoliceJudic> getTypePoliceJudic(){
        return typePoliceJudicRepository.findAll();
    }


    // Add new TypePoliceJudic:
    public TypePoliceJudic addNewTypePoliceJudic(TypePoliceJudic typePoliceJudic){
        return typePoliceJudicRepository.save(typePoliceJudic);

    }

    // update an existing TypePoliceJudic using its Id:
    public TypePoliceJudic updateTypePoliceJudic(@PathVariable(name = "id") Long id, @RequestBody TypePoliceJudic  typePoliceJudic){
        typePoliceJudic.setId(id);
        return typePoliceJudicRepository.save(typePoliceJudic);
    }

    // Delete TypePoliceJudic :
    public void deleteTypePoliceJudic(Long id){
        typePoliceJudicRepository.deleteById(id);
    }

}
