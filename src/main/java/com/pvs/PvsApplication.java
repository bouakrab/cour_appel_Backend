package com.pvs;

import com.pvs.entities.*;
import com.pvs.repositories.*;


import com.pvs.security.entities.AppRole;
import com.pvs.security.service.AccountService;
import com.pvs.services.servicesImplementations.PvService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;


@SpringBootApplication
public class PvsApplication implements CommandLineRunner {
    @Autowired
    private SourcePvsRepository sourcePvsRepository;
    @Autowired
    private TypePoliceJudicRepository typePoliceJudicRepository;
    @Autowired
    private TypeSourcePvsRepository typeSourcePvsRepository;
    @Autowired
    private PvRepository pvRepository;

    @Autowired
    private PvService pvService;
    @Autowired
    private VilleDeNaissRepository villeDeNaissRepository;


    @Autowired
    private SourcePlaintsRepository sourcePlaintsRepository;

    @Autowired
    private TypePlaintRepository typePlaintRepository;
     @Autowired
     private AccountService accountService;


    @Bean
    public WebMvcConfigurer corsConfiguer(){

       return new WebMvcConfigurer() {
           @Override
           public void addCorsMappings(CorsRegistry registry) {
               registry.addMapping("/**").allowedHeaders("*").allowedOrigins("http://localhost:4200").allowedMethods("*").allowCredentials(false);
           }
       };

    }
    public static void main(String[] args) {
        SpringApplication.run(PvsApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        // Create Source Pvs Data
        SourcePvs sp = sourcePvsRepository.save(new SourcePvs(1, "محلي", null));
        sourcePvsRepository.save(new SourcePvs("انابة",null));
        sourcePvsRepository.save(new SourcePvs("اختصاص",null));

        //Create Type polic Judic Data
        TypePoliceJudic tpj = typePoliceJudicRepository.save(new TypePoliceJudic( "الوكلاء العامون للملك", null, null));
        typePoliceJudicRepository.save(new TypePoliceJudic(2,"ضباط الشرطة القضائية.",null,null));
        typePoliceJudicRepository.save(new TypePoliceJudic(3,"أعوان الشرطة القضائية.",null,null));
        typePoliceJudicRepository.save(new TypePoliceJudic(4,"الوكيل العام للملك",null,null));
        typePoliceJudicRepository.save(new TypePoliceJudic(5,"قضاة التحقيق بمحاكم الإستئناف",null,null));

       // Create typeSourcePvsRepository data:
        TypeSourcePvs tsp = typeSourcePvsRepository.save(new TypeSourcePvs(1, "data1", null, null));
        typeSourcePvsRepository.save(new TypeSourcePvs(2,"data2",null,null));
        typeSourcePvsRepository.save(new TypeSourcePvs(3,"data3",null,null));

        pvRepository.save(new Pv(1,tsp,sp,tpj,204,new Date(),"13:56",true,"pv subject1",null,null));
        pvRepository.save(new Pv(2,tsp,sp,tpj,678,new Date(),"23:45",false,"pv subject2",null,null));
        pvRepository.save(new Pv(3,tsp,sp,tpj,234,new Date(),"09:34",true,"pv subject3",null,null));
        pvRepository.save(new Pv(1,tsp,sp,tpj,204,new Date(),"13:56",true,"pv subject1",null,null));
        pvRepository.save(new Pv(2,tsp,sp,tpj,678,new Date(),"23:45",false,"pv subject2",null,null));
        pvRepository.save(new Pv(3,tsp,sp,tpj,234,new Date(),"09:34",true,"pv subject3",null,null));
        pvRepository.save(new Pv(1,tsp,sp,tpj,204,new Date(),"13:56",true,"pv subject1",null,null));
        pvRepository.save(new Pv(2,tsp,sp,tpj,678,new Date(),"23:45",false,"pv subject2",null,null));
        pvRepository.save(new Pv(3,tsp,sp,tpj,234,new Date(),"09:34",true,"pv subject3",null,null));
        pvRepository.save(new Pv(1,tsp,sp,tpj,204,new Date(),"13:56",true,"pv subject1",null,null));
        pvRepository.save(new Pv(2,tsp,sp,tpj,678,new Date(),"23:45",false,"pv subject2",null,null));
        pvRepository.save(new Pv(3,tsp,sp,tpj,234,new Date(),"09:34",true,"pv subject3",null,null));
        pvRepository.save(new Pv(1,tsp,sp,tpj,204,new Date(),"13:56",true,"pv subject1",null,null));
        pvRepository.save(new Pv(2,tsp,sp,tpj,678,new Date(),"23:45",false,"pv subject2",null,null));
        pvRepository.save(new Pv(3,tsp,sp,tpj,234,new Date(),"09:34",true,"pv subject3",null,null));
        pvRepository.save(new Pv(1,tsp,sp,tpj,204,new Date(),"13:56",true,"pv subject1",null,null));
        pvRepository.save(new Pv(2,tsp,sp,tpj,678,new Date(),"23:45",false,"pv subject2",null,null));
        pvRepository.save(new Pv(3,tsp,sp,tpj,234,new Date(),"09:34",true,"pv subject3",null,null));
        pvRepository.save(new Pv(1,tsp,sp,tpj,204,new Date(),"13:56",true,"pv subject1",null,null));
        pvRepository.save(new Pv(2,tsp,sp,tpj,678,new Date(),"23:45",false,"pv subject2",null,null));
        pvRepository.save(new Pv(3,tsp,sp,tpj,234,new Date(),"09:34",true,"pv subject3",null,null));
        pvRepository.save(new Pv(1,tsp,sp,tpj,204,new Date(),"13:56",true,"pv subject1",null,null));
        pvRepository.save(new Pv(2,tsp,sp,tpj,678,new Date(),"23:45",false,"pv subject2",null,null));
        pvRepository.save(new Pv(3,tsp,sp,tpj,234,new Date(),"09:34",true,"pv subject3",null,null));
        // pvService.pvToDp("PB255874", 10);

      // Create Ville data:
        villeDeNaissRepository.save(new VilleDeNaiss(1,"Rabat",null));
        villeDeNaissRepository.save(new VilleDeNaiss(1,"Marrakesh",null));
        villeDeNaissRepository.save(new VilleDeNaiss(1,"Beni mellal",null));
        //Create Roles:

        //Create Users:
       // appUserRepository.save(new AppUser(1,"admin","admin@gmail.com","admin","123456",new ArrayList<>()));
       // accountService.addNewUser(new AppUser(1,"admin","admin@gmail.com","admin","123456",new ArrayList<>()));

        // Add Source Plaints
        sourcePlaintsRepository.save(new SourcePlaints(1,"source 1",null));
        sourcePlaintsRepository.save(new SourcePlaints(2,"source 2",null));
        sourcePlaintsRepository.save(new SourcePlaints(3,"source 3",null));
       // Add Type Plaints
        typePlaintRepository.save(new TypePlaints(1,"Type 1",null));
        typePlaintRepository.save(new TypePlaints(2,"Type 2",null));
        typePlaintRepository.save(new TypePlaints(3,"Type 3",null));

        accountService.save(new AppRole(null,"USER"));
        accountService.save(new AppRole(null,"ADMIN"));
        Stream.of("user1","user2","user3","admin").forEach(un->{
            accountService.saveUser(un,"123456","123456");
        });
        accountService.addRoleToUser("admin","ADMIN");


    }

    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }
}
