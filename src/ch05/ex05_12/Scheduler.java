package ch05.ex05_12;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {

	private static Scheduler instance = new Scheduler();

	private List<Schedule> schedleList = new ArrayList<Schedule>();

	private Scheduler() {}

	public static Scheduler getInstance() {
		return instance;
	}

	public void addSchedule(Schedule schedule) {
		synchronized(schedleList) {
			schedleList.add(schedule);
			schedule.startNotifyTimer();
		}
	}

}
