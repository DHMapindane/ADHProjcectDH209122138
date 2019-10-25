package model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;;

@ManagedBean(name = "Configurations")
@SessionScoped
public class Configurations implements Serializable {
	private static final long serialVersionUID = 1L;

	private String customerKey;
	private String customerKeySectret;
	private String accessToken;
	private String accessTokenSecret;
	public String getCustomerKey() {
		return customerKey;
	}
	public void setCustomerKey(String customerKey) {
		this.customerKey = customerKey;
	}
	public String getCustomerKeySectret() {
		return customerKeySectret;
	}
	public void setCustomerKeySectret(String customerKeySectret) {
		this.customerKeySectret = customerKeySectret;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}
	public void setAccessTokenSecret(String accessTokenSecret) {
		this.accessTokenSecret = accessTokenSecret;
	}
	
	
}
