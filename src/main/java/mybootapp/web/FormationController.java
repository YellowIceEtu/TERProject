package mybootapp.web;


import java.security.Principal;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


import mybootapp.model.Adresse;
import mybootapp.model.Composante;
import mybootapp.model.Formation;
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
    public void init(){
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

//                 Adresse adresse = new Adresse();
//                adresse.setAdresse("163 Av. de Luminy, 13009 Marseille");
//
//                c.addAdresse(adresse);
            }
               /*Collection<Adresse> adresses = new ArrayList<>();

                    Adresse adresse = new Adresse();
                    adresse.setAdresse("163 Av. de Luminy, 13009 Marseille");
                     Adresse adresse2 = new Adresse();
                    adresse2.setAdresse("52 Av. Escadrille Normandie Niemen, 13013 Marseille");

                   c.setAdresse(adresses);*/

            composanteRepo.save(c);
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
        Collection<Composante> composantes = composanteRepo.findAll();
        return new ModelAndView("formationList", "composante", composantes);
    }


    @ModelAttribute("formation")
    @RequestMapping(value = "/formationDetails", method = RequestMethod.GET)
    public ModelAndView printFormation(@RequestParam(value = "id") Long id){
        Formation formation = formationRepo.getById(id);

        return new ModelAndView("formationDetails", "formation", formation);
    }

    @ModelAttribute("formation")
    @RequestMapping(value = "formationDetails/edit", method = RequestMethod.GET)
    public ModelAndView editFormation( @RequestParam(value = "id") Long id) {
        Formation formation = formationRepo.getById(id);
        return new ModelAndView("formationForm", "formation", formation);
    }



    @RequestMapping(value = "formationDetails/edit", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute Formation formation, BindingResult result) {
        formationRepo.save(formation);
        Collection<Composante> composantes = composanteRepo.findAll();
        for (Composante c: composantes){
            Collection<Formation> formations = c.getFormations();
            for (Formation f: formations){
                if(f.getId().equals(formation.getId())){
                    formations.remove(f);
                    formations.add(formation);
                    c.setFormations(formations);
                    composanteRepo.save(c);
                }
            }

            }
        if (result.hasErrors()) {
            return "formationForm";
        }
        return "redirect:/formationList";
    }


    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        Collection<Composante> composantes = composanteRepo.findAll();
        return new ModelAndView("admin", "composante",composantes);
    }

    @RequestMapping(value = "correspondant", method = RequestMethod.GET)
    public ModelAndView correspondantPage() {

        Collection<Composante> composantes = composanteRepo.findAll();
        return new ModelAndView("correspondant", "composante",composantes);
    }
//    @RequestMapping(value = "/adresseList", method = RequestMethod.GET)
//    public ModelAndView listAdresse() {
//        Collection<Adresse> adresses = adresseRepo.findAll();
//        return new ModelAndView("adresseList", "adresse", adresses);
//    }
}
