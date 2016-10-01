package proyecto;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Turpitude on 26/09/2016.
 */
public class Employee{
    public String DNI;
    public String department;
    public String name;
    public double salary;
    public int category;
    ArrayList<Sales> empsales;



    public Employee(String DNI, String name, double salary, int category,String department) {
        this.DNI = DNI;
        this.department=department;
        this.name = name;
        this.salary = salary;
        this.category = category;
        if(this.category==1){
           empsales = new ArrayList<Sales>();
        }
    }
    public void addsale(Sales s){
        empsales.add(s);
    }
    public double returnSalary(){
        return this.salary;
    }




}