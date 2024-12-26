package com.pvs.services.ServicesInterfaces;

import com.pvs.entities.Pv;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface PvServiceInterface {
    public List<Pv> getAll();
    public Optional<Pv> retrieveStudent(@PathVariable(name = "id") Long id);
    public Pv add(Pv pv);
    public Pv update(@PathVariable(name = "id") Long id,@RequestBody Pv pv);
    public void delete(Long id);
    public Pv getPvByUuid(String uuid);

    public  void pvToDp( String numCart,int id);
}
