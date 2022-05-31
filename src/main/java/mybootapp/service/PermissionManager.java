package mybootapp.service;

import mybootapp.model.Composante;
import mybootapp.model.Utilisateur;
import mybootapp.repo.UtilisateurRepo;
import mybootapp.web.CasUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class PermissionManager {

    @Autowired
    UtilisateurRepo utilisateurRepo;


    public void AddAdmin (Utilisateur utilisateur){
        utilisateur.setEstAdmin(true);

    }

    /*public void enableRoleAdmin (Utilisateur utilisateur) {
        CasUserDetailService casUserDetailService = new CasUserDetailService();
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserDetails userDetails = casUserDetailService.loadUserDetails((CasAssertionAuthenticationToken) authentication);
        if (userDetails.getUsername().equals(utilisateur.getIdCAS())) {
            userDetails.getAuthorities().clear();
            new SimpleGrantedAuthority("ROLE_ADMIN");
        }
    }*/
    /*public void disableRoleAdmin (Utilisateur utilisateur) {
        CasUserDetailService casUserDetailService = new CasUserDetailService();
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserDetails userDetails = casUserDetailService.loadUserDetails((CasAssertionAuthenticationToken) authentication);
        if (userDetails.getUsername().equals(utilisateur.getIdCAS())) {
            userDetails.getAuthorities().clear();
            new SimpleGrantedAuthority("ROLE_USER");
        }
    }*/

    public void removeAdmin (Utilisateur utilisateur){
        utilisateur.setEstAdmin(false);
    }

    public  void addCorrespondantToComposante (Utilisateur utilisateur, Composante composante){
        if(utilisateur.getComposante().equals(composante.getId())) composante.setCorrespondant(utilisateur);
    }

    public  void removeCorrespondantFromComposante (Utilisateur utilisateur, Composante composante){
        if(utilisateur.getComposante().equals(composante)) utilisateur.setComposante(null);
    }

    public void moveCorrespondantToOtherComposante ( Utilisateur utilisateur, Composante composante, Composante other){
        if(utilisateur.getComposante().equals(composante)) utilisateur.setComposante(other);
    }

}










