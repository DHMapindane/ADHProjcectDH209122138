package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

import entities.RegisterEntity;
import entities.TweetsEntity;

/**
 * Session Bean implementation class EmployeeEJB
 */
@Stateless
@LocalBean
public class TweetManagementEJB {


	@PersistenceContext
	private EntityManager em;
	
    public TweetManagementEJB() {
    }
    
    public void registerNewUser(RegisterEntity registerEntity)
    {
    	System.out.println("============================");
    	em.persist(registerEntity);
    	System.out.println("============================");
    }
    
    public void saveTweet(TweetsEntity tweetsEntity)
    {
    	System.out.println("============================");
    	em.persist(tweetsEntity);
    	System.out.println("============================");
    }
    
    public boolean getRegisteredUser(String userName,String passWord)
    {
    	boolean found = false;
        List<?> query = em.createQuery("SELECT t FROM Register_tbl t where t.email = ?1 AND t.password = ?2").setParameter(1, userName).setParameter(2, passWord).getResultList();
        if (!query.isEmpty()) 
    	{
        	//System.out.println(registerEntity.getName());
        	found = true;
    	}
        
    	return found;
    }
    
    public List<TweetsEntity> getAllTweets()
    {
    	List<TweetsEntity> tweetEntityData = new ArrayList<>();
    	tweetEntityData = em.createQuery("SELECT t FROM Tweets_tbl t", TweetsEntity.class).getResultList();  
    	return tweetEntityData;
    }
    

}
