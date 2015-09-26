package ch05.ex05_04;

import java.time.LocalDate;

public class CalenderPrinter {

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

		// 1日の曜日を取得する
		LocalDate firstDay = LocalDate.of(year, month, 1);
		int firstDayOfWeek = firstDay.getDayOfWeek().getValue();

		// １行目の処理
		// 1日の曜日の手前までは空白で埋める
		for(int i = 1; i < firstDayOfWeek; i++) {
			printEmpty();
			printEmpty();
		}

		// １行目の処理
		// 一日の曜日以降は日付で埋める
		for(int i = firstDayOfWeek; i <= 7; i++) {
			printDay(dayCount);
			printEmpty();
			dayCount++;
		}

		// 改行
		System.out.println();

		// 二行目以降の処理
		// 最終日の曜日を取得
		int lastDay = LocalDate.of(year, month, 31).getDayOfMonth();

		label: while(true) {
			for(int i =0; i < 7; i++) {
				if(dayCount <= lastDay) {
					// 最終日になるまでは日付で埋める
					printDay(dayCount);
					printEmpty();
					dayCount++;
				}else {
					// 最終行の空白
					// 最終日以降は空白で埋める
					printEmpty();
					printEmpty();
				}
			}
			// 最終行であれば処理終了
			if(dayCount > lastDay) {
				break;
			}
			// 改行
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
