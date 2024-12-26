package com.pvs.services.servicesImplementations;

import com.pvs.entities.SourcePvs;
import com.pvs.repositories.SourcePvsRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Data
@Getter
@Setter
@Service
public class SourcePvsService {
    @Autowired
    private SourcePvsRepository sourcePvsRepository;

    // get all SourcePvs:
    public List<SourcePvs> getSourcePvs(){
        return sourcePvsRepository.findAll();
    }


    // Add new SourcePvs:
    public SourcePvs addNewSourcePvs(SourcePvs sourcePvs){
        return sourcePvsRepository.save(sourcePvs);

    }

    // update an existing SourcePvs using its Id:
    public SourcePvs updatePv(@PathVariable(name = "id") Long id, @RequestBody SourcePvs sourcePvs){
        sourcePvs.setId(id);
        return sourcePvsRepository.save(sourcePvs);
    }

    // Delete SourcePvs :
    public void deleteSourcePvs(Long id){
        sourcePvsRepository.deleteById(id);
    }
}
