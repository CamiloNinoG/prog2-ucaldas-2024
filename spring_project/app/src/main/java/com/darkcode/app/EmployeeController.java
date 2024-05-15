package com.darkcode.app;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.darkcode.app.domain.Employee;

@Controller
public class EmployeeController {    
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/saludo")
    public String saludo(Model model){
        model.addAttribute("mensaje", "Saludo");
        return "saludo";
    }

    @GetMapping("/employee")
    public String employeeInformation(Model model){
        Employee employee = new Employee();
        employee.setFullname("Camilo N");
        employee.setUser_email("camilo.nino48909@ucaldas.edu.co");
        model.addAttribute("employeeAtributtes", employee);
        return "employee";
    }

    @GetMapping("/employees")
    public String listEmployees(Model model){
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        employee1.setFullname("Camilo N");
        employee1.setUser_email("camilo.nino48909@ucaldas.edu.co");
        employee2.setFullname("Jorge L");
        employee2.setUser_email("jorge.lopez12@ucaldas.edu.co");

        ArrayList<Employee> employees_list = new ArrayList<>();
        employees_list.add(employee1);
        employees_list.add(employee2);

        model.addAttribute("listEmployeeAttributes", employees_list);
        return "employees";
    }
}
