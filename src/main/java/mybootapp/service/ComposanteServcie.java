package mybootapp.service;

import mybootapp.model.Adresse;
import mybootapp.model.Composante;
import mybootapp.model.Utilisateur;
import mybootapp.repo.ComposanteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComposanteServcie {

    @Autowired
    ComposanteRepo composanteRepo;

    public Long getIdComposanteWithAdress(Adresse adresse){
        List<Composante> composantes = composanteRepo.findAll();
        for(Composante composante: composantes){
            if(composante.getAdresses().contains(adresse)){
                return composante.getId();
            }
        }
        return null;
    }
    public Long getIdComposanteWithUtilisateur(Utilisateur utilisateur){
        List<Composante> composantes = composanteRepo.findAll();
       if (composantes.contains(utilisateur.getIdComposante()))
           return utilisateur.getIdComposante().getId();
       return null;
    }

    }
