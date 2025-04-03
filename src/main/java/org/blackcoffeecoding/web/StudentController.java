package org.blackcoffeecoding.web;

import jakarta.validation.Valid;
import org.blackcoffeecoding.dto.AddStudentDto;
import org.blackcoffeecoding.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/add")
    public String addStudent() {
        return "students-add";
    }

    @ModelAttribute("studentModel")
    public AddStudentDto initStudent() {
        return new AddStudentDto();
    }

    @PostMapping("/add")
    public String addStudent(@Valid AddStudentDto studentModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("studentModel", studentModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.studentModel",
                    bindingResult);
            return "redirect:/students/add";
        }
        studentService.addStudent(studentModel);
        return "redirect:/students/all";
    }

    @GetMapping("/all")
    public String showAllStudent(Model model) {
        model.addAttribute("studentInfos", studentService.allStudents());
        return "students-all";
    }

    @GetMapping("/student-delete/{student-gb-number}")
    public String deleteStudent(@PathVariable("student-gb-number") Integer gbNumber) {
        studentService.removeStudent(gbNumber);
        return "redirect:/students/all";
    }
}
