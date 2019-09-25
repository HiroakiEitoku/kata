package kata.ex01;

import kata.ex01.model.HighwayDrive;

import java.util.Arrays;
import java.util.List;

/**
 * @author kawasima
 */
public class DiscountServiceImpl implements DiscountService {
	private List<DiscountLogic> logicList;

	DiscountServiceImpl() {
		logicList = Arrays.asList(new WeekdayMorningEveningDiscountLogic(), new WeekendDiscountLogic(),
				new MidnightDiscountLogic());
	}

	@Override
	public long calc(HighwayDrive drive) {
		for (DiscountLogic logic : logicList) {
			if (logic.isApplicable(drive)) {
				return logic.calcDiscountRate(drive);
			}
		}

		return 0;
	}
}
