package kata.ex01;

import kata.ex01.model.HighwayDrive;
import kata.ex01.model.RouteType;
import kata.ex01.model.VehicleFamily;
import kata.ex01.util.HolidayUtils;

/**
 * 休日割引
 * - 普通車、軽自動車等(二輪車)限定
 * - 土曜・日曜・祝日
 * - 地方部
 * - 30%割引
 */
public class WeekendDiscountLogic implements DiscountLogic {
	public boolean isApplicable(HighwayDrive drive) {
		return isApplicableVehicle(drive) && isWeekEnd(drive) && isRural(drive);
	}

	private boolean isRural(HighwayDrive drive) {
		return drive.getRouteType() == RouteType.RURAL;
	}

	private boolean isWeekEnd(HighwayDrive drive) {
		return HolidayUtils.isHoliday(drive.getEnteredAt().toLocalDate()) || HolidayUtils.isHoliday(drive.getExitedAt().toLocalDate());
	}

	private boolean isApplicableVehicle(HighwayDrive drive) {
		return drive.getVehicleFamily() == VehicleFamily.STANDARD || drive.getVehicleFamily() == VehicleFamily.MINI || drive.getVehicleFamily() == VehicleFamily.MOTORCYCLE;
	}

	public long calcDiscountRate(HighwayDrive drive) {
		return 30;
	}
}
