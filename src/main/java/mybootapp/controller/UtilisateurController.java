package mybootapp.controller;

import mybootapp.model.Utilisateur;
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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void init(){
        SecurityContext context = SecurityContextHolder.getContext();
        CasAssertionAuthenticationToken authentication = (CasAssertionAuthenticationToken) context.getAuthentication();
        AttributePrincipal principal =  authentication.getAssertion().getPrincipal();
        Map attributes = principal.getAttributes();
        UserDetails userDetails = casUserDetailService.loadUserDetails(authentication);
        String casID = userDetails.getUsername();
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIdCAS(casID);
        utilisateur.setPrenom((String) attributes.get("givenName"));
        utilisateur.setNom((String) attributes.get("sn"));
        utilisateurRepo.save(utilisateur);
    }
}
