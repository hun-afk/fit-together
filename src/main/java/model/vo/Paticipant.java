package model.vo;

import java.sql.Date;

public class Paticipant {
	int id;
	String userId;
	String eventId;
	Date joinAt;
	
	public Paticipant() {
		super();
	}

	public Paticipant(int id, String userId, String eventId, Date joinAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.eventId = eventId;
		this.joinAt = joinAt;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public void setJoinAt(Date joinAt) {
		this.joinAt = joinAt;
	}

	public int getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public String getEventId() {
		return eventId;
	}

	public Date getJoinAt() {
		return joinAt;
	}
	
	
}
