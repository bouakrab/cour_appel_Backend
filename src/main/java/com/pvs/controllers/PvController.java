package com.pvs.controllers;

import com.pvs.entities.DataParties;
import com.pvs.entities.Pv;
import com.pvs.repositories.DataPartiesRepository;
import com.pvs.repositories.PvRepository;
import com.pvs.services.ServicesInterfaces.PvServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;


@RequestMapping("/pv")
@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class PvController {

    @Autowired
    private PvServiceInterface pvService;
    @Autowired
    private PvRepository pvRepository;
    @Autowired
    private DataPartiesRepository dataPartiesRepository;
    // get all pv:
    @GetMapping(path = "/all")
    public List<Pv> getPvs() {
        return pvService.getAll().stream().toList();
    }
    @GetMapping(path = "/{id}")
    public Optional<Pv> getPvById(@PathVariable(name = "id") Long id) {
        return pvRepository.findById(id);
    }

    // add new pv
    @PostMapping(path = "/add")
    public Pv NewPv(@RequestBody Pv pv){
          pvService.add(pv);
          return pv;
    }

    @PutMapping (path = "/update/{id}")
    public Pv updatePv(@RequestBody Pv pv,@PathVariable(name = "id") Long id){
        pv.setId(id);
        pvService.add(pv);
        return pv;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        pvService.delete(id);
    }

    @GetMapping("/findByUuid/{uuid}")
    public Optional<Pv> findPvByUuid(@PathVariable String uuid){
        return Optional.ofNullable(pvRepository.findByUuid(uuid));
    }
  // add pv to datapartie
  @PutMapping("/pvToDp/{numCart}/{id}")
  public  Pv pvToDp(@PathVariable String numCart,@PathVariable Long id){
     Pv pv =pvRepository.findPvById(id);
     DataParties dataParties=dataPartiesRepository.findByNumCart(numCart);
      if (pv.getDataParties()!=null) {
          pv.getDataParties().add(dataParties);
          dataParties.getPv().add(pv);
      }
      return pvRepository.save(pv);
  }

  /*  @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        File convertFile = new File("/upload/"+file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return "File is upload successfully";
    }

   */
  @PostMapping("/upload")
  public String handleFileUpload(@RequestParam("file") MultipartFile file ) {

      String destination =".\\uploads\\"+file.getOriginalFilename();
      try {
            Files.copy(
                    file.getInputStream(),
                    Paths.get(destination),StandardCopyOption.REPLACE_EXISTING
            );
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
      return "File uploaded successfully.";
  }

    @GetMapping(path = "/dpsByPv/{id}")
    public List<DataParties> getDpOfpv(@PathVariable(name = "id") Long id) {
          Optional<Pv> pv=getPvById(Long.valueOf(id));
        return dataPartiesRepository.findAllByPv(pv).stream().toList();
    }
}
