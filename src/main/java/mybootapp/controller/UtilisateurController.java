package mybootapp.controller;


import mybootapp.model.Utilisateur;
import mybootapp.repo.UtilisateurRepo;
import mybootapp.service.PermissionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class UtilisateurController {

    @Autowired
    PermissionManager permissionManager ;

    @Autowired
    UtilisateurRepo utilisateurRepo ;


    @RequestMapping(value = "/addAdmin/{id}")
    public String addAdminRole(@PathVariable Long id) {

        if(utilisateurRepo.findById(id).isPresent()){
            Utilisateur utilisateur = utilisateurRepo.findById(id).get();
            permissionManager.AddAdmin(utilisateur);
        }

        return "redirect:/listAdmin";
    }
}
