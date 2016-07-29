package com.aa.ndchtml5.common;

public class CCExpiryMonth extends DynamicView {

	public static CCExpiryMonth JAN = new CCExpiryMonth("JAN", "Jan (01)");
	public static CCExpiryMonth FEB = new CCExpiryMonth("FEB", "Feb (02)");
	public static CCExpiryMonth MAR = new CCExpiryMonth("MAR", "Mar (03)");
	public static CCExpiryMonth APR = new CCExpiryMonth("APR", "Apr (04)");
	public static CCExpiryMonth MAY = new CCExpiryMonth("MAY", "May (05)");
	public static CCExpiryMonth JUN = new CCExpiryMonth("JUN", "June (06)");
	public static CCExpiryMonth JUL = new CCExpiryMonth("JUL", "July (07)");
	public static CCExpiryMonth AUG = new CCExpiryMonth("AUG", "Aug (08)");
	public static CCExpiryMonth SEP = new CCExpiryMonth("SEP", "Sep (09)");
	public static CCExpiryMonth OCT = new CCExpiryMonth("OCT", "Oct (10)");
	public static CCExpiryMonth NOV = new CCExpiryMonth("NOV", "Nov (11)");
	public static CCExpiryMonth DEC = new CCExpiryMonth("DEC", "Dec (12)");

	public static final CCExpiryMonth[] expMonthList = {JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC};

	public CCExpiryMonth(String code, String value) {
		super(code, value);
	}
}	