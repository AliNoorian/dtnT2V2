package com.dotin.leavesystem.rest;

import com.dotin.leavesystem.dao.EmailService;
import com.dotin.leavesystem.models.Email;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class EmailRestController {

    private final EmailService emailService;

    public EmailRestController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/email")
    public List<Email> findAll() {
        return emailService.findAll();
    }

    @GetMapping("/email/{emailId}")
    public Email getEmail(@PathVariable int emailId) {

        Email theEmail = emailService.findById(emailId);
        if (theEmail == null) {
            throw new RuntimeException("Email id not found - " + emailId);
        }
        return theEmail;
    }

    @PostMapping("/email")
    public Email addEmail(@RequestBody Email theEmail) {

        theEmail.setEmailId(0);
        emailService.save(theEmail);
        return theEmail;

    }


}
