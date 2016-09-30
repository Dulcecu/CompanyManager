package proyecto;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Turpitude on 29/09/2016.
 */
public class Manager implements CompanyManager {
    HashMap<String, Department> departments;
    ArrayList<Employee> employees;
    ArrayList<Sales> totalsales;

    @Override
    public void addDepartment(String name,String description) {

        Department dep= new Department(name,description);
        this.departments.put(name,dep);

    }

    @Override
    public void addEmployee(String DNI, String name, double salary, String Department) {
        Employee emp= new Employee(DNI,name,salary,Department,2);
        employees.add(emp);

    }

    @Override
    public void addSalesMan(String DNI, String name, double salary, String Department) {
        Employee emp= new Employee(DNI,name,salary,Department,1);
        employees.add(emp);
    }

    @Override
    public void addDirector(String DNI, String name, double salary, String Department) {
        Employee emp= new Employee(DNI,name,salary,Department,0);
        employees.add(emp);
    }

    @Override
    public ArrayList<Department> Departmens() {
        ArrayList<Department> Departmens = new ArrayList<Department>();
        for (int i=0;i<departments.size();i++){
            Departmens.add(departments.get(i));
        }

        return Departmens;
    }

    @Override
    public ArrayList<Employee> EmployerBySalary() {
        return null;
    }

    @Override
    public ArrayList<Employee> EmployerByDepartment() {
        return null;
    }

    @Override
    public void addSale(String DNI, int sale, double amount) {
        Sales sales = new Sales(DNI,sale,amount);
        totalsales.add(sales);
    }

    @Override
    public double Salaries(String Department) {
        return 0;
    }

    @Override
    public double Salaries() {
        return 0;
    }
}
