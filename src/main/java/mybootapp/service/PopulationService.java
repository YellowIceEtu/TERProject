package mybootapp.service;

import mybootapp.model.*;
import mybootapp.repo.AdresseRepo;
import mybootapp.repo.ComposanteRepo;
import mybootapp.repo.FormationRepo;
import mybootapp.repo.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class PopulationService {

    @Autowired
    FormationRepo formationRepo;

    @Autowired
    ComposanteRepo composanteRepo;

    @Autowired
    AdresseRepo adresseRepo;

    @Autowired
    UtilisateurRepo utilisateurRepo;


    @PostConstruct
    public void init(){
        for(int i = 0; i < 2; i++){
            Composante c = new Composante();
            c.setIntitule("composante".concat(Integer.toString(i)));
            c.setFormations(new ArrayList<>());
            for(int j = 0; j < 2; j++){
                Formation f = new Formation();
                f.init(2 * i + j);
                Session s = new Session();
                s.setSessionOuverte(1);
                s.setDebut("2021/11/16");
                s.setFin("2021/11/17");
                f.getAction().getSessions().add(s);
                composanteRepo.save(c);
               // f.setComposante(c);
                formationRepo.save(f);
                c.addFormation(f);
            }
            Collection<Adresse> adresses = new ArrayList<>();
            Adresse a = new Adresse();
            c.setAdresses(adresses);
            a.setLigne("163 Av. de Luminy, 13009 Marseille");
            adresseRepo.save(a);
            c.addAdresse(a);
            composanteRepo.save(c);
        }
        Composante c = new Composante();

        c.setIntitule("composante");
        c.setFormations(new ArrayList<>());

        Utilisateur utilisateurs = new Utilisateur();

        utilisateurs.setNom("Coquard");
        utilisateurs.setPrenom("Damien");
        utilisateurs.setAdmin(true);
        utilisateurs.setIdComposante(c);
        utilisateurs.setIdCAS("o18025131");

        utilisateurRepo.save(utilisateurs);

        composanteRepo.save(c);
    }
}
