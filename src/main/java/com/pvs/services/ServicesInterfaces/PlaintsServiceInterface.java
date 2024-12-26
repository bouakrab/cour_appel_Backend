package com.pvs.services.ServicesInterfaces;

import com.pvs.entities.Plaints;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface PlaintsServiceInterface {
    public List<Plaints> getAll();
    public Optional<Plaints> getById(@PathVariable(name = "id") Long id);
    public Plaints add(Plaints plaints);
    public Plaints update(@PathVariable(name = "id") Long id,@RequestBody Plaints plaints);
    public void delete(Long id);
}
