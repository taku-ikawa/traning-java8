package ch05.ex05_12;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Schedule {

	private String scheduleName;
	private LocalDateTime scheduleTime;
	private List<User> userList = new ArrayList<User>();

	private static int PRE_NOTIFY_SECONDS = 15; // 設定時間15秒前に通知

	public String getScheduleName() {
		return scheduleName;
	}
	/**
	 * スケジュール名を設定します。
	 * @param scheduleName
	 */
	public void setScheduleName(String scheduleName) {
		Objects.requireNonNull(scheduleName, "scheduleName is null");
		this.scheduleName = scheduleName;
	}
	public LocalDateTime getScheduleTime() {
		return scheduleTime;
	}
	/**
	 * スケジュールの時刻を設定します。
	 * 時刻の15秒前になると、スケジュールに登録されているユーザーに対し、ユーザーアクションを通知します。
	 * @param scheduleTime
	 */
	public void setScheduleTime(LocalDateTime scheduleTime) {
		Objects.requireNonNull(scheduleTime, "scheduleTime is null");
		this.scheduleTime = scheduleTime;
	}

	/**
	 * スケジュールにユーザーを登録します
	 * @param user
	 */
	public void addUser(User user) {
		Objects.requireNonNull(user, "user is null");
		userList.add(user);
	}

	public void startNotifyTimer() {

		System.out.println("startNotifyTimer");

		Timer timer = new Timer();

		for(User user : userList) {
			TimerTask timerTask = new TimerTask() {
				@Override
				public void run() {
					user.notifySchedule();
				}
			};
			timer.schedule(timerTask, Date.from(scheduleTime.atZone(user.getZoneId()).toInstant().minusSeconds(PRE_NOTIFY_SECONDS)));
			System.out.println("schedule");
		}
	}


}
