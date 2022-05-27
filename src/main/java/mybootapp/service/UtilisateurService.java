package mybootapp.service;

import mybootapp.model.Utilisateur;
import mybootapp.repo.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepo utilisateurRepo;




    public boolean findByidCAS(String idCAS){
        return false;

    }
}
