package model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.RegisterEntity;;

@ManagedBean(name = "Register")
@SessionScoped
public class Register implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String surname;
	private String email;
	private String password;
	private String confirmPassword;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
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

	public RegisterEntity getEntity()
	{
		RegisterEntity registerEntity = new RegisterEntity();
		registerEntity.setName(name);
		registerEntity.setSurname(surname);
		registerEntity.setEmail(email);
		registerEntity.setPassword(password);
		
		return registerEntity;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	

}
