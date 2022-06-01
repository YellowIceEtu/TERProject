package mybootapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ListBuilder {
    @Value("#{'${ref.typeDeParcours}'.split('---')}")
    private ArrayList<String> typeDeParcours;

    @Value("#{'${ref.objectifGeneralDeFormation}'.split('---')}")
    private ArrayList<String> objectifGeneral;

    @Value("#{'${ref.modaliteDenseignement}'.split('---')}")
    private ArrayList<String> modaliteEnseignement;

    @Value("#{'${ref.rythmeFormation}'.split('---')}")
    private ArrayList<String> rythmeFormation;

    @Value("#{'${ref.langueFormation}'.split('---')}")
    private ArrayList<String> langueFormation;

    @Value("#{'${ref.modaliteAdmission}'.split('---')}")
    private ArrayList<String> modaliteAdmission;

    @Value("#{'${ref.tauxTVA}'.split('---')}")
    private ArrayList<String> tauxTVA;

    public Map<String, String> typeDeParcoursList() {
        Map<String, String> list = new LinkedHashMap<>();
        for (String s: typeDeParcours){
            String [] res = s.split("--");
            list.put(res[0], res[1]);
        }
        return list;
    }

    public Map<String, String> objectifGeneralList() {
        Map<String, String> list = new LinkedHashMap<>();
        for (String s: objectifGeneral){
            String [] res = s.split("--");
            list.put(res[0], res[1]);
        }
        return list;
    }

    public Map<String, String> modaliteEnseignementList() {
        Map<String, String> list = new LinkedHashMap<>();
        for (String s: modaliteEnseignement){
            String [] res = s.split("--");
            list.put(res[0], res[1]);
        }
        return list;
    }

    public Map<String, String> rythmeFormationList() {
        Map<String, String> list = new LinkedHashMap<>();
        for (String s: rythmeFormation){
            String [] res = s.split("--");
            list.put(res[0], res[1]);
        }
        return list;
    }
    public Map<String, String> langueFormationList() {
        Map<String, String> list = new LinkedHashMap<>();
        for (String s: langueFormation){
            String [] res = s.split("--");
            list.put(res[0], res[1]);
        }
        return list;
    }
    public Map<String, String> modaliteAdmissionList() {
        Map<String, String> list = new LinkedHashMap<>();
        for (String s: modaliteAdmission){
            String [] res = s.split("--");
            list.put(res[0], res[1]);
        }
        return list;
    }
    public Map<String, String> tauxTVAList() {
        Map<String, String> list = new LinkedHashMap<>();
        for (String s: tauxTVA){
            String [] res = s.split("--");
            list.put(res[0], res[1]);
        }
        return list;
    }
}
