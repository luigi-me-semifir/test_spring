package com.example.gestiondatespring.controller;

import com.example.gestiondatespring.model.Payload;
import com.example.gestiondatespring.service.PayloadService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * PayloadController class is a controller class that implements the CRUD operations for the Payload entity.
 * It is annotated with @RestController to indicate that it is a controller class.
 * It is annotated with @RequestMapping to indicate that it is a controller class.
 * It has a constructor that takes a PayloadService object as a parameter.
 * It has a save method that takes a Payload object as a parameter and returns an Object.
 * It has a findById method that takes an Integer as a parameter and returns an Object.
 * It has a findAll method that returns an Object.
 * It has a deleteById method that takes an Integer as a parameter and returns an Object.
 * It has a deleteAll method that returns an Object.
 * It has an update method that takes a Payload object as a parameter and returns an Object.
 * It has a PayloadService object.
 */
@RestController
@RequestMapping("/payloads")
public class PayloadController {

    /**
     * PayloadService object.
     */
    private final PayloadService payloadService;

    /**
     * Constructor of the PayloadController class.
     * @param payloadService the PayloadService object.
     */
    public PayloadController(PayloadService payloadService) {
        this.payloadService = payloadService;
    }

    /**
     * Save a payload in the database.
     * @param entity the payload to save in the database.
     * @return an Object containing the payload and the current date.
     */
    @PostMapping("")
    public Object save(@RequestBody Payload entity) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("payload", entity); // request body
        ret.put("now", new Date());
        payloadService.save(entity);
        return ret;
    }

    /**
     * Find a payload by its id.
     * @param id the id of the payload to find.
     * @return an Object containing the payload and the current date.
     */
    @GetMapping("/{id}")
    public Object findById(@PathVariable Integer id) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("payload", payloadService.findById(id));
        ret.put("now", new Date());
        return ret;
    }

    /**
     * Find all payloads.
     * @return an Object containing the payloads and the current date.
     */
    @GetMapping("/")
    public Object findAll() {
        Map<String, Object> ret = new HashMap<>();
        ret.put("payloads", payloadService.findAll());
        ret.put("now", new Date());
        return ret;
    }

    /**
     * Delete a payload by its id.
     * @param id the id of the payload to delete.
     * @return an Object containing the payload and the current date.
     */
    @DeleteMapping("/{id}")
    public Object deleteById(@PathVariable Integer id) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("payload", payloadService.findById(id));
        ret.put("now", new Date());
        payloadService.deleteById(id);
        return ret;
    }

    /**
     * Delete all payloads.
     * @return an Object containing the payloads and the current date.
     */
    @DeleteMapping("/")
    public Object deleteAll() {
        Map<String, Object> ret = new HashMap<>();
        ret.put("payloads", payloadService.findAll());
        ret.put("now", new Date());
        payloadService.deleteAll();
        return ret;
    }

    /**
     * Update a payload.
     * @param entity the payload to update.
     * @return an Object containing the payload and the current date.
     */
    @PutMapping("/")
    public Object update(@RequestBody Payload entity) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("payload", entity); // request body
        ret.put("now", new Date());
        payloadService.update(entity);
        return ret;
    }

}