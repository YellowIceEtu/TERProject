package mybootapp.service;

import mybootapp.model.*;
import mybootapp.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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

    @Autowired
    SessionRepository sessionRepository;


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
                s.setSessionOuverte("1");
                s.setDebut(new Date());
                s.setFin(new Date());
                sessionRepository.save(s);
                f.getAction().getSessions().add(s);
                composanteRepo.save(c);
                f.setComposante(c);
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
        utilisateurs.setIdCAS("c18024224");

        utilisateurRepo.save(utilisateurs);

        composanteRepo.save(c);
    }
}
