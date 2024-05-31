package by.itclass.controllers;

import by.itclass.model.entities.Library;
import by.itclass.model.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LibraryController {
    private LibraryRepository repository;

    @Autowired
    public void setRepository(LibraryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String getAll(Model model) {
        var libraries = repository.findAll();
        model.addAttribute("libraries", libraries);
        return "index";
    }

    @GetMapping("/view/{id}")
    public String viewLibrary(
            @PathVariable(name = "id") int id,
            Model model) {
        var library = repository.findById(id).get();
        model.addAttribute("library", library);
        return "library";
    }

    @GetMapping("/del/{id}")
    public String delLibrary(
            @PathVariable(name = "id") int id) {
        repository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/add")
    public ModelAndView add() {
        return new ModelAndView("add-library", "library", new Library());
    }

    @PostMapping("/save")
    public String save(
            @ModelAttribute(name = "library") Library library) {
        repository.save(library);
        return "redirect:/";
    }

    @PostMapping("/add-old")
    public String addOld(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "address") String address) {
        repository.save(new Library(name, address));
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable(name = "id") int id) {
        var library = repository.findById(id).get();
        return new ModelAndView("upd-library", "library", library);
    }

    @PostMapping("/upd-old")
    public String updateOld(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "address") String address) {
        repository.save(new Library(id, name, address));
        return "redirect:/";
    }
}
