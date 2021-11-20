package com.example.demo;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service; 
@Service  
public class RegistrationFormService {
	@Autowired
	private RegistrationFormRepo rfrepo;
	public void save(RegistrationForm form){  
		rfrepo.save(form);  
	}  
	
}
