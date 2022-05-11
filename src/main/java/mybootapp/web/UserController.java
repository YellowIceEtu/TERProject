package mybootapp.web;


import java.security.Principal;

import mybootapp.model.Formation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RestController
public class UserController {

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
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home2(Principal p) {
        return new ModelAndView("home", "message", p);
    }





    @ModelAttribute("formation")
    @RequestMapping(value = "/formation", method = RequestMethod.GET)
    public ModelAndView formationCollection(Principal p) {

        return new ModelAndView("formationList","p",p);
    }






}
