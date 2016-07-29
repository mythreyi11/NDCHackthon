package com.aa.ndchtml5.common;

public class CCExpiryYear extends DynamicView {

	public static CCExpiryYear Y2016 = new CCExpiryYear("2016", "2016");
	public static CCExpiryYear Y2017 = new CCExpiryYear("2017", "2017");
	public static CCExpiryYear Y2018 = new CCExpiryYear("2018", "2018");
	public static CCExpiryYear Y2019 = new CCExpiryYear("2018", "2019");
	public static CCExpiryYear Y2020 = new CCExpiryYear("2020", "2020");
	public static CCExpiryYear Y2021 = new CCExpiryYear("2021", "2021");
	public static CCExpiryYear Y2022 = new CCExpiryYear("2022", "2022");
	public static CCExpiryYear Y2023 = new CCExpiryYear("2023", "2023");
	public static CCExpiryYear Y2024 = new CCExpiryYear("2024", "2024");
	public static CCExpiryYear Y2025 = new CCExpiryYear("2025", "2025");
	public static CCExpiryYear Y2026 = new CCExpiryYear("2026", "2026");

	public static final CCExpiryYear[] expYearList = {Y2016,Y2017,Y2018,Y2019,Y2020,Y2021,Y2022,Y2023,Y2024,Y2025,Y2026};

	public CCExpiryYear(String code, String value) {
		super(code, value);
	}

}
