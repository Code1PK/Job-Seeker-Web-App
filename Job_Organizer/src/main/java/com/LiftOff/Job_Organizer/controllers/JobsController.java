package com.LiftOff.Job_Organizer.controllers;

import com.LiftOff.Job_Organizer.data.JobRepository;
import com.LiftOff.Job_Organizer.models.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class JobsController {

    @Autowired
    JobRepository jobRepository;

    @GetMapping("jobs/add")
    public String displayAddJobForm(Model model) {
        model.addAttribute(new Job());
        model.addAttribute("title", "Add Job Application");
        return "jobs/add";
    }

    @PostMapping("jobs/add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job Application");
            return "jobs/add";
        }
        jobRepository.save(newJob);
        return "redirect:/jobs";
    }

    @GetMapping("jobs/details")
    public String displayJobDetails() {
        return "jobs/details";
    }

    }




