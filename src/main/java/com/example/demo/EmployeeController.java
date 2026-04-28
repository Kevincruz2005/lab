package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    // In-memory list (No Database)
    private static List<Employee> employees = new ArrayList<>();
    private static Long idCounter = 1L;

    @GetMapping("/")
    public String viewItems(Model model) {
        model.addAttribute("employees", employees);
        return "index";
    }

    @PostMapping("/add")
    public String addEmployee(@RequestParam String name, @RequestParam String department) {
        employees.add(new Employee(idCounter++, name, department));
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employees.removeIf(e -> e.getId().equals(id));
        return "redirect:/";
    }
}
