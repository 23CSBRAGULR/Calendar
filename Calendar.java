import java.util.Scanner;

//The main and only class
public class Calendar {

    //The public, static array which contains all the months
    public static final String months[] = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };
    //The other public, static array which contains all the days
    public static final String days[] = {
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
    };

    //This method returns the month using the month array
    public static String months(int input) {
        return months[input - 1];
    }

    //This month checks whether a year is a Leap Year
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

    //This methods returns the day limit of a specific month
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

    //This method returns the day number(unprocessed) of the first day of a specific year
    public static int yearBeginning(int year) {
        int firstDay = year - 1900;
        for(int i = 1900; i < year; i++) {
            if(ifLeapYear(i)) {
                firstDay++;
            }
        }
        return firstDay;
    }

    //This method returns the day Number(unprocessed) of the first day of a specific month
    public static int monthBeginning(int year, int month) {
        int firstDay = yearBeginning(year);
        for(int i = 1; i < month; i++) {
            firstDay += monthDayLimit(year, i);
        }
        return firstDay;
    }

    //This method fetches the day number and returns the day respective to that number
    public static String days(int dayNumber) {
        return days[dayNumber];
    }

    //This method processes the day numbers of both year and month beginning methods and returns the required day
    public static String dayOfTheWeek(int year, int month, int date) {
        int firstDay = monthBeginning(year, month);
        int randomDay = firstDay + date;
        randomDay %= 7;
        String day = days(randomDay);
        return day;
    }

    //The main method
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
        
        //A loop for correcting the allignment of the dates respective to the day column and a specific count variable for counting the displacement
        int count = 0;
        int monthBeginning = (monthBeginning(year, month)) % 7;
        for(int i = 0; i <= monthBeginning; i++) {
            count++;
            System.out.print("\t");
        }
        //A loop that prints the specific month's Calender which starts printing the alligned values based on the count variable
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
