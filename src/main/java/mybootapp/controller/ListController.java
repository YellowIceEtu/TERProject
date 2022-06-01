package mybootapp.controller;

import mybootapp.model.Composante;
import mybootapp.model.Formation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Controller
@RequestMapping("")
public class ListController {


        @ModelAttribute("ObjectifGeneralList")
    public Map<Integer, String> ObjectifGeneralList() throws FileNotFoundException {
        Map<Integer, String> list = new LinkedHashMap<>();
        File myObj = new File("static/referentiel/objectifGeneral");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
            String [] res = data.split("\t");
            list.put(Integer.parseInt(res[0]), res[1]);
        }
        return list;
    }


}
