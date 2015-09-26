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

	/**
	 * スケジュールを登録します。
	 * 登録されると、スケジュール時刻の15秒前になると、スケジュールに登録されているユーザーに対し、ユーザーアクションを通知するようになります。
	 * @param schedule
	 */
	public void addSchedule(Schedule schedule) {
		synchronized(schedleList) {
			schedleList.add(schedule);
			schedule.startNotifyTimer();
		}
	}

}
