package dev.julien.juge.controllers;

import org.reactivecouchbase.json.JsValue;
import org.reactivecouchbase.json.Json;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "context")
public class ContextController {

    @RequestMapping(path="test")
    public String test() {
        return "coucou";
    }

    /**
     * @api {get} /context/informations?application_id:application_id Récupérer informations contexte
     * @apiGroup Contexte
     * @apiName informations
     * @apiVersion 1.0.0
     * @apiDescription Permet de récupérer le contexte utilisé par une application
     * @apiParam {String} application_id Identifiant de l'application à rechercher
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     */
    @RequestMapping(
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            path = "informations"
    )
    public ResponseEntity<JsValue> getInformations(@RequestParam(name = "application_id", required = true) String applicationId) {
        String json = "{\"application_id\":\"APP_155\"}";

        JsValue value = Json.parse(json).as(JsValue.class);

        return new ResponseEntity<JsValue>(value, HttpStatus.OK);

    }

}
