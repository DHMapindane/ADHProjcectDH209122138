package model;

import java.io.Serializable;
import java.sql.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.TweetsEntity;;

@ManagedBean(name = "Tweets")
@SessionScoped
public class Tweets implements Serializable {
	private static final long serialVersionUID = 1L;

	private String tweetBody;
	private Date   tweetdate;
	private Long   tweetID;
	
	public String getTweetBody() {
		return tweetBody;
	}
	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}
	public Date getTweetdate() {
		return tweetdate;
	}
	public void setTweetdate(Date tweetdate ) {
		this.tweetdate = tweetdate;
	}
	public TweetsEntity getEntity()
	{
		long now = System.currentTimeMillis();
		tweetdate = new Date(now);
		TweetsEntity tweetsEntity = new TweetsEntity();
		tweetsEntity.setTweetBody(tweetBody);
		tweetsEntity.setTweetdate(tweetdate);
		
		return tweetsEntity;
	}
	public Long getTweetID() {
		return tweetID;
	}
	public void setTweetID(Long tweetID) {
		this.tweetID = tweetID;
	}
	
	
}
