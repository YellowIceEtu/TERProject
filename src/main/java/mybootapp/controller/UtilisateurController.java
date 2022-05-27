package mybootapp.controller;


import mybootapp.model.Adresse;
import mybootapp.model.Composante;
import mybootapp.model.Formation;
import mybootapp.model.Utilisateur;
import mybootapp.repo.ComposanteRepo;
import mybootapp.repo.UtilisateurRepo;
import mybootapp.service.PermissionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;

@RequestMapping("/admin")
@Controller
public class UtilisateurController {

    @Autowired
    PermissionManager permissionManager ;

    @Autowired
    UtilisateurRepo utilisateurRepo ;

    @Autowired
    ComposanteRepo composanteRepo ;


    @PostConstruct
    public void init(){

        Composante c1 = new Composante();
        Composante c2 = new Composante();

        Utilisateur utilisateur1 = new Utilisateur();
        Utilisateur utilisateur2 = new Utilisateur();
        Utilisateur utilisateur3 = new Utilisateur();


        composanteRepo.save(c1);
        composanteRepo.save(c2);



        utilisateur1.setEstAdmin(false);
        utilisateur1.setIdComposante(c1);
        utilisateur1.setNom("HALLAI");
        utilisateur1.setPrenom("Katia");
        utilisateur2.setEstAdmin(true);
        utilisateur2.setIdComposante(c2);
        utilisateur2.setNom("SELLAH");
        utilisateur2.setPrenom("Lysa");
        utilisateur3.setEstAdmin(false);
        utilisateur3.setIdComposante(c1);
        utilisateur3.setPrenom("miao");

        utilisateurRepo.save(utilisateur1);
        utilisateurRepo.save(utilisateur2);
        utilisateurRepo.save(utilisateur3);

    }

    /*
    @RequestMapping(value = "/gestionDesRole")
    public String addAdminRole(@PathVariable Long id) {

        if(utilisateurRepo.findById(id).isPresent()){
            Utilisateur utilisateur = utilisateurRepo.findById(id).get();
            permissionManager.AddAdmin(utilisateur);
        }

        return "redirect:/adminDetails";
    }
*/

    @RequestMapping(value = "/gestionDesRoles", method = RequestMethod.GET )
    public String gestionDesRoles(@ModelAttribute Utilisateur utilisateur) {return "listUtilisateur";}


}
