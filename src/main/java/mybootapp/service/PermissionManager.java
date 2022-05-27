package mybootapp.service;

import mybootapp.model.Composante;
import mybootapp.model.Utilisateur;
import mybootapp.repo.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionManager {

    @Autowired
    UtilisateurRepo utilisateurRepo;


    public void AddAdmin (Utilisateur utilisateur){
        utilisateur.setEstAdmin(true);

    }

    public void removeAdmin (Utilisateur utilisateur){
        utilisateur.setEstAdmin(false);
    }

    public  void addCorrespondantToComposante (Utilisateur utilisateur, Composante composante){
        if(utilisateur.getIdComposante().equals(composante.getId())) composante.setCorrespondant(utilisateur);
    }

    public  void removeCorrespondantFromComposante (Utilisateur utilisateur, Composante composante){
        if(utilisateur.getIdComposante().equals(composante)) utilisateur.setIdComposante(null);
    }

    public void moveCorrespondantToOtherComposante ( Utilisateur utilisateur, Composante composante, Composante other){
        if(utilisateur.getIdComposante().equals(composante)) utilisateur.setIdComposante(other);
    }

}










