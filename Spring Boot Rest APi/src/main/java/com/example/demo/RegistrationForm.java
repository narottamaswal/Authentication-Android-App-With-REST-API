package com.example.demo;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="registration_form")
public class RegistrationForm  {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;    private @NotBlank String name;
    private @NotBlank String email;
    private @NotBlank String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RegistrationForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegistrationForm(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistrationForm)) return false;
        RegistrationForm form = (RegistrationForm) o;
        return Objects.equals(name, form.name) &&
                Objects.equals(password, form.password);
    }

}