import java.io.BufferedReader;
import java.io.FileReader;

public class SpeakingClock {
    public static void main(String[] args) throws Exception{
        final String FILENAME = "D:\\Github\\Daily Programmer\\Speaking Clock\\input.txt";
        BufferedReader br = new BufferedReader(new FileReader(FILENAME));

        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {

            String[] strs = sCurrentLine.trim().split(":");

            int hours = Integer.parseInt(strs[0]);
            int mins = Integer.parseInt(strs[1]);

            if (hours == 0 && mins == 0) {
                System.out.println("It's twelve am");
            }
            else {
                String ans = "";

                String AM_PM = "";
                if (hours > 12) {
                    AM_PM = "PM";
                    hours -= 12;
                } else {
                    AM_PM = "AM";
                }

                ans = "It's " + convert(hours) + " ";

                if (mins > 9) {
                    ans = ans + convert(mins) + " ";
                } else if (mins < 9 && mins > 0) {
                    ans = ans + " Oh " + convert(mins) + " ";
                }

                ans = ans + AM_PM;
                System.out.println(ans);
            }
        }
    }

    public static String convert(final int n) {
        final String[] units = { "", "One", "Two", "Three", "Four",
                "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen" };

        final String[] tens = {
                "", 		// 0
                "",		// 1
                "Twenty", 	// 2
                "Thirty", 	// 3
                "Forty", 	// 4
                "Fifty", 	// 5
                "Sixty", 	// 6
                "Seventy",	// 7
                "Eighty", 	// 8
                "Ninety" 	// 9
        };

        String stringValue = "";

        if (n < 20) {
            stringValue = units[n];
        }

        else if (n < 100) {
            stringValue = tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
        }
        return stringValue;
    }
}
