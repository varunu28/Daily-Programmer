import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CalculateCommission {

    public static String inputFileName = "src/data.txt";
    public static String outputFileName = "src/commission.txt";
    public static int i = 0;
    public static List<Employee> employees = new ArrayList<>();
    public static List<String> lines = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        readInputData();
        updateEmployeeData();
        writeCommissionToFile();
    }

    public static void writeCommissionToFile() throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
        StringBuilder sb = new StringBuilder("");
        sb.append("\t").append("\t");
        for (Employee employee : employees) {
            sb.append(employee.getName()).append("\t");
        }

        writer.write(sb.append("\n").toString());
        sb.setLength(0);

        sb.append("Commission").append("\t");

        for (Employee employee : employees) {
            double commisssion = 0;
            List<Integer> revenue = employee.getRevenue();
            List<Integer> expense = employee.getExpense();

            for (int k=0; k<revenue.size(); k++) {
                if (revenue.get(k) > expense.get(k)) {
                    commisssion += 0.062*(revenue.get(k) - expense.get(k));
                }
            }

            sb.append(String.valueOf((Math.round(commisssion)))).append("\t");
        }

        writer.write(sb.append("\n").toString());

        writer.close();
    }

    public static void updateEmployeeData() {
        updateRevenue();
        updateExpenses();
    }

    public static void updateRevenue() {
        i++;
        addEmployees(lines.get(i++));
        while(!lines.get(i).equals("Expenses")) {
            String[] data = lines.get(i).trim().split("\\s+");
            for (int j=1; j<data.length; j++) {
                employees.get(j-1).addToRevenue(Integer.parseInt(data[j]));
            }
            i++;
        }
    }

    public static void updateExpenses() {
        i+=2;
        while(i<lines.size()) {
            String[] data = lines.get(i).trim().split("\\s+");
            for (int j=1; j<data.length; j++) {
                employees.get(j-1).addToExpenses(Integer.parseInt(data[j]));
            }
            i++;
        }
    }

    public static void addEmployees(String line) {
        String[] names = line.trim().split("\\s+");
        for (String name : names) {
            Employee employee = new Employee(name);
            employees.add(employee);
        }
    }

    public static void readInputData() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        String line;

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        reader.close();
    }
}
