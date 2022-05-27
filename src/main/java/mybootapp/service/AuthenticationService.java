package mybootapp.service;

import mybootapp.model.Composante;
import mybootapp.model.Utilisateur;
import mybootapp.web.CasUserDetailService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AuthenticationService {

    @PreAuthorize("admin")
    public void addAdmin(Utilisateur utilisateur){
        utilisateur.setAdmin(true);



    }
    public void removeAdmin(Utilisateur utilisateur){}
    public void addCoreespondant(Composante composante, Utilisateur utilisateur){}
    public void removeCorrespondant(Composante composante, Utilisateur utilisateur){}

}
