package ch05.ex05_07;

import java.time.LocalTime;
import java.util.Objects;

public class TimeInterval {

	private LocalTime startLocalTime;
	private LocalTime endLocalTime;

	/**
	 * インターバルの開始時刻をゲットします
	 * @return
	 */
	public LocalTime getStartLocalTime() {
		return startLocalTime;
	}

	/**
	 * インターバルの開始時刻をセットします
	 * @param startLocalTime
	 * @throws NullPointerException startLocalTimeがnullのケース
	 * @throws IllegalArgumentException インターバルの終了時刻がセットされており、開始時刻が終了時刻より後のケース
	 */
	public void setStartLocalTime(LocalTime startLocalTime) {
		Objects.requireNonNull(startLocalTime, "startLocalTime is null");
		if(endLocalTime != null) {
			if(startLocalTime.isAfter(endLocalTime)) {
				throw new IllegalArgumentException("startLocalTime is after");
			}
		}
		this.startLocalTime = startLocalTime;
	}

	/**
	 * インターバルの終了時刻をゲットします
	 * @return
	 */
	public LocalTime getEndLocalTime() {
		return endLocalTime;
	}

	/**
	 * インターバルの終了時刻をセットします
	 * @param endLocalTime
	 * @throws NullPointerException endLocalTimeがnullのケース
	 * @throws IllegalArgumentException インターバル開始時刻がセットされており、開始時刻が終了時刻より後のケース
	 */
	public void setEndLocalTime(LocalTime endLocalTime) {
		Objects.requireNonNull(startLocalTime, "endLocalTime is null");
		if(startLocalTime != null) {
			if(startLocalTime.isAfter(endLocalTime)) {
				throw new IllegalArgumentException("startLocalTime is after");
			}
		}
		this.endLocalTime = endLocalTime;
	}

	/**
	 * 引数で渡されたインターバルが自身のインターバルと重なっているかを検査します
	 * @param timeInterval
	 * @return true：重なっている false：重なっていない
	 * @throws NullPointerException timeIntervalがnullのケース
	 */
	public boolean overlap(TimeInterval timeInterval) {
		Objects.requireNonNull(startLocalTime, "timeInterval is null");
		if(this.startLocalTime.isAfter(timeInterval.startLocalTime)) {
			return this.startLocalTime.isBefore(timeInterval.endLocalTime);
		}else {
			return this.endLocalTime.isAfter(timeInterval.startLocalTime);
		}
	}

}
