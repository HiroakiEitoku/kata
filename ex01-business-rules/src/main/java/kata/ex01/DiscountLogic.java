package kata.ex01;

import kata.ex01.model.HighwayDrive;

interface DiscountLogic {
	boolean isApplicable(HighwayDrive drive);
	long calcDiscountRate(HighwayDrive drive);
}
