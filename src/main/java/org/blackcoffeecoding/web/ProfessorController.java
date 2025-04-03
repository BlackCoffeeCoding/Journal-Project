package org.blackcoffeecoding.web;

import jakarta.validation.Valid;
import org.blackcoffeecoding.dto.AddProfessorDto;
import org.blackcoffeecoding.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/add")
    public String addProfessor() {
        return "professors-add";
    }

    @ModelAttribute("professorModel")
    public AddProfessorDto initProfessor() {
        return new AddProfessorDto();
    }

    @PostMapping("/add")
    public String addProfessor(@Valid AddProfessorDto professorModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("professorModel", professorModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.professorModel",
                    bindingResult);
            return "redirect:/professors/add";
        }
        professorService.addProfessor(professorModel);
        return "redirect:/professors/all";
    }

    @GetMapping("/all")
    public String showAllProfessors(Model model) {
        model.addAttribute("professorInfos", professorService.allProfessors());
        return "professors-all";
    }

    @GetMapping("/professor-delete/{professor-personnel-number}")
    public String deleteProfessor(@PathVariable("professor-personnel-number") Integer personnelNumber) {
        professorService.removeProfessor(personnelNumber);
        return "redirect:/professors/all";
    }
}
