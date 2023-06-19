package com.example.aniaj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api")
public class PrzedmiotyApi {
    @Autowired
    private PrzedmiotyDataBase przedmiotyDataBase;

    @GetMapping("test")
    public String testApi() {
        return "Lista przedmiotów";
    }

    @PostMapping(value = "przedmioty",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public Integer addNewPrzedmiot(@RequestBody Przedmiot element) {
       return przedmiotyDataBase.addPrzedmioty(element);

    }

    @GetMapping(value = "przedmioty",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Przedmiot> getPrzedmioty(
           @Nullable @RequestParam("pETCS") Integer etcs,
            @Nullable @RequestParam("nazwa") String name,
            @Nullable @RequestParam("sala") Integer sala,
            @Nullable @RequestParam("egzamin") Boolean egzamin) {
        return przedmiotyDataBase.getPrzedmiotyList(sala, egzamin);
    }

    @GetMapping(value = "przedmioty/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPrzedmiotyByID(@PathVariable("id") Integer id) {
        Przedmiot przedmiot = przedmiotyDataBase.getPrzedmiotById(id);
        if (id == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(przedmiot);

        }
           }
       //http:localhost:8080/api/przedmiot/1



    @DeleteMapping(value ="przedmioty")
    public void deleteAll()
    {
        przedmiotyDataBase.deleteAll();
    }

    @DeleteMapping(value ="przedmioty/{id}")
    public ResponseEntity RemoveId(@PathVariable (value = "id") Integer id)
    {
        boolean isDeleted = przedmiotyDataBase.DeleteById(id);
        if (isDeleted == true) {
            return ResponseEntity.noContent().build();

        } else {
            return ResponseEntity.notFound().build();
        }
        }

        }
