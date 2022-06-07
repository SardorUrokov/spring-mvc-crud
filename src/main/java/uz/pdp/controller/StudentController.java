package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.entity.Student;
import uz.pdp.repository.StudentRepository;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/all")
    public ModelAndView getAll(ModelAndView mv) {

        List<Student> studentList = studentRepository.read();
        mv.addObject("listStudent", studentList);
        mv.setViewName("read");
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView getAddPage(ModelAndView mv) {
        mv.setViewName("create");
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView saveStudent(@ModelAttribute("student") Student student, ModelAndView mv) {
        int num = studentRepository.create(student);

        if (num == 0) {
            mv.addObject("ketmon", "Student qo'shishda xatolik");
        } else {
            mv.addObject("ketmon", "Student added!");
        }
        mv.setViewName("create"); //create.jsp ni   web papkadam qidiradi
        return mv;
    }

    @GetMapping("/update/{id}")
    public ModelAndView getUpdatePage(@PathVariable Integer id, ModelAndView mv) {
        Student studentById = studentRepository.findStudentById(id);
        List<Student> studentList = Collections.singletonList(studentById);
        mv.addObject("ketmon", studentList);
        mv.setViewName("update");
        return mv;
    }

    //    @PutMapping("/update/{id}") aslida http request bo'lsa
    @PostMapping("/update")
    public ModelAndView updateStudent(@ModelAttribute Student student, ModelAndView mv) {
        int counter = studentRepository.update(student);

        if (counter > 0) {
            mv.addObject("msg", "Student records updated against student id: " + student.getId());
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }
        mv.setViewName("update");
        return mv;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteStudent(@PathVariable Integer id, ModelAndView mv) {
        int counter = studentRepository.delete(id);

        if (counter > 0) {
            mv.addObject("msg", "Student records deleted against student id: " + id);
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }
        mv.setViewName("delete");
        return mv;
    }
}
