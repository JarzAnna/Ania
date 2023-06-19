package com.example.aniaj;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;
@Component
@Scope ("singleton")
public class PrzedmiotyDataBase {

    private ArrayList<Przedmiot> przedmiotyList = new ArrayList();
    private int przedmiotyCounter =1;

    public Integer addPrzedmioty(Przedmiot przedmiot) {
        przedmiot.setId(przedmiotyCounter);
        przedmiotyList.add(przedmiot);
        przedmiotyCounter++;
        return przedmiotyCounter;
    }



//    public List<Przedmioty> getPrzedmiotyList() {
//        return przedmiotyList;
//    }


    public List<Przedmiot> getPrzedmiotyList(Integer sala, Boolean egzamin) {
//        if ( == null){
//            return przedmiotyList;
//        }
        List<Przedmiot> filteredPrzedmioty =
          przedmiotyList.stream().filter(przedmiot->
                  (sala == null || przedmiot.getSala().equals(sala)) && (egzamin == null || przedmiot.getEgzamin().equals(egzamin))).collect(Collectors.toList()
          );

//        for (Activity element : przedmiotyList) {
//            if (element.getPriority().equals(priority) && (element.getName().equals(nazwa))){
//                filteredActivities.add(element);
//            }//        }
        return filteredPrzedmioty;
    }
    public void deleteAll(){
        przedmiotyList.clear();
    }

    public boolean DeleteById(Integer id){
        Przedmiot toDelete = null;
        for (Przedmiot element: przedmiotyList) {
            if (element.getId().equals(id)) {
                toDelete=element;
            }
        }
        return przedmiotyList.remove(toDelete);
    }


    public Przedmiot getPrzedmiotById(Integer id) {


        List<Przedmiot> filteredPrzedmioty =
                przedmiotyList.stream().filter(przedmiot -> przedmiot.getId() == id).collect(Collectors.toList());
        if (filteredPrzedmioty.size() == 0) return null;
        return filteredPrzedmioty.get(0);

//        for (Activity element : przedmiotyList)
//        {
//            if (element.getId().equals(id)) {
//                return element;
//            }

//        }
//        return null;
//        }
    }
}
