package proyecto;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Turpitude on 26/09/2016.
 */
public class Department {
    public String name;
    public String description;
    ArrayList<Employee> employees;


    public Department(String name,String description) {
        this.name=name;
        this.description=description;
        employees=new ArrayList<Employee>();

    }
    public void addemployee(Employee e){
        employees.add(e);
    }
    public Employee returnemp(String DNI){
        for(int i=0;i<employees.size();i++){

            if(DNI==employees.get(i).DNI)
            {
                return  employees.get(i);
            }
        }
        return null;
    }
    public void update (Employee e){
        for(int i=0;i<employees.size();i++){
            if(e.DNI==employees.get(i).DNI){
                employees.set(i,e);
            }
        }
    }
}


