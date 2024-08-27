package com.portfolio.controller;

import com.portfolio.payload.ContactFormDTO;
import com.portfolio.service.ContactFormService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ContactFormController {

    private final ContactFormService contactFormService;

    @Autowired
    public ContactFormController(ContactFormService contactFormService) {
        this.contactFormService = contactFormService;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/contact")
    public ResponseEntity<String> submitContactForm(@Valid @RequestBody ContactFormDTO contactFormDTO) {
        contactFormService.saveContactForm(contactFormDTO);
        return new ResponseEntity<>("Form submitted successfully", HttpStatus.OK);
    }
}
