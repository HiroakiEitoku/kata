package kata.ex01;

import kata.ex01.model.HighwayDrive;
import kata.ex01.model.RouteType;
import kata.ex01.util.HolidayUtils;

import java.time.LocalDateTime;

/**
 * 平日朝夕割引
 * - 平日「朝:6時〜9時」、「夕:17時〜20時」
 * - 地方部　
 * - 当月の利用回数が5回〜9回 30%割引、10回以上 50%割引
 */
public class WeekdayMorningEveningDiscountLogic implements DiscountLogic {
	public boolean isApplicable(HighwayDrive drive) {
		return isWeekdayMorningEvening(drive) && drive.getRouteType() == RouteType.RURAL;
	}

	private boolean isWeekdayMorningEvening(HighwayDrive drive) {
		return isWeekdayMorningEveningTime(drive.getEnteredAt()) || isWeekdayMorningEveningTime(drive.getExitedAt());
	}

	private boolean isWeekdayMorningEveningTime(LocalDateTime time) {
		boolean isHoliday = HolidayUtils.isHoliday(time.toLocalDate());
		int hour = time.getHour();
		return !isHoliday && (6 <= hour && 9 > hour) || (17 <= hour && 20 > hour);
	}

	public long calcDiscountRate(HighwayDrive drive) {
		if (drive.getDriver().getCountPerMonth() >= 5) {
			if (drive.getDriver().getCountPerMonth() >= 10) {
				return 50;
			}
			return 30;
		}
		return 0;
	}
}
