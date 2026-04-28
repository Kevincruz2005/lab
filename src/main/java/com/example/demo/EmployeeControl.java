package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeControl {

    @Autowired
    Erepo repo;

    // Show login page
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    // Handle login
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        if (username.equals("admin") && password.equals("admin123")) {
            return "redirect:/students";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    // Show students page
    @GetMapping("/employee")
    public String index(Model model) {
        model.addAttribute("student", new employee());
        model.addAttribute("students", repo.findAll());
        return "index";
    }

    // Save student
    @PostMapping("/save")
    public String save(@ModelAttribute Employee employee) {
        repo.save(employee);
        return "redirect:/students";
    }

    // Delete student
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/students";
    }
}
