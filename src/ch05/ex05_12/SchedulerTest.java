package ch05.ex05_12;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.Test;

public class SchedulerTest {

	@Test
	public void test() {
		User user = new User();
		user.setUserName("ikawa");
		user.setZoneId(ZoneId.of("Japan"));
		user.setAction(() -> {
			System.out.println("notify and exec user action");
		});

		Schedule schedule = new Schedule();
		schedule.setScheduleName("meeting1");
		schedule.setScheduleTime(LocalDateTime.now().plusSeconds(30)); // 30秒後にアラーム設定
		schedule.addUser(user);

		Scheduler.getInstance().addSchedule(schedule);

		try {
			Thread.sleep(1000*60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
