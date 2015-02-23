package ch05.ex05_07;

import java.time.LocalTime;

public class TimeInterval {

	private LocalTime startLocalTime;
	private LocalTime endLocalTime;

	public LocalTime getStartLocalTime() {
		return startLocalTime;
	}

	public void setStartLocalTime(LocalTime startLocalTime) {
		if(endLocalTime != null) {
			if(startLocalTime.isAfter(endLocalTime)) {
				throw new IllegalArgumentException("startLocalTime is after");
			}
		}
		this.startLocalTime = startLocalTime;
	}

	public LocalTime getEndLocalTime() {
		return endLocalTime;
	}

	public void setEndLocalTime(LocalTime endLocalTime) {
		if(startLocalTime != null) {
			if(startLocalTime.isAfter(endLocalTime)) {
				throw new IllegalArgumentException("startLocalTime is after");
			}
		}
		this.endLocalTime = endLocalTime;
	}

	public boolean overlap(TimeInterval timeInterval) {
		if(this.startLocalTime.isAfter(timeInterval.startLocalTime)) {
			return this.startLocalTime.isBefore(timeInterval.endLocalTime);
		}else {
			return this.endLocalTime.isAfter(timeInterval.startLocalTime);
		}
	}

}
