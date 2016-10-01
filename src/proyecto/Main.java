package proyecto;

import java.util.AbstractCollection;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CompanyManager man = new Manager();
        man.addDepartment("DET","Departamento Especial de Tecnologia");
        man.addDepartment("IT","Informatica y Tecnologia");
        man.addDepartment("DDS","Departamento de Distribucion y Servicios");

        man.addEmployee("666J","Dolc",100,"DET");
        man.addEmployee("69F","Llas",50,"DET");
        man.addDirector("1337A","Grig",1000,"DET");

        man.addEmployee("100T","T",100,"IT");
        man.addSalesMan("300K","Cojo",500,"IT");
        man.addDirector("27C","Lobo",20,"IT");

        man.addEmployee("50X","Pallus",20,"DDS");
        man.addSalesMan("110R","Yisas",200,"DDS");
        man.addDirector("999H","Gunzi",1000,"DDS");

        man.addSale("110R",1,1000);
        man.addSale("300K",1,5000);

        ArrayList<Department> dep = man.returnDepartmens();
        for(int i=0;i<dep.size();i++){
            System.out.println(dep.get(i).description);
        }

        ArrayList<Employee> emp;
        /*emp= man.EmployeeByDepartment("IT");
        for(int i=0;i<emp.size();i++){
            System.out.println(emp.get(i).name);
        }*/
        emp=man.EmployerBySalary();
        for(int i=0;i<emp.size();i++){
            System.out.println(emp.get(i).name);
        }


    }
}
