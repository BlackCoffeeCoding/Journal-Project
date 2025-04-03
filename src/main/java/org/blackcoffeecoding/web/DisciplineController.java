package org.blackcoffeecoding.web;

import jakarta.validation.Valid;
import org.blackcoffeecoding.dto.AddDisciplineDto;
import org.blackcoffeecoding.dto.AddProfessorDto;
import org.blackcoffeecoding.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/disciplines")
public class DisciplineController {

    @Autowired
    private final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping("/add")
    public String addDiscipline() {
        return "disciplines-add";
    }

    @ModelAttribute("disciplineModel")
    public AddDisciplineDto initDiscipline() {
        return new AddDisciplineDto();
    }

    @PostMapping("/add")
    public String addDiscipline(@Valid AddDisciplineDto disciplineModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("disciplineModel", disciplineModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.disciplineModel",
                    bindingResult);
            return "redirect:/disciplines/add";
        }
        disciplineService.addDiscipline(disciplineModel);
        return "redirect:/disciplines/all";
    }

    @GetMapping("/all")
    public String showAllDiscipline(Model model) {
        model.addAttribute("disciplineInfos", disciplineService.allDisciplines());
        return "disciplines-all";
    }

    @GetMapping("/discipline-delete/{discipline-code}")
    public String deleteDiscipline(@PathVariable("discipline-code") Integer code) {
        disciplineService.removeDiscipline(code);
        return "redirect:/disciplines/all";
    }
}
