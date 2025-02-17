package org.csystem.application.dateapp;

public class DateUtil {
	public static void displayDateTR(int day, int month, int year)
	{
		int dayOfWeek = getDayOfWeek(day, month, year);	
		
		
		switch (dayOfWeek) {
		case 0:
			System.out.printf("%02d/%02d/%04d Pazar%n", day, month, year);
			break;
		case 1:
			System.out.printf("%02d/%02d/%04d Pazartesi%n", day, month, year);
			break;
		case 2:
			System.out.printf("%02d/%02d/%04d Salı%n", day, month, year);
			break;
		case 3:
			System.out.printf("%02d/%02d/%04d Çarşamba%n", day, month, year);
			break;
		case 4:
			System.out.printf("%02d/%02d/%04d Perşembe%n", day, month, year);
			break;
		case 5:
			System.out.printf("%02d/%02d/%04d Cuma%n", day, month, year);
			break;
		case 6:
			System.out.printf("%02d/%02d/%04d Cumartesi%n", day, month, year);
			break;
		default:
			System.out.println("Geçersiz tarih");
		}
		
		if (dayOfWeek == -1)
			return;
		
		System.out.println( isWeekday(day, month, year) ? "Hafta sonu kursu yaklaşıyor. Tekrar yapmayı unutmayınız!..." 
				: "Bugün kurs var. Tekrar yaptınız mı?");		
	}
	
	public static boolean isWeekday(int day, int month, int year)
	{
		return !isWeekend(day, month, year);		
	}
	
	public static boolean isWeekend(int day, int month, int year)
	{
		int dayOfWeek = getDayOfWeek(day, month, year);
		
		return dayOfWeek == 0 || dayOfWeek == 6;
	}
	
	public static int getDayOfWeek(int day, int month, int year)
	{
		int totalDays;		
		
		if (year < 1900 || (totalDays = getDayOfYear(day, month, year)) == 0)
			return -1;
		
		for (int y = 1900; y < year; ++y) 
			totalDays += isLeapYear(y) ? 366 : 365;			
		
		return totalDays % 7;
			
	}
	
	public static int getDayOfYear(int day, int month, int year)
	{		
		return isValidDate(day, month, year) ? day + getTotalDaysByMonth(month, year) : 0;
	}	
	
	public static int getTotalDaysByMonth(int month, int year)
	{
		int totalDays = 0;
		
		switch (month - 1) {
		case 11:
			totalDays += 30;
		case 10:
			totalDays += 31;
		case 9:
			totalDays += 30;
		case 8:
			totalDays += 31;
		case 7:
			totalDays += 31;
		case 6:
			totalDays += 30;
		case 5:
			totalDays += 31;
		case 4:
			totalDays += 30;
		case 3:
			totalDays += 31;
		case 2:
			totalDays += isLeapYear(year) ? 29 : 28;			
		case 1:
			totalDays += 31;
		}
		
		return totalDays;
	}
	
	public static boolean isValidDate(int day, int month, int year)
	{
		if (day < 1 || day > 31 || month < 1 || month > 12)
			return false;
		
		int days = 31;
		
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			days = isLeapYear(year) ? 29 : 28;						
		}
		
		return day <= days;
	}
	
	public static boolean isLeapYear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}
