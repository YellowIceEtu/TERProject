package mybootapp.controller;

import mybootapp.model.Composante;
import mybootapp.repo.ComposanteRepo;
import mybootapp.repo.FormationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/")
@Controller
public class ItemsListsController {

    @Autowired
    ComposanteRepo composanteRepo;


    @ModelAttribute("ListComposantes")
    public Map<Composante, String> ListComposantes() {
        Map<Composante, String> compoList = new LinkedHashMap<>();
        List<Composante> composantes = composanteRepo.findAll();
        for(Composante c : composantes)
            compoList.put(c, c.getIntitule());
        return compoList;
    }
}
