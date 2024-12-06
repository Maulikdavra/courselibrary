package com.md.courselibrary.controller;

import com.md.courselibrary.entity.Publisher;
import com.md.courselibrary.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/add")
    public String showAddPublisherForm(Model model) {
        model.addAttribute("publisher", new Publisher()); // Provide an empty Category object for the form
        return "add-publisher";
    }

    @PostMapping("/add")
    public void addPublisher(@ModelAttribute Publisher publisher) {
        Publisher existingPublisher = publisherService.findPublisherByName(publisher.getName());
        if (existingPublisher == null) {
            publisherService.savePublisher(publisher);
        } else {
            // Optionally log or notify about duplicate authors
            System.out.println("Publisher already exists: " + publisher.getId());
        }
    }

    @GetMapping("/all")
    public String findAllPublishers(Model model) {
        model.addAttribute("publishers", publisherService.findAllPublishers());
        return "publishers";
    }

    @GetMapping("view/{id}")
    public String findPublisherById(@PathVariable Long id, Model model){
        Publisher publisher = publisherService.findPublisherById(id);
        model.addAttribute("publishers", publisher);
        return "list-publisher";
    }

    @GetMapping("/delete/{id}")
    public String deletePublisher(@PathVariable Long id){
        Long publisherId = publisherService.findPublisherById(id).getId();
        publisherService.deletePublisher(publisherId);
        return "redirect:/publishers/all";
    }

    @GetMapping("/edit/{id}")
    public String editPublisher(@PathVariable Long id, Model model) {
        Publisher publisher = publisherService.findPublisherById(id);
        model.addAttribute("publisher", publisher);
        return "update-publisher";
    }

    @PostMapping("/update")
    public String updatePublisher(@ModelAttribute Publisher publisher) {
        String name = publisher.getName();
        Publisher existingPublisherById = publisherService.findPublisherById(publisher.getId());
        if (existingPublisherById != null) {
            existingPublisherById.setName(publisher.getName());
            publisherService.savePublisher(existingPublisherById);
        }
        return "redirect:/publishers/all";
    }

    @PostMapping("/save")
    public String savePublisher(@ModelAttribute Publisher publisher, Model model) {
        Publisher existingPublisher = publisherService.findPublisherByName(publisher.getName());
        if (existingPublisher != null) {
            model.addAttribute("error", "Category with name " + publisher.getName() + " already exists.");
            model.addAttribute("publishers", publisher);
            return "publishers";
        }
        publisherService.savePublisher(publisher);
        return "redirect:/publishers/all";
    }
}
