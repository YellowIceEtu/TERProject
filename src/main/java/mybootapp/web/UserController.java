package mybootapp.web;


import java.security.Principal;
import java.text.Format;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;


//import mybootapp.model.Adresse;
import mybootapp.model.Formation;
//import mybootapp.model.Utilisateur;
//import mybootapp.repo.AdresseRepo;
import mybootapp.repo.FormationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

@RequestMapping("/")
@Controller
public class UserController {

    @Autowired
    FormationRepo formationRepo;

    /*@Autowired
    AdresseRepo adresseRepo;*/

    @PostConstruct
    public void init() {
        for(int i = 0; i < 4; i++){
            Formation f = new Formation();
            f.setCodeFormation(i);
            f.setEtatEdition("essai");
            f.setIntitule("formation".concat(Integer.toString(i)));
            formationRepo.save(f);

//            Adresse adresse = new Adresse();
//            adresse.setNom("adresse"+i);
//            adresse.setLigne1("ligne1" + i);
//            adresse.setCodePostal(13000+i);
//            adresseRepo.save(adresse);
        }
    }

    @Value("${application.message:Hello World}")
    private String message;
/*
    @RequestMapping(value = "/")
    public String home(Principal p) {
        if (p == null) {
            return "<p>Anonymous</p>" + "<p><a href='user'>User</a></p>";
        }
        return user(p);
    }*/


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView home2(Principal p) {
        return new ModelAndView("home", "message", p);
    }





    @RequestMapping(value = "/formationList", method = RequestMethod.GET)
    public ModelAndView listFormations() {
        Collection<Formation> persons = formationRepo.findAll();
        return new ModelAndView("formationList", "formation", persons);
    }


    @ModelAttribute("formation")
    @RequestMapping(value = "/formationDetails", method = RequestMethod.GET)
    public ModelAndView printFormation(@RequestParam(value = "id") int id){


        int test = formationRepo.findAll().get(id).getCodeFormation();
        Formation formation = formationRepo.findAll().get(test);

        return new ModelAndView("formationDetails", "formation", formation);
    }




//    @RequestMapping(value = "/adresseList", method = RequestMethod.GET)
//    public ModelAndView listAdresse() {
//        Collection<Adresse> adresses = adresseRepo.findAll();
//        return new ModelAndView("adresseList", "adresse", adresses);
//    }





}
