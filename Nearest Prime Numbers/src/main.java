import java.io.BufferedReader;
import java.io.FileReader;

public class main {
    public static void main(String[] args) throws Exception {

        // Enter all the input numbers in a text file and assign its path to FILENAME variable
        final String FILENAME = "D:\\Github\\Daily Programmer\\Nearest Prime Numbers\\input.txt";

        BufferedReader br = new BufferedReader(new FileReader(FILENAME));

        String sCurrentLine;

        while ((sCurrentLine = br.readLine()) != null) {
            int currentNum = Integer.parseInt(sCurrentLine.trim());
            if (isPrime(currentNum)) {
                System.out.println(currentNum + " is Prime");
            }
            else {
                int prevPrime = findPrevPrime(currentNum);
                int nextPrime = findNextPrime(currentNum);
                System.out.println(prevPrime + " < " + currentNum + " < " + nextPrime);
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        if (n <= 3) {
            return true;
        }

        if (n%2 == 0 || n%3 == 0) {
            return false;
        }

        int i = 5;
        while (i <= n/2) {
            if (n%i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static int findPrevPrime(int n) {
        int i = n-1;
        while (i >= 0) {
            if (isPrime(i)) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static int findNextPrime(int n) {
        int i = n+1;
        while (true) {
            if (isPrime(i)) {
                return i;
            }
            i++;
        }
    }
}
