package proyecto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by Turpitude on 26/09/2016.
 */
public class Department {
    public String name;
    public String description;
    ArrayList<Employee> employees;


    public Department(String name, String description) {
        this.name = name;
        this.description = description;
        employees = new ArrayList<Employee>();

    }

    public void addemployee(Employee e) {
        employees.add(e);
    }

    public Employee returnemp(String DNI) {
        for (int i = 0; i < employees.size(); i++) {

            if (DNI == employees.get(i).DNI) {
                return employees.get(i);
            }
        }
        return null;
    }

    public void update(Employee e) {
        for (int i = 0; i < employees.size(); i++) {
            if (e.DNI == employees.get(i).DNI) {
                employees.set(i, e);
            }
        }
    }

    public ArrayList<Employee> salaries() {
        Employee emp;
        ArrayList<Employee> employ= new ArrayList<Employee>();
        int dire = 0;
        double sum=0;
        for (int i = 0; i < employees.size(); i++) {
            emp = employees.get(i);
            double salary = emp.salary;
            /*SALES MAN*/
            if (emp.category == 1) {
                for (int j = 0; j < emp.empsales.size(); j++) {
                    salary = salary + 0.1 * emp.empsales.get(j).amount;
                }

            }
            /*DIRECTOR*/
            if (emp.category == 0) {
                dire = i;
                sum=sum-salary;
            }
            emp.salary = salary;
            sum=sum+salary;
            employ.add(emp);

        }
        emp=employ.get(dire);
        emp.salary=emp.salary+0.05*sum;
        employ.set(dire,emp);
        Collections.sort(employ, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return new Double(o2.returnSalary()).compareTo(new Double(o1.returnSalary()));
            }
        });
        return employ;
    }

}


