package proyecto;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Turpitude on 29/09/2016.
 */
public class Manager implements CompanyManager {
    HashMap<String, Department> departments= new HashMap<String,Department>();
    ArrayList<Sales> totalsales;
    HashMap<String,Employee> employees= new HashMap<String,Employee>();



    @Override
    public void addDepartment(String name,String description) {

        Department dep= new Department(name,description);
        this.departments.put(name,dep);

    }

    @Override
    public void addEmployee(String DNI, String name, double salary, String Department) {
        Employee emp= new Employee(DNI,name,salary,2,Department);
        Department dep= departments.get(Department);
        dep.addemployee(emp);
        departments.put(Department,dep);
        employees.put(DNI,emp);

    }

    @Override
    public void addSalesMan(String DNI, String name, double salary, String Department) {
        Employee emp= new Employee(DNI,name,salary,1,Department);
        Department dep= departments.get(Department);
        dep.addemployee(emp);
        departments.put(Department,dep);
        employees.put(DNI,emp);
    }

    @Override
    public void addDirector(String DNI, String name, double salary, String Department) {
        Employee emp= new Employee(DNI,name,salary,0,Department);
        Department dep= departments.get(Department);
        dep.addemployee(emp);
        departments.put(Department,dep);
        employees.put(DNI,emp);
    }

    @Override
    public ArrayList<Department> returnDepartmens() {
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
    public ArrayList<Employee> EmployeeByDepartment(String name) {
        ArrayList<Employee> emp= new ArrayList<Employee>();
        Department dep = departments.get(name);
        emp=dep.employees;
        return emp;
    }

    @Override
    public void addSale(String DNI, int sale, double amount) {
        Employee emp =employees.get(DNI);
        Sales sales = new Sales(DNI,sale,amount);
        emp.addsale(sales);
        employees.put(DNI,emp);
        Department dep= departments.get(emp.department);
        emp=dep.returnemp(DNI);
        emp.addsale(sales);
        dep.update(emp);
        departments.put(dep.name,dep);
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
