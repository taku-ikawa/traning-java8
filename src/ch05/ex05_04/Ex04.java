package ch05.ex05_04;

import java.time.LocalDate;

public class Ex04 {

	private static int month;
	private static int year;

	private static int dayCount = 1;

	public static void main(String[] args) {
		if(args == null) {
			throw new NullPointerException("args is null");
		}
		if(args.length != 2) {
			throw new IllegalArgumentException("args is illegal");
		}
		try {
			month = Integer.parseInt(args[0]);
			year = Integer.parseInt(args[1]);
		}catch (NumberFormatException e){
			throw new NumberFormatException("args is illegal");
		}

		LocalDate firstDay = LocalDate.of(year, month, 1);
		int firstDayOfWeek = firstDay.getDayOfWeek().getValue();

		// １行目の空白
		for(int i = 1; i < firstDayOfWeek; i++) {
			printEmpty();
			printEmpty();
		}

		// １行目
		for(int i = firstDayOfWeek; i <= 7; i++) {
			printDay(dayCount);
			printEmpty();
			dayCount++;
		}

		// 改行
		System.out.println();

		// 最終日を確認
		int lastDay = LocalDate.of(year, month, 31).getDayOfMonth();

		label: while(true) {
			for(int i =0; i < 7; i++) {
				if(dayCount <= lastDay) {
					printDay(dayCount);
					printEmpty();
					dayCount++;
				}else {
					// 最終行の空白
					printEmpty();
					printEmpty();
				}
			}
			if(dayCount > lastDay) {
				break;
			}
			System.out.println();
		}

		// 初期化
		System.out.println();
		dayCount = 1;
	}

	private static void printEmpty() {
		System.out.print("  ");
	}

	private static void printDay(int day){
		if(day < 10) {
			System.out.print(" "+day);
		}else {
			System.out.print(day);
		}
	}

}
