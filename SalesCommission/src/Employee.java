import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private List<Integer> revenues = new ArrayList<>();
    private List<Integer> expenses = new ArrayList<>();

    public Employee(String name) {
        this.name = name;
    }

    public void addToRevenue(int amt) {
        this.revenues.add(amt);
    }

    public void addToExpenses(int amt) {
        this.expenses.add(amt);
    }

    public List<Integer> getRevenue() {
        return this.revenues;
    }

    public List<Integer> getExpense() {
        return this.expenses;
    }

    public String getName() {
        return this.name;
    }
}