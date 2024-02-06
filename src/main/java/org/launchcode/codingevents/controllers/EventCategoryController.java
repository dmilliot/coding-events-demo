package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.EventCategory;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public class EventCategoryController {

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", EventRepository.findall());
        return "eventCategories/index";
    }

        @PostMapping("create")
        public String processCreateEventCategoryForm(@Valid @ModelAttribute EventCategory eventCategory, Errors errors, Model model) {

            if (errors.hasErrors()) {
                model.addAttribute("title", "Create Category");
                model.addAttribute(new EventCategory());
                return "eventCategories/create";
            }

            EventRepository.save(eventCategory);
            return "redirect:";
    }
}
