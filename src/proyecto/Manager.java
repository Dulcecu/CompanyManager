package proyecto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by Turpitude on 29/09/2016.
 */
public class Manager implements CompanyManager {
    HashMap<String, Department> departments= new HashMap<String,Department>();
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
        ArrayList<Department> Departmens = new ArrayList<Department>(departments.values());
        return Departmens;
    }

    @Override
    public ArrayList<Employee> EmployerBySalary() {
        ArrayList<Department> dep = new ArrayList<Department>(departments.values());
        ArrayList<Employee> emp= new ArrayList<Employee>();

        for(int i=0;i<dep.size();i++)
        {
            ArrayList<Employee> emp1;
            emp1=dep.get(i).salaries();
            emp.addAll(emp1);
        }
        Collections.sort(emp, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return new Double(o2.returnSalary()).compareTo(new Double(o1.returnSalary()));
            }
        });
        return emp;
    }

    @Override
    public ArrayList<Employee> EmployeeByDepartment(String name) {
        ArrayList<Employee> emp;
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
    }

    @Override
    public double Salaries(String Department) {
        Department dep = departments.get(Department);
        ArrayList<Employee> emp= dep.salaries();
        double sum=0;
        for(int i=0;i<emp.size();i++){
            sum=sum+emp.get(i).salary;
        }

        return sum;
    }

    @Override
    public double Salaries() {
        ArrayList<Department> dep = new ArrayList<Department>(departments.values());
        ArrayList<Employee> emp= new ArrayList<Employee>();
        for(int i=0;i<dep.size();i=0)
        {
            ArrayList<Employee> emp1= new ArrayList<Employee>();
            emp1=dep.get(i).salaries();
            emp.addAll(emp1);
        }
        double sum=0;
        for(int i=0;i<emp.size();i++){
            sum=sum+emp.get(i).salary;
        }
        return sum;
    }
}
