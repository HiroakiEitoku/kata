package kata.ex01;

import kata.ex01.model.HighwayDrive;

import java.time.LocalDateTime;

/**
 * 休日割引
 * - すべての車種
 * - 毎日0〜４時
 * - 30%割引
 */
public class MidnightDiscountLogic implements DiscountLogic {
	public boolean isApplicable(HighwayDrive drive) {
		return isMidnight(drive);
	}

	private boolean isMidnight(HighwayDrive drive) {
		return isMidnightTime(drive.getEnteredAt()) || isMidnightTime(drive.getExitedAt());
	}

	private boolean isMidnightTime(LocalDateTime timeAt) {
		int hour = timeAt.getHour();
		return 4 > hour; // hour >= 0 は自明
	}

	public long calcDiscountRate(HighwayDrive drive) {
		return 30;
	}
}
