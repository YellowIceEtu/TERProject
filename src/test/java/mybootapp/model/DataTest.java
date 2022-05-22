package mybootapp.model;

import mybootapp.repo.ComposanteRepo;
import mybootapp.repo.FormationRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
