package mybootapp.model;

import mybootapp.repo.ComposanteRepo;
import mybootapp.repo.FormationRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DataTest {



    @Autowired
    FormationRepo formationRepo;

    @Autowired
    ComposanteRepo composanteRepo;



    @Test
    public void formationGenerator(){
        assertEquals(4, formationRepo.findAll().size());
    }

    @Test
    public void composanteGenerator(){
        assertEquals(2, composanteRepo.findAll().size());
    }


    @Test
    public void adresseComposante(){
        Adresse adresse = new Adresse();
        String ligne = "163 Av. de Luminy, 13009 Marseille";
        adresse.setLigne(ligne);
       Collection<Adresse> compoAdresse = composanteRepo.findAll().get(0).getAdresses();
        assertTrue(compoAdresse.contains(adresse));

    }

}
