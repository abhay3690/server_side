package com.portfolio.service.serviceimpl;


import com.portfolio.model.ContactForm;
import com.portfolio.payload.ContactFormDTO;
import com.portfolio.repository.ContactFormRepository;
import com.portfolio.service.ContactFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactFormServiceImpl implements ContactFormService {

    private final ContactFormRepository contactFormRepository;

    @Autowired
    public ContactFormServiceImpl(ContactFormRepository contactFormRepository) {
        this.contactFormRepository = contactFormRepository;
    }

    @Override
    public void saveContactForm(ContactFormDTO contactFormDTO) {
        ContactForm contactForm = new ContactForm();
        contactForm.setName(contactFormDTO.getName());
        contactForm.setEmail(contactFormDTO.getEmail());
        contactForm.setMessage(contactFormDTO.getMessage());

        contactFormRepository.save(contactForm);
    }
}

