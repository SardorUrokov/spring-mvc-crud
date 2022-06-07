package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.entity.Group;
import uz.pdp.repository.GroupRepository;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/all")
    public ModelAndView getAll(ModelAndView mv) {

        List<Group> groupList = groupRepository.read();
        mv.addObject("listGroup", groupList);
        mv.setViewName("grRead");
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView getAddPage(ModelAndView mv) {
        mv.setViewName("grCreate");
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView saveStudent(@ModelAttribute("group") Group group, ModelAndView mv) {
        int num = groupRepository.create(group);

        if (num == 0) {
            mv.addObject("ketmon", "Group qo'shishda xatolik");
        } else {
            mv.addObject("ketmon", "Group added!");
        }
        mv.setViewName("grCreate"); //grCreate.jsp ni web papkadan qidiradi
        return mv;
    }

    @GetMapping("/update/{id}")
    public ModelAndView getUpdatePage(@PathVariable Integer id, ModelAndView mv) {
        Group groupById = groupRepository.findGroupById(id);
        List<Group> groupList = Collections.singletonList(groupById);
        mv.addObject("ketmon", groupList);
        mv.setViewName("grUpdate");
        return mv;
    }

    //    @PutMapping("/update/{id}") aslida http request bo'lsa
    @PostMapping("/update")
    public ModelAndView updateStudent(@ModelAttribute Group group, ModelAndView mv) {

        int counter = groupRepository.update(group);

        if (counter > 0) {
            mv.addObject("msg", "Group records updated against student id: " + group.getId());
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }
        mv.setViewName("grUpdate");
        return mv;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteStudent(@PathVariable Integer id, ModelAndView mv) {
        int counter = groupRepository.delete(id);

        if (counter > 0) {
            mv.addObject("msg", "Group records deleted against group id: " + id);
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }
        mv.setViewName("grDelete");
        return mv;
    }
}