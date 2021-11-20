package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import javax.validation.Valid;

import java.util.List;


@RestController
public class RegistrationFormController {
    @Autowired
    RegistrationFormRepo rsrepo;
	@CrossOrigin
    @PostMapping("/signup")
    public Status registerUser(@Valid @RequestBody RegistrationForm form) {
        System.out.println("Signup");

        List<RegistrationForm> users = rsrepo.findAll();
        System.out.println("New user: " + form.toString());
        for (RegistrationForm user : users) {
            System.out.println("Registered user: " + form.toString());
            if (user.equals(form)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        rsrepo.save(form);
        System.out.println("Saved");

        return Status.SUCCESS;
    }
    @CrossOrigin
    @PostMapping("/signin")
    public Status loginUser(@Valid @RequestBody RegistrationForm form) {
        List<RegistrationForm> users = rsrepo.findAll();
    	System.out.print(form.getEmail()+' '+form.getPassword());

        for (RegistrationForm other : users) {
        	String email = other.getEmail();
        	String password = other.getPassword();
        	System.out.print(email+' '+password);
        	
            if (email.equals( form.getEmail()) && password.equals(form.getPassword())) {
//            	rsrepo.save(form);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
	@CrossOrigin
    @GetMapping("/test")
    public Status deleteUsers() {
    	System.out.print("get");
        return Status.SUCCESS;
    }

    
    }
