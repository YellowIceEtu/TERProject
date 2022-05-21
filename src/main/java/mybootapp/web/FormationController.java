package mybootapp.web;


import java.security.Principal;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;


//import mybootapp.model.Adresse;
import mybootapp.model.Composante;
import mybootapp.model.Formation;
//import mybootapp.model.Utilisateur;
//import mybootapp.repo.AdresseRepo;
import mybootapp.repo.ComposanteRepo;
import mybootapp.repo.FormationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

@RequestMapping("/")
@Controller
public class FormationController {

    @Autowired
    FormationRepo formationRepo;

    @Autowired
    ComposanteRepo composanteRepo;

    @PostConstruct
    public void init() throws ParseException {
        for(int i = 0; i < 2; i++){
            Composante c = new Composante();
            c.setIntitule("composante".concat(Integer.toString(i)));
            c.setFormations(new ArrayList<>());
            for(int j = 0; j < 2; j++){
                Formation f = new Formation();
                f.setCode(2*i + j);
                f.setEtatEdition("essai");
                f.setIntitule("formation".concat(Integer.toString(2*i + j)));
                formationRepo.save(f);
                c.addFormation(f);
            }
            composanteRepo.save(c);
        }
//            Adresse adresse = new Adresse();
//            adresse.setNom("adresse"+i);
//            adresse.setLigne1("ligne1" + i);
//            adresse.setCodePostal(13000+i);
//            adresseRepo.save(adresse);
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
        Collection<Composante> composantes = composanteRepo.findAll();
        return new ModelAndView("formationList", "composante", composantes);
    }


    @ModelAttribute("formation")
    @RequestMapping(value = "/formationDetails", method = RequestMethod.GET)
    public ModelAndView printFormation(@RequestParam(value = "id") Long id){

        Formation formation = formationRepo.getById(id);

        return new ModelAndView("formationDetails", "formation", formation);
    }

    public String getCurrentDate() throws ParseException {
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy/MM/dd hh:mm");
        String stringDate= DateFor.format(date);
        System.out.println(stringDate);
        return stringDate;
    }


    @ModelAttribute("formation")
    @RequestMapping(value = "formationDetails/edit", method = RequestMethod.GET)
    public ModelAndView editFormation( @RequestParam(value = "id") Long id) {
        Formation formation = formationRepo.getById(id);
        return new ModelAndView("formationForm", "formation", formation);
    }



    @RequestMapping(value = "formationDetails/edit", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute Formation formation, BindingResult result) {

        if (result.hasErrors()) {
            return "formationForm";
        }
        formationRepo.save(formation);
        return "redirect:/formationList";
    }



//    @RequestMapping(value = "/adresseList", method = RequestMethod.GET)
//    public ModelAndView listAdresse() {
//        Collection<Adresse> adresses = adresseRepo.findAll();
//        return new ModelAndView("adresseList", "adresse", adresses);
//    }





}
