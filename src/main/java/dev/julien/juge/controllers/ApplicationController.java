package dev.julien.juge.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.julien.juge.dtos.ApplicationDto;
import dev.julien.juge.repositories.ApplicationRepository;
import org.reactivecouchbase.json.JsObject;
import org.reactivecouchbase.json.JsValue;
import org.reactivecouchbase.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="application")
public class ApplicationController {

    @Autowired
    ApplicationRepository applicationRepository;


    /**
     * @api {get} /application/informations?application_id:application_id Récupérer informations application
     * @apiGroup Application
     * @apiName informations
     * @apiVersion 1.0.0
     * @apiDescription Permet de récupérer les informations d'un application
     * @apiParam {String} application_id Identifiant de l'application à rechercher
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     */
    @RequestMapping(
            method = RequestMethod.GET,
            path = "informations"
    )
    public ResponseEntity<String> getInformations(@RequestParam(name = "application_id", required = true) String applicationId) throws JsonProcessingException {

        ApplicationDto dto = applicationRepository.findByApplicationId(applicationId);
        ObjectMapper mapper = new ObjectMapper();
        String retour = mapper.writeValueAsString(dto);
        System.out.println(retour);
        if (null != dto) {
            return new ResponseEntity<>(retour, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}
