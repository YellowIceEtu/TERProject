package mybootapp.service;

import mybootapp.model.Utilisateur;
import mybootapp.repo.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepo utilisateurRepo;




    public boolean findByidCAS(String idCAS){
        Collection<Utilisateur> utilisateurs = utilisateurRepo.findAll();
        for(Utilisateur utilisateur:utilisateurs){
            if (utilisateur.getIdCAS().equals(idCAS))
                return true;
        }
        return false;
    }
    public Utilisateur getByidCAS(String idCAS){
        Collection<Utilisateur> utilisateurs = utilisateurRepo.findAll();
        for(Utilisateur utilisateur:utilisateurs){
            if (utilisateur.getIdCAS().equals(idCAS))
                return utilisateur;
        }
        return null;
    }

    public Map<Utilisateur,Boolean> getAdmins(){
        Map<Utilisateur,Boolean> admins = new HashMap<>();
        Collection<Utilisateur> utilisateurs = utilisateurRepo.findAll();
        for(Utilisateur utilisateur:utilisateurs){
            admins.put(utilisateur,utilisateur.isAdmin());

        }
        return admins;

    }
}
