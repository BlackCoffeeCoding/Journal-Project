package org.blackcoffeecoding.web;

import jakarta.validation.Valid;
import org.blackcoffeecoding.dto.AddLessonDto;
import org.blackcoffeecoding.services.DisciplineService;
import org.blackcoffeecoding.services.LessonService;
import org.blackcoffeecoding.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/lessons")
public class LessonController {
    @Autowired
    private final LessonService lessonService;
    @Autowired
    private final ProfessorService professorService;
    @Autowired
    private final DisciplineService disciplineService;

    public LessonController(LessonService lessonService, ProfessorService professorService, DisciplineService disciplineService) {
        this.lessonService = lessonService;
        this.professorService = professorService;
        this.disciplineService = disciplineService;
    }

    @GetMapping("/add")
    public String addLesson(Model model) {
        model.addAttribute("availableDisciplines", disciplineService.allDisciplines());
        model.addAttribute("availableProfessors", professorService.allProfessors());
        return "lessons-add";
    }

    @ModelAttribute("lessonModel")
    public AddLessonDto initLesson() {
        return new AddLessonDto();
    }

    @PostMapping("/add")
    public String addLesson(@Valid AddLessonDto lessonModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("lessonModel", lessonModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.lessonModel",
                    bindingResult);
            return "redirect:/lessons/add";
        }
        lessonService.addLesson(lessonModel);
        return "redirect:/lessons/all";
    }

    @GetMapping("/all")
    public String showAllLessons(Model model) {
        model.addAttribute("lessonInfos", lessonService.allLessons());
        return "lessons-all";
    }

    @GetMapping("/lesson-delete/{lesson-id}")
    public String deleteLesson(@PathVariable("lesson-id") String id) {
        lessonService.removeLesson(id);
        return "redirect:/lessons/all";
    }
}
