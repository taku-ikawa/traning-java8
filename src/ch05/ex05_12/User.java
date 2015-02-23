package ch05.ex05_12;

import java.time.ZoneId;

public class User {
	private String userName;
	private ZoneId zoneId;

	private Runnable action;

	public void notifySchedule() {
		action.run();
	}

	public void setAction(Runnable action) {
		this.action = action;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ZoneId getZoneId() {
		return zoneId;
	}

	public void setZoneId(ZoneId zoneId) {
		this.zoneId = zoneId;
	}

}
