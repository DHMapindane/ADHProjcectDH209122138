package entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Tweets_tbl")
public class TweetsEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long   tweetID;
	
	private String tweetBody;
	private Date  tweetdate;
	
	public String getTweetBody() {
		return tweetBody;
	}
	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}
	public Date getTweetdate() {
		return tweetdate;
	}
	public void setTweetdate(Date tweetdate) {
		this.tweetdate = tweetdate;
	}
	
	public long getTweetID()
	{
		return tweetID;
	}
	
	
		
	

}
