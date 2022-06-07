package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.entity.Sinf;
import uz.pdp.repository.SinfRepository;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/class")
public class SinfController {

    @Autowired
    SinfRepository sinfRepository;

    @GetMapping("/all")
    public ModelAndView getAll(ModelAndView mv) {

        List<Sinf> sinfList = sinfRepository.read();
        mv.addObject("listClass", sinfList);
        mv.setViewName("clRead");
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView getAddPage (ModelAndView mv){
        mv.setViewName("clCreate");
    return mv;
    }

    @PostMapping("/add")
    public ModelAndView saveClass (@ModelAttribute("sinf") Sinf sinf, ModelAndView mv){
        int num = sinfRepository.create(sinf);

        if(num==0){
            mv.addObject("ketmon", "Sinf qo'shishda xatolik mavjud");
        }else {
            mv.addObject("ketmon", "Sinf added");
        }
        mv.setViewName("clCreate"); //grCreate.jsp ni web papkadan qidiradi
        return mv;
    }

    @GetMapping("/update/{id}")
    public ModelAndView getUpdatePage (@PathVariable Integer id, ModelAndView mv){
        Sinf sinfById = sinfRepository.findSinfById(id);
        List<Sinf> sinfList = Collections.singletonList(sinfById);
        mv.addObject("ketmon", sinfList);
        mv.setViewName("clUpdate");
        return mv;
    }

    //    @PutMapping("/update/{id}") aslida http request bo'lsa
    @PostMapping ("/update")
    public ModelAndView updateClass (@ModelAttribute Sinf sinf, ModelAndView mv){
        int counter = sinfRepository.update(sinf);

        if (counter==0){
            mv.addObject("msg", "Error. Something went wrong!");
        }else {
            mv.addObject("msg", "Sinf records deleted against class id: " + sinf.getId());
        }
        mv.setViewName("clUpdate");
        return mv;
    }

    @GetMapping("/delete/{id}")
    public  ModelAndView deleteClass (@PathVariable Integer id, ModelAndView mv){
        int counter = sinfRepository.delete(id);

        if (counter==0){
            mv.addObject("msg", "Error. Something went wrong!");
        }else {
            mv.addObject("msg", "Sinf records deleted against class id: " + id);
        }
        mv.setViewName("clDelete");
        return mv;
    }
}
