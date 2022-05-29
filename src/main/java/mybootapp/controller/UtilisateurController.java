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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
        c1.setIntitule("Faculté des sciences");
        Composante c2 = new Composante();
        c2.setIntitule("Faculté d'économie");

        Utilisateur utilisateur1 = new Utilisateur();
        Utilisateur utilisateur2 = new Utilisateur();
        Utilisateur utilisateur3 = new Utilisateur();


        composanteRepo.save(c1);
        composanteRepo.save(c2);


        utilisateur1.setEstAdmin(false);
        utilisateur1.setComposante(c1);
        utilisateur1.setNom("HALLAI");
        utilisateur1.setPrenom("Katia");

        utilisateur2.setEstAdmin(true);
        utilisateur2.setComposante(c2);
        utilisateur2.setNom("SELLAH");
        utilisateur2.setPrenom("Lysa");

        utilisateur3.setEstAdmin(false);
        utilisateur3.setComposante(c1);
        utilisateur3.setNom("miao");
        utilisateur3.setPrenom("miao");

        utilisateurRepo.save(utilisateur1);
        utilisateurRepo.save(utilisateur2);
        utilisateurRepo.save(utilisateur3);

    }



    @RequestMapping(value = "/gestionDesRoles")
    public ModelAndView gestionDesRoles() {

        return new ModelAndView("listUtilisateur", "utilisateurs", utilisateurRepo.findAll());
    }

/*
    @RequestMapping(value = "/editRole/{id}")
    public ModelAndView editRole(@PathVariable Long id) {


        if(utilisateurRepo.findById(id).isPresent()){
            Utilisateur utilisateur = utilisateurRepo.findById(id).get();
            if(utilisateur.isEstAdmin()) {
            permissionManager.removeAdmin(utilisateur);
            utilisateurRepo.save(utilisateur);
            }
            permissionManager.AddAdmin(utilisateur);
            utilisateurRepo.save(utilisateur);
        }

        return new ModelAndView("listUtilisateur", "utilisateurs", utilisateurRepo.findAll());
    }
*/

    @RequestMapping(value = "/editRoleUser/{id}")
    public ModelAndView editRole(@PathVariable Long id) {


        if(utilisateurRepo.findById(id).isPresent()){
            Utilisateur utilisateur = utilisateurRepo.findById(id).get();
            if(utilisateur.isEstAdmin()) {
                permissionManager.removeAdmin(utilisateur);

            }
            else {
                permissionManager.AddAdmin(utilisateur);
            }
            utilisateurRepo.save(utilisateur);
        }
        return new ModelAndView("listUtilisateur", "utilisateurs", utilisateurRepo.findAll());
    }





}
