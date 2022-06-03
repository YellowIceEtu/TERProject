package mybootapp.controller;

import mybootapp.model.Composante;
import mybootapp.repo.ComposanteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
@Controller
public class ComposanteController {

    @Autowired
    ComposanteRepo composanteRepo;



    @RequestMapping(value = "/admin/createComposante", method = RequestMethod.GET)
    public String addComposante(@ModelAttribute Composante composante) {
        return "composante/composanteForm";}




    @RequestMapping(value = "/admin/createComposante", method = RequestMethod.POST)
    public String saveComposante(@ModelAttribute("composante") @Valid Composante composante  , BindingResult result ) {

        if (result.hasErrors()) {
            return "composante/composanteForm";
        }
        //  Adresse
        composanteRepo.save(composante);

        return "redirect:/";
    }



}
