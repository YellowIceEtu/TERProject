package mybootapp.controller;


import java.security.Principal;

import java.util.ArrayList;
import java.util.Collection;


import mybootapp.model.Adresse;
import mybootapp.model.Composante;
import mybootapp.model.Formation;
import mybootapp.repo.AdresseRepo;
import mybootapp.repo.ComposanteRepo;
import mybootapp.repo.FormationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import javax.validation.Valid;

@Transactional
@RequestMapping("/")
@Controller
public class FormationController {

    @Autowired
    FormationRepo formationRepo;

    @Autowired
    ComposanteRepo composanteRepo;

    @Autowired
    AdresseRepo adresseRepo;

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
                f.setObjectif("objectif".concat(Integer.toString(2*i + j)));
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
        return new ModelAndView("formation/formationList", "composante", composantes);
    }


    @ModelAttribute("formation")
    @RequestMapping(value = "/formationDetails", method = RequestMethod.GET)
    public ModelAndView printFormation(@RequestParam(value = "id") Long id){
        Formation formation = formationRepo.getById(id);

        return new ModelAndView("formation/formationDetails", "formation", formation);
    }


    @ModelAttribute("formation")
    @RequestMapping(value = "formationDetails/edit", method = RequestMethod.GET)
    public ModelAndView editFormation( @RequestParam(value = "id") Long id) {
        Formation formation = formationRepo.getById(id);
        return new ModelAndView("formation/formationForm", "formation", formation);
    }



    @RequestMapping(value = "formationDetails/edit", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute @Valid Formation formation, BindingResult result) {

    /*    Collection<Composante> composantes = composanteRepo.findAll();
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
        }*/
        if (result.hasErrors()) {
            return "formation/formationForm";
        }formationRepo.save(formation);
        return "formation/formationList";
    }


    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        Collection<Composante> composantes = composanteRepo.findAll();
        return new ModelAndView("admin", "composante",composantes);
    }


    @RequestMapping(value = "correspondant", method = RequestMethod.GET)
    public ModelAndView correspondantPage() {

        // Collection<Composante> composantes = composanteRepo.findAll();
        Composante composantes = composanteRepo.findAll().get(0);
        return new ModelAndView("correspondant", "composante",composantes);
    }
//    @RequestMapping(value = "/adresseList", method = RequestMethod.GET)
//    public ModelAndView listAdresse() {
//        Collection<Adresse> adresses = adresseRepo.findAll();
//        return new ModelAndView("adresseList", "adresse", adresses);
//    }

    /*
    @ModelAttribute("adresse")
    @RequestMapping(value = "correspondant/addAdresse", method = RequestMethod.GET)
    public ModelAndView addAdresseForm() {

        Collection<Adresse> composantes = composanteRepo.findAll().get(0).getAdresses();
        return new ModelAndView("adresseForm", "adresse",composantes);
    }*/

    @RequestMapping(value = "/correspondant/addAdress", method = RequestMethod.GET)
    public String addAdresse(@ModelAttribute Adresse adresse) {return "adresseForm";}

    @RequestMapping(value = "/correspondant/addAdress", method = RequestMethod.POST)
    public String addAdresse(@ModelAttribute("adresse") Adresse adresse, BindingResult result) {


        if (result.hasErrors()) {
            return "adresseForm";
        }
        adresseRepo.save(adresse);
        Composante c = composanteRepo.findAll().get(0);
        c.addAdresse(adresse);
        composanteRepo.save(c);
        System.out.println("adresses:  "+c.getAdresses());

        return "redirect:";
    }

    @RequestMapping(value = "/editAdress/{id}")
    public String showNewAdress(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("command", adresseRepo.findById(id).orElse(null));
        return "editAdress";
    }

    @RequestMapping(value = "/editAdress/{id}", method = RequestMethod.POST)
    public String editAdress(@PathVariable Long id, @ModelAttribute("adresse") Adresse adresse) {
        Adresse newAdress = adresseRepo.findById(id).orElse(null);
        newAdress.setLigne(adresse.getLigne());
        adresseRepo.save(newAdress);
        return "redirect:/correspondant";
    }

    @RequestMapping(value = "/deleteAdress/{id}")
    public String deleteAdress(@PathVariable Long id) {
        adresseRepo.deleteById(id);
        return "redirect:/correspondant";
    }




}
