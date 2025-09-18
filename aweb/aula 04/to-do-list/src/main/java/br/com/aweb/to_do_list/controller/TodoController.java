package br.com.aweb.to_do_list.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.aweb.to_do_list.models.Todo;
import br.com.aweb.to_do_list.repository.TodoRepository;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/Todo")
public class TodoController {


    @Autowired
    TodoRepository todoRepository;

   // @GetMapping("/home")
   // public ModelAndView home(){
        //var modelAndView = new ModelAndView("home");
        //modelAndView.addObject("professor", "andre roberto da silva");
        //var alunos = List.of(
        //    "isac",
       //     "eli",
       //     "ana");
        //modelAndView.addObject("alunos", alunos);
        //modelAndView.addObject("ehverdade", true);
        //return modelAndView;
   // }


    @GetMapping
    public ModelAndView list(){
        //var modelAndView  = new ModelAndView("list");
        //modelAndView.addObject("todos", todoRepository.findAll());
        //return modelAndView;
        
        //return new ModelAndView("list", Map.of( "todos", todoRepository.findAll()));
         return new ModelAndView("list", Map.of( "todos", todoRepository.findAll(Sort.by("deadline"))));
    
    }
    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("form", Map.of("todo", new Todo()));
    }

    @PostMapping("/create")
    public String create(@Valid Todo todo, BindingResult result){
        if(result.hasErrors())
        return "form";
    todoRepository.save(todo);
    return "redirect:/todo";
    }

}
