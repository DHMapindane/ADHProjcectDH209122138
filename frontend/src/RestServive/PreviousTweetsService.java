package RestServive;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
//import javax.enterprise.context.RequestScoped;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
//import javax.ws.rs.core.Application;

import entities.TweetsEntity;

@Path("/PreviousTweetsService")
@Stateless
public class PreviousTweetsService {
	
	@PersistenceContext(name = "emppu")
	private EntityManager em;
    

	//http://localhost:8080/frontend/resources/PreviousTweetsService/getTweets
	@GET
	@Path("/getTweets")
	public String getPreviouisTweets()
	{
		String results = "";
		List<TweetsEntity> tweetEntityData = new ArrayList<>();
    	tweetEntityData = em.createQuery("SELECT t FROM Tweets_tbl t", TweetsEntity.class).getResultList();  

	
		 for (TweetsEntity TweetData : tweetEntityData) 
	     {
		      results += TweetData.getTweetID() +"   "+ TweetData.getTweetBody() +"   "+ TweetData.getTweetdate() +"\n";
	     }		
		 
		return results;
	
	}

}
