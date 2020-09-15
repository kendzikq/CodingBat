public class Logic1 {

    // When squirrels get together for a party, they like to have cigars.
    // A squirrel party is successful when the number of cigars is between 40 and 60, inclusive.
    // Unless it is the weekend, in which case there is no upper bound on the number of cigars.
    // Return true if the party with the given values is successful, or false otherwise.
    public boolean cigarParty(int cigars, boolean isWeekend) {
        if (isWeekend)
            return cigars >= 40;
        return cigars >= 40 && cigars <= 60;
    }

    // You and your date are trying to get a table at a restaurant. The parameter "you" is the
    // stylishness of your clothes, in the range 0..10, and "date" is the stylishness of your date's clothes.
    // The result getting the table is encoded as an int value with 0=no, 1=maybe, 2=yes.
    // If either of you is very stylish, 8 or more, then the result is 2 (yes).
    // With the exception that if either of you has style of 2 or less, then the result is 0 (no).
    // Otherwise the result is 1 (maybe).
    public int dateFashion(int you, int date) {
        if (you <= 2 || date <= 2) {
            return 0;
        }
        return you >= 8 || date >= 8 ? 2 : 1;
    }

    // The squirrels in Palo Alto spend most of the day playing. In particular,
    // they play if the temperature is between 60 and 90 (inclusive).
    // Unless it is summer, then the upper limit is 100 instead of 90.
    // Given an int temperature and a boolean isSummer, return true if the squirrels play and false otherwise.
    public boolean squirrelPlay(int temp, boolean isSummer) {
        return isSummer ? temp >= 60 && temp <= 100 : temp >= 60 && temp <= 90;
    }

    // You are driving a little too fast, and a police officer stops you.
    // Write code to compute the result, encoded as an int value: 0=no ticket, 1=small ticket, 2=big ticket.
    // If speed is 60 or less, the result is 0. If speed is between 61 and 80 inclusive,
    // the result is 1. If speed is 81 or more, the result is 2. Unless it is your birthday -- on that day,
    // your speed can be 5 higher in all cases.
    public int caughtSpeeding(int speed, boolean isBirthday) {
        if (isBirthday)
            speed -= 5;
        if (speed <= 60)
            return 0;
        return (speed >= 81) ? 2 : 1;
    }

    // Given 2 ints, a and b, return their sum. However, sums in the range 10..19 inclusive, are forbidden,
    // so in that case just return 20.
    public int sortaSum(int a, int b) {
        int tempSum = a + b;
        return tempSum >= 10 && tempSum < 20 ? 20 : tempSum;
    }

    // Given a day of the week encoded as 0=Sun, 1=Mon, 2=Tue, ...6=Sat,
    // and a boolean indicating if we are on vacation, return a string of the form "7:00"
    // indicating when the alarm clock should ring. Weekdays, the alarm should be "7:00" and on the weekend
    // it should be "10:00". Unless we are on vacation -- then on weekdays it should be "10:00" and
    // weekends it should be "off".
    public String alarmClock(int day, boolean vacation) {
        return vacation ? isWeekend(day) ? "off" : "10:00" : isWeekend(day) ? "10:00" : "7:00";
    }

    private boolean isWeekend(int day) {
        return day == 0 || day == 6;
    }


}
