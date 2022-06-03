package mybootapp.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.security.Principal;

import java.util.*;


import mybootapp.model.*;
import mybootapp.repo.*;
import mybootapp.service.ComposanteServcie;
import mybootapp.service.ListBuilder;
import mybootapp.service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@RequestMapping("/")
@Controller
public class FormationController {

    @Autowired
    FormationRepo formationRepo;

    @Autowired
    ComposanteRepo composanteRepo;

    @Autowired
    AdresseRepo adresseRepo;

    @Autowired
    ListBuilder listBuilder;

    @Autowired
    UtilisateurRepo utilisateurRepo;

    @Autowired
    ComposanteServcie composanteServcie;

    @Autowired
    PopulationService populationService;


//    @Value("#{applicationProperties}")
//    private Map<String, String> systemPropertiesMap;



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
    @RequestMapping(value = "/formationDetails/sessions", method = RequestMethod.GET)
    public ModelAndView printSessions(@RequestParam(value = "id") Long id){
        Formation formation = formationRepo.getById(id);
        return new ModelAndView("session/sessionList", "formation", formation);
    }

    @RequestMapping(value = "formationDetails/sessions/add", method = RequestMethod.GET)
    public String addSession(@ModelAttribute Session session) {
        return "session/sessionCreate";
    }

    @RequestMapping(value = "formationDetails/sessions/add", method = RequestMethod.POST)
    public String addSession(@ModelAttribute @Valid Session session, BindingResult result, @RequestParam(value = "id") Long formationid) {
        if (result.hasErrors()) {
            return "session/sessionCreate";
        }
    //(user.hasright()formationid));
        return "session/sessionList";
    }

    @RequestMapping(value = "/formationDetails", method = RequestMethod.GET)
    public ModelAndView printFormation(@RequestParam(value = "id") Long id){
        Formation formation = formationRepo.getById(id);
        return new ModelAndView("formation/formationDetails", "formation", formation);
    }

    @ModelAttribute("formation")
    @RequestMapping(value = "formationDetails/edit", method = RequestMethod.GET)
    public ModelAndView editFormation( @RequestParam(value = "id") Long id){
        Formation formation = formationRepo.getById(id);
        return new ModelAndView("formation/formationForm", "formation", formation);
    }
    @ModelAttribute("typeDeParcours")
    public Map<String, String> typeDeParcoursList() {
        return listBuilder.typeDeParcoursList();
    }
    @ModelAttribute("objectif")
    public Map<String, String> objectifGeneralList() {
        return listBuilder.objectifGeneralList();
    }
    @ModelAttribute("modaliteEnseignement")
    public Map<String, String> modaliteEnseignementList() {
        return listBuilder.modaliteEnseignementList();
    }
    @ModelAttribute("rythmeFormation")
    public Map<String, String> rythmeFormationList() {
        return listBuilder.rythmeFormationList();
    }
    @ModelAttribute("modaliteAdmission")
    public Map<String, String> modaliteAdmissionList() {
        return listBuilder.modaliteAdmissionList();
    }
    @ModelAttribute("langueFormation")
    public Map<String, String> langueFormationList() {
        return listBuilder.langueFormationList();
    }
    @ModelAttribute("tauxTVA")
    public Map<String, String> tauxTVAList() {
        return listBuilder.tauxTVAList();
    }
    @ModelAttribute("fraisInclusANPEC")
    public Map<String, String> fraisInclusANPECList() {
        return listBuilder.fraisInclusANPECList();
    }
    @ModelAttribute("niveauObligatoire")
    public Map<String, String> niveauObligatoireList() {
        return listBuilder.niveauObligatoireList();
    }
    @ModelAttribute("modaliteEntreeSortie")
    public Map<String, String> modaliteEntreeSortieList() {
        return listBuilder.modaliteEntreeSortieList();
    }
    @ModelAttribute("preRequis")
    public Map<String, String> preRequisList() {
        return listBuilder.preRequisList();
    }

    @ModelAttribute("formation")
    @RequestMapping(value = "formationDetails/edit", method = RequestMethod.POST)
    public String saveFormation(@ModelAttribute("formation") @Valid Formation formation, BindingResult result) {
        if (result.hasErrors()) {
            return "formation/formationForm";
        }
        formation.setEtatEdition("stable");
        formationRepo.save(formation);
        return "redirect:/formationDetails";
    }


    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        Collection<Composante> composantes = composanteRepo.findAll();
        return new ModelAndView("admin", "composante",composantes);
    }

    @RequestMapping(value = "/admin/formationCreate", method = RequestMethod.GET)
    public String addFormationForm(@ModelAttribute Formation formation) {return "formation/formationCreate";}
    @ModelAttribute("ListComposantes")
    public Map<Composante, String> ListComposantes() {
        Map<Composante, String> compoList = new LinkedHashMap<>();
        List<Composante> composantes = composanteRepo.findAll();
        for(Composante c : composantes)
            compoList.put(c, c.getIntitule());
        return compoList;
    }

    @RequestMapping(value = "/admin/formationCreate", method = RequestMethod.POST)
    public String saveFormationCreation(@ModelAttribute @Valid Formation formation, BindingResult result) {
        if (result.hasErrors()) {
            return "formation/formationCreate";
        }
        formation.setEtatEdition("brouillon");
        formationRepo.save(formation);
        Composante c = composanteRepo.getById(formation.getComposante().getId());
        c.addFormation(formation);
        composanteRepo.save(c);
        return "redirect:/formationList";
    }



    @RequestMapping(value = "correspondant", method = RequestMethod.GET)
    public ModelAndView correspondantPage() {

        // Collection<Composante> composantes = composanteRepo.findAll();
        Composante composantes = composanteRepo.findAll().get(0);
        return new ModelAndView("correspondant", "composante",composantes);
    }

    /*
    @RequestMapping(value = "/correspondant/addAdress", method = RequestMethod.GET)
    public String addAdresse(@ModelAttribute Adresse adresse) {return "adresseForm";}

    @RequestMapping(value = "/correspondant/addAdress", method = RequestMethod.POST)
    public String addAdresse(@ModelAttribute("adresse") @Valid Adresse adresse, BindingResult result) {
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
*/

    @RequestMapping(value = "/correspondant/addAdress/{id}", method = RequestMethod.GET)
    public String addAdresse(@ModelAttribute Adresse adresse) {
        return "adresseForm";}


    @RequestMapping(value = "/correspondant/addAdress/{idComposante}", method = RequestMethod.POST)
    public String saveAdresse(@ModelAttribute("adresse") @Valid Adresse adresse, BindingResult result, @PathVariable Long idComposante ) {

        if (result.hasErrors()) {
            return "adresseForm";
        }
        //  Adresse
        adresseRepo.save(adresse);
        Composante c = composanteRepo.getById(idComposante);
        c.getAdresses().add(adresse);
        // c.addAdresse(adresse);
        composanteRepo.save(c);
        System.out.println("adresses:  "+c.getAdresses());

        return "redirect:/formationList";
    }

    /*
    @RequestMapping(value = "/editAdress/{id}")
    public String showNewAdress(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("command", adresseRepo.findById(id).orElse(null));
        return "editAdress";
    }

    @RequestMapping(value = "/editAdress/{id}", method = RequestMethod.POST)
    public String editAdress(@PathVariable Long id, @ModelAttribute("contact") Adresse adresse) {
        Adresse newAdress = adresseRepo.findById(id).orElse(null);
        newAdress.setLigne(adresse.getLigne());
        adresseRepo.save(newAdress);
        return "redirect:/correspondant";
    }
*/

    @ModelAttribute("adresse")
    @RequestMapping(value = "/correspondant/editAdress", method = RequestMethod.GET)
    public ModelAndView editAdress( @RequestParam(value = "id") Long id) {
        // Formation formation = formationRepo.getById(id);
        Adresse adresse = adresseRepo.getById(id);
        return new ModelAndView("editAdress", "adresse", adresse);
    }

    @RequestMapping(value = "/correspondant/editAdress", method = RequestMethod.POST)
    public String editAdress( @ModelAttribute Adresse adresse, BindingResult result) {
        //  Adresse newAdress = adresseRepo.findById(id).orElse(null);
        //newAdress.setLigne(adresse.getLigne());
        if (result.hasErrors()) {
            return "editAdress";
        }
        adresseRepo.save(adresse);
        return "redirect:/formationList";
    }


    @RequestMapping(value = "/deleteAdress/{id}")
    public String deleteAdress(@PathVariable Long id) {
        Adresse adresse = adresseRepo.getById(id);
        Long idComposanteOfAdress = composanteServcie.getIdComposanteWithAdress(adresse);

        adresseRepo.deleteById(id);
        return "redirect:/correspondant"+idComposanteOfAdress;
    }
}
