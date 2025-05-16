import java.util.Scanner;

public class Calendar {

    public static final String months[] = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };
    public static final String days[] = {
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
    };

    public static String months(int input) {
        return months[input - 1];
    }

    public static boolean ifLeapYear(int year) {
        boolean eligibility = false;
        if(year % 4 == 0) {
            if(year % 100 == 0) {
                if(year % 400 == 0) {
                    eligibility = true;
                }
            }
            else {
                eligibility = true;
            }
        }
        return eligibility;
    }

    public static int monthDayLimit(int year, int month) {
        int limit = 31;
        if(month == 4 || month == 6 || month == 9 || month == 11) {
            limit = 30;
        }
        else if(month == 2) {
            if(ifLeapYear(year)) {
                limit = 29;
            }
            else {
                limit = 28;
            }
        }
        return limit;
    }

    public static int yearBeginning(int year) {
        int firstDay = year - 1900;
        for(int i = 1900; i < year; i++) {
            if(ifLeapYear(i)) {
                firstDay++;
            }
        }
        return firstDay;
    }

    public static int monthBeginning(int year, int month) {
        int firstDay = yearBeginning(year);
        for(int i = 1; i < month; i++) {
            firstDay += monthDayLimit(year, i);
        }
        return firstDay;
    }

    public static String days(int dayNumber) {
        return days[dayNumber];
    }

    public static String dayOfTheWeek(int year, int month, int date) {
        int firstDay = monthBeginning(year, month);
        int randomDay = firstDay + date;
        randomDay %= 7;
        String day = days(randomDay);
        return day;
    }

    public static void main(String[] args) {
        Scanner inputs = new Scanner(System.in);

        System.out.print("Enter the Year : ");
        int year = inputs.nextInt();
        while(year < 1901) {
            System.out.print("Enter a Valid Year : ");
            year = inputs.nextInt();
        }
        
        System.out.print("Enter the Month(S.No) : ");
        int month = inputs.nextInt();
        while(month < 1 || month > 12) {
            System.out.print("Enter a Valid Month(S.No) : ");
            month = inputs.nextInt();
        }

        System.out.print("Enter the Date : ");
        int date = inputs.nextInt();
        while(date > 31 || date < 1 || date > monthDayLimit(year, month)) {
            System.out.print("Enter a Valid Date : ");
            date = inputs.nextInt();
        }
        inputs.close();

        System.out.println("\nYear\t: " + year);
        System.out.println("Month\t: " + months(month));
        System.out.println("Date\t: " + date);
        System.out.println("Day\t: " + dayOfTheWeek(year, month, date));

        System.out.println("\nMonth Calendar\n");
        System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
        int count = 0;
        int monthBeginning = (monthBeginning(year, month)) % 7;
        for(int i = 0; i <= monthBeginning; i++) {
            count++;
            System.out.print("\t");
        }
        for(int i = 1; i <= monthDayLimit(year, month); i++) {
            String dates = i + "\t";
            count++;
            if(count == 7) {
                dates = dates.trim();
                System.out.println(dates);
                count = 0;
                continue;
            }
            System.out.print(dates);
        }
    }
}