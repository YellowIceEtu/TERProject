package mybootapp.web;


import java.security.Principal;
import java.util.Collection;


import mybootapp.model.Formation;
import mybootapp.repo.FormationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@RequestMapping("/")
@Controller
public class UserController {

    @Autowired
    FormationRepo formationRepo;


    @PostConstruct
    public void init() {
        for(int i = 0; i < 4; i++){
            Formation f = new Formation();
            f.setCodeFormation(i);
            f.setEtatEdition("essai");
            f.setIntitule("formation".concat(Integer.toString(i)));
            formationRepo.save(f);

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
    public ModelAndView printPerson(@RequestParam(value = "id",defaultValue = "0") int id){
        Formation formation = formationRepo.findAll().get(id);
        return new ModelAndView("formationDetails", "formation", formation);
    }







}
