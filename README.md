*This program finds out the day of a specific Date by fetching Year, Month, date info from the User.
*This program uses only one class which is the main class named Calender.
*But there are multiple methods inside this class.
*And there are Two public , static arrays which contain the days and months names.
*The method months() returns the month by fetching the info from the month[] array.
*The method ifLeapYear() returns a boolean value which checks whether the given year is a Leap Year.
*The method monthDayLimit() returns the day limit for the month given by the user.
*The yearBeginning() method returns the day number of the first day of the given year using the logic one day per year and an extra day for leap years.
*The monthBeginning() method returns the day number of the first day of the given month.
*The days() method returns the exact day of the given specific date by using the calculated result of the dayOfTheWeek() method.
*Inside the main method,
	*There is a Scanner named "inputs" which fetches the informations from the user.
 	*Then the year is fetched from the user with the condition that it must be greater than 1900(The refernce year which starts from Monday).
	*Then the month and date info are fetched based on its eligibility by passing them through the methods.
 	*Then all the required info are printed by passing the fetched data to the respective methods.
