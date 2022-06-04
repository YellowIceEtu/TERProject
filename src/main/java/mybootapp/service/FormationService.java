package mybootapp.service;

import mybootapp.model.Adresse;
import mybootapp.model.Composante;
import mybootapp.model.Formation;
import mybootapp.model.Session;
import mybootapp.repo.ComposanteRepo;
import mybootapp.repo.FormationRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FormationService {

    @Autowired
    FormationRepo formationRepo;

    public Long getIdFormationWithSession(Session session){
        List<Formation> formations = formationRepo.findAll();
        for(Formation formation: formations){
            if(formation.getAction().getSessions().contains(session)){
                return formation.getId();
            }
        }
        return null;
    }
}
