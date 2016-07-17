package com.aa.ndchtml5.common;

public class CardType extends DynamicView {

	public static CardType VISA = new CardType("1", "VISA");
	public static CardType MASTER = new CardType("2", "MASTER CARD");
	public static CardType DISCOVER = new CardType("3", "DISCOVER CARD");
	public static CardType AMERICANEXPRESS = new CardType("4", "AMERICAN EXPRESS");


	public static final CardType[] cardTypeList = { VISA, MASTER, DISCOVER, AMERICANEXPRESS};

	public CardType(String code, String value) {
		super(code, value);
	} 
}
