package mybootapp.service;

import mybootapp.model.Composante;
import mybootapp.model.Utilisateur;
import org.springframework.stereotype.Service;

@Service
public class PermissionManager {

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
        if(composante.getCorrespondant().getIdUtilisateur().equals(utilisateur.getIdUtilisateur()) ) composante.setCorrespondant(utilisateur);
    }

}










