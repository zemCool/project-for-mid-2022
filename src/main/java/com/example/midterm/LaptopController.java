package com.example.midterm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LaptopController {

    private final LaptopService laptopService;

    @Autowired
    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping(path = "/")
    public String homePage(){
        return "home";
    }

    @GetMapping(path = "/getLaptops")
    public String tablePage(Model model){
        List<Laptop> laptopList  = laptopService.getLaptops();
        model.addAttribute("laptopList", laptopList);
        return "tablePage";
    }

    @GetMapping(path = "/newLaptop")
    public String newLaptopPage(Model model){
        model.addAttribute("laptop", new Laptop());
        return "newLaptop";
    }

    @RequestMapping(path = "/edit/{laptopId}")
    public ModelAndView editLaptop(
            @PathVariable("laptopId") Long laptopId
    ){
        ModelAndView modelAndView = new ModelAndView("newLaptop");
        Laptop laptop = laptopService.getLaptopById(laptopId);
        modelAndView.addObject("laptop", laptop);
        return modelAndView;
    }

    @RequestMapping(path = "/delete/{laptopId}")
    public String deleteLaptop(
            @PathVariable("laptopId") Long laptopId
    ){
        laptopService.deleteLaptop(laptopId);
        return "redirect:/getLaptops";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveLaptop(
            @ModelAttribute ("laptop") Laptop laptop
    ){
        laptopService.saveLaptop(laptop);
        return "redirect:/getLaptops";
    }
}
