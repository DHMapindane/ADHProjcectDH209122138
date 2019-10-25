package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import twitter4j.TwitterException;


import twitter4j.Status;

import model.Configurations;
import model.Login;
import model.Register;
import model.Tweets;
import service.TweetManagementEJB;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;
import entities.RegisterEntity;
import entities.TweetsEntity;
import java.io.IOException;


@ManagedBean(name = "tweetManagementController" ,eager = true)
@SessionScoped
public class TweetManagementController{
 
	private String stringOutput;
	private String loginOutput;
	private String tweetOutput;
    @EJB
    private TweetManagementEJB tweetManagementEJB;
    
  //from form
  	@ManagedProperty(value="#{register}")
    private Register register;
  	
  	@ManagedProperty(value="#{login}")
    private Login login;
  	
	@ManagedProperty(value="#{tweets}")
    private Tweets tweets;
	
	@ManagedProperty(value="#{configurations}")
	private Configurations configurations;
  	
  	@PostConstruct
  	public void init() {
  		register = new Register();
  		login = new Login();
  		tweets = new Tweets();
  		configurations = new Configurations();
  	}
    private List<Tweets> TweetsList = new ArrayList<>();
    
   
 
    public List<Tweets> getPreviousTweets() {
	   
	    List<TweetsEntity> entityListValues = tweetManagementEJB.getAllTweets();
	    TweetsList.clear();
	    for (TweetsEntity TweetEntityData : entityListValues) 
    	{
	    	System.out.println("============================");
	    	tweets = new Tweets();
	    	tweets.setTweetBody(TweetEntityData.getTweetBody());
	    	tweets.setTweetdate(TweetEntityData.getTweetdate());
	    	tweets.setTweetID(TweetEntityData.getTweetID());
			TweetsList.add(tweets);
    	}
        return TweetsList;
    }
 
   public String verifyLoggin(){
	   
	    boolean result = false;
	    String  returnValue;
	    result = tweetManagementEJB.getRegisteredUser(login.getEmail(), login.getPassword());
	    if (result == true)
	    {
	    	returnValue = "LoggedInSession.xhtml";
	    	loginOutput = "Welcome   " + register.getName();
	    }
	    else
	    {
	    	returnValue = "Login.xhtml";
	    	loginOutput = "Login failed please make sure you have the right credentials";
	    }
	    
        return returnValue;
    }
    public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

    
    public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}
	
	public Tweets getTweets() {
		return tweets;
	}

	public void setTweets(Tweets tweets) {
		this.tweets = tweets;
	}

	public Configurations getConfigurations() {
		return configurations;
	}

	public void setConfigurations(Configurations configurations) {
		this.configurations = configurations;
	}

   
    public void registerNewUser() {
    	tweetManagementEJB.registerNewUser(register.getEntity());
    	stringOutput = "Registration successfully for username :" + register.getEmail();
    }
    
    public void saveAndTweet()
    {
    	try
    	{
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey(configurations.getCustomerKey())
    	  .setOAuthConsumerSecret(configurations.getCustomerKeySectret())
    	  .setOAuthAccessToken(configurations.getAccessToken())
    	  .setOAuthAccessTokenSecret(configurations.getAccessTokenSecret());
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
    	Status status = twitter.updateStatus(tweets.getTweetBody());
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    	}
    	catch (TwitterException te) {
       if (401 == te.getStatusCode()) {
            System.out.println("Unable to get the access token.");
       } else {
                te.printStackTrace();
            }
    	}
    	catch (IllegalStateException ie) {
            // access token is already available, or consumer key/secret is not set.
 
                System.out.println("OAuth consumer key/secret is not set.");
                System.exit(-1);
            
        }
    	
   	
    	tweetManagementEJB.saveTweet(tweets.getEntity());
    	tweetOutput = "Tweet has been saved and posted on tweeter";
    
    }

	public String getStringOutput() {
		return stringOutput;
	}

	public void setStringOutput(String stringOutput) {
		this.stringOutput = stringOutput;
	}

	public String getLoginOutput() {
		return loginOutput;
	}

	public void setLoginOutput(String loginOutput) {
		this.loginOutput = loginOutput;
	}

	public String getTweetOutput() {
		return tweetOutput;
	}

	public void setTweetOutput(String tweetOutput) {
		this.tweetOutput = tweetOutput;
	}
    
    
}