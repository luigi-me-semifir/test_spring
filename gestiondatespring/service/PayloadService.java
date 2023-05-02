package com.example.gestiondatespring.service;

import com.example.gestiondatespring.model.Payload;
import com.example.gestiondatespring.repository.PayloadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PayloadService class is a service class that implements the CRUD operations for the Payload entity.
 * It is used by the PayloadController class.
 * It is annotated with @Service to indicate that it is a service class.
 * It has a constructor that takes a PayloadRepository object as a parameter.
 * It has a save method that takes a Payload object as a parameter and returns a Payload object.
 * It has a findById method that takes an Integer as a parameter and returns a Payload object.
 * It has a findAll method that returns a List of Payload objects.
 * It has a deleteById method that takes an Integer as a parameter and returns void.
 * It has a deleteAll method that returns void.
 * It has an update method that takes a Payload object as a parameter and returns a Payload object.
 * It has a PayloadRepository object.
 */
@Service
public class PayloadService {

    /**
     * PayloadRepository object.
     */
    private final PayloadRepository payloadRepository;

    /**
     * Constructor of the PayloadService class.
     * @param payloadRepository the payload repository.
     * It is used to perform CRUD operations on the database.
     */
    public PayloadService(PayloadRepository payloadRepository) {
        this.payloadRepository = payloadRepository;
    }

    /**
     * Save a payload in the database.
     * @param payload the payload to save in the database.
     * @return a Payload object.
     */
    public Payload save(Payload payload) {
        return payloadRepository.save(payload);
    }

    /**
     * Find a payload by its id.
     * @param id the id of the payload to find.
     * @return a Payload object.
     */
    public Payload findById(Integer id) {
        return payloadRepository.findById(id).orElse(null);
    }

    /**
     * Find all payloads.
     * @return a List of Payload objects.
     */
    public List<Payload> findAll() {
        return payloadRepository.findAll();
    }

    /**
     * Delete a payload by its id.
     * @param id the id of the payload to delete.
     */
    public void deleteById(Integer id) {
        payloadRepository.deleteById(id);
    }

    /**
     * Delete all payloads.
     */
    public void deleteAll() {
        payloadRepository.deleteAll();
    }

    /**
     * Update a payload.
     * @param payload the payload to update.
     * @return a Payload object.
     */
    public Payload update(Payload payload) {
        return payloadRepository.save(payload);
    }

}
