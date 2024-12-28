package com.example.demo.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Agent;
import com.example.demo.entities.ChefDepartement;
import com.example.demo.entities.Employee;
import com.example.demo.services.EmployeeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @PostMapping("/login")
    public Employee login(@RequestBody Employee employee)
    {
    	return employeeService.login(employee);
    }
    
 // Add new employee
    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin employee) {
        return employeeService.addAdmin(employee);
    }


    // Update employee
    @PutMapping("/updateAdmin")
    public Admin updateAdmin(@RequestBody Admin employee) {
        return employeeService.updateAdmin(employee);
    }

    // Delete employee
    @DeleteMapping("/deleteAdminById/{id}")
    public boolean deleteAdminById(@PathVariable String id) {
        return employeeService.deleteAdminByID(id);
    }

    // Get all employee
    @GetMapping("/getAllAdmin")
    public List<Admin> getAllAdmin() {
        return employeeService.getAllAdmins();
    }
    
 // Add new employee
    @PostMapping("/addChefDepartement")
    public ChefDepartement addChefDepartement(@RequestBody ChefDepartement employee) {
        return employeeService.addChefDepartement(employee);
    }


    // Update employee
    @PutMapping("/updateChefDepartement")
    public ChefDepartement updateChefDepartement(@RequestBody ChefDepartement employee) {
        return employeeService.updateChefDepartement(employee);
    }

    // Delete employee
    @DeleteMapping("/deleteChefDepartementById/{id}")
    public boolean deleteChefDepartementById(@PathVariable String id) {
        return employeeService.deleteChefDepartementByID(id);
    }

    // Get all employee
    @GetMapping("/getAllChefDepartement")
    public List<ChefDepartement> getAll() {
        return employeeService.getAllChefDepartement();
    }
    
    // Add new employee
    @PostMapping("/addAgent")
    public Agent addAgent(@RequestBody Agent employee) {
        return employeeService.addAgent(employee);
    }


    // Update employee
    @PutMapping("/updateAgent")
    public Agent updateAgent(@RequestBody Agent employee) {
        return employeeService.updateAgent(employee);
    }

    // Delete employee
    @DeleteMapping("/deleteAgentById/{id}")
    public boolean deleteAgentByID(@PathVariable String id) {
        return employeeService.deleteAgentByID(id);
    }

    // Get all employee
    @GetMapping("/getAllAgent")
    public List<Agent> getAllAgent() {
        return employeeService.getAllAgent();
    }
}
