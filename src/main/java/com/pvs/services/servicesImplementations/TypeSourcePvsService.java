package com.pvs.services.servicesImplementations;

import com.pvs.entities.TypeSourcePvs;
import com.pvs.repositories.TypeSourcePvsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TypeSourcePvsService {
    @Autowired
    private TypeSourcePvsRepository sourcePvsRepository;

    // get all TypeSourcePvs:
    public List<TypeSourcePvs> getTypeSourcePvs(){
        return sourcePvsRepository.findAll();
    }


    // Add new TypePoliceJudic:
    public TypeSourcePvs addNewTypeSourcePvs(TypeSourcePvs typeSourcePvs){
        return sourcePvsRepository.save(typeSourcePvs);

    }

    // update an existing TypeSourcePvs using its Id:
    public TypeSourcePvs updateTypeSourcePvs(@PathVariable(name = "id") Long id, @RequestBody TypeSourcePvs  typeSourcePvs){
        typeSourcePvs.setId(id);
        return sourcePvsRepository.save(typeSourcePvs);
    }

    // Delete TypeSourcePvs :
    public void deleteTypeSourcePvs(Long id){
        sourcePvsRepository.deleteById(id);
    }
}
