package model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;;

@ManagedBean(name = "Login")
@SessionScoped
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String Password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

}
