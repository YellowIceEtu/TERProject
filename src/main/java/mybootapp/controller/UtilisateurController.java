package mybootapp.controller;

import mybootapp.model.Adresse;
import mybootapp.model.Composante;
import mybootapp.model.Formation;
import mybootapp.model.Utilisateur;
import mybootapp.repo.ComposanteRepo;
import mybootapp.repo.UtilisateurRepo;
import mybootapp.service.AuthenticationService;
import mybootapp.web.CasUserDetailService;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class UtilisateurController {

    @Autowired
    UtilisateurRepo utilisateurRepo;
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    CasUserDetailService casUserDetailService;
    @Autowired
    ComposanteRepo composanteRepo;

    @PostConstruct
    public void init(){
     /*   SecurityContext context = SecurityContextHolder.getContext();
        CasAssertionAuthenticationToken authentication = (CasAssertionAuthenticationToken) context.getAuthentication();
        AttributePrincipal principal =  authentication.getAssertion().getPrincipal();
        Map attributes = principal.getAttributes();
        UserDetails userDetails = casUserDetailService.loadUserDetails(authentication);
        String casID = userDetails.getUsername();
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIdCAS(casID);
        utilisateur.setPrenom((String) attributes.get("givenName"));
        utilisateur.setNom((String) attributes.get("sn"));
        utilisateurRepo.save(utilisateur);*/



            Composante c = new Composante();

        c.setIntitule("composante");
            c.setFormations(new ArrayList<>());

            Utilisateur utilisateurs = new Utilisateur();

        utilisateurs.setNom("Laporte");
       utilisateurs.setPrenom("Laurent");
            utilisateurs.setAdmin(true);
             utilisateurs.setIdComposante(c);

            utilisateurRepo.save(utilisateurs);

            composanteRepo.save(c);
        //    }




    }


    @RequestMapping(value = "/gestionUtilisateur", method = RequestMethod.GET)
    public ModelAndView gestionUtilisateurPage() {
        //Collection<Composante> composantes = composanteRepo.findAll();
        Collection<Utilisateur> test = utilisateurRepo.findAll();
        return new ModelAndView("gestionUser", "utilisateur",test);
    }

    @RequestMapping(value = "/gestionUtilisateur/addAdmin", method = RequestMethod.GET)
    public String addAdminForm(@ModelAttribute Utilisateur utilisateur) {

        return "adminForm";
    }


    @RequestMapping(value = "/gestionUtilisateur/addAdmin", method = RequestMethod.POST)
    public String addAdminForm(@ModelAttribute("utilisateur") Utilisateur utilisateur, BindingResult result) {


        if (result.hasErrors()) {
            return "adminForm";
        }
        utilisateurRepo.save(utilisateur);

        return "redirect:";
    }

    @RequestMapping(value = "/gestionUtilisateur/addCorrespondant", method = RequestMethod.GET)
    public String addCorrespondantForm(@ModelAttribute Utilisateur utilisateur) {

        return "correspondantForm";
    }

    @RequestMapping(value = "/gestionUtilisateur/addCorrespondant", method = RequestMethod.POST)
    public String addCorrespondantForm(@ModelAttribute("utilisateur") Utilisateur utilisateur, BindingResult result) {

        if (result.hasErrors()) {
            return "correspondantForm";
        }
        utilisateurRepo.save(utilisateur);
        //  Composante c = composanteRepo.findAll().get(0);
        Composante c = composanteRepo.getById(utilisateur.getIdComposante().getId());

        composanteRepo.save(c);

        return "redirect:";
    }

}
