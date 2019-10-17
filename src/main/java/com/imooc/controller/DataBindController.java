package com.imooc.controller;

import com.imooc.dao.CourseDAO;
import com.imooc.entity.Course;
import com.imooc.entity.CourseList;
import com.imooc.entity.CourseMap;
import com.imooc.entity.CourseSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataBindController {

    @Autowired
    private CourseDAO courseDAO;

    @RequestMapping(value = "/baseType")
    @ResponseBody
    public String baseType(@RequestParam(value = "id") int id) {
        return "id:" + id;
    }

    @RequestMapping(value = "/packageType")
    @ResponseBody
    public String packageType(@RequestParam(value = "id") Integer id) {
        return "id:" + id;
    }

    @RequestMapping(value = "/arrayType")
    @ResponseBody
    public String arrayType(@RequestParam(value = "id") String[] name) {
        StringBuilder stringBuffer = new StringBuilder();
        for (String item : name) {
            stringBuffer.append(item);
        }
        return stringBuffer.toString();
    }

    @RequestMapping(value = "/pojoType")
    public ModelAndView pojoType(Course course) {
        courseDAO.add(course);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("index");
        modelAndView.addObject("courses", courseDAO.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "/listType")
    public ModelAndView listType(CourseList courseList) {
        for (Course course : courseList.getCourses()) {
            courseDAO.add(course);
        }
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("index");
        modelAndView.addObject("courses", courseDAO.getAll());

        return modelAndView;
    }
    @RequestMapping(value = "/mapType")
    public ModelAndView mapType(CourseMap courseMap) {
        for (String key: courseMap.getCourses().keySet()) {
            Course course = courseMap.getCourses().get(key);
            courseDAO.add(course);
        }
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("index");
        modelAndView.addObject("courses", courseDAO.getAll());

        return modelAndView;

    }

    @RequestMapping(value = "/setType")
    public ModelAndView setType(CourseSet courseSet) {
        for (Course course: courseSet.getCourses()) {
            courseDAO.add(course);
        }
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("index");
        modelAndView.addObject("courses", courseDAO.getAll());

        return modelAndView;

    }

    @RequestMapping(value = "/jsonType")
    @ResponseBody
    public Course jsonType(@RequestBody Course course) {
        course.setPrice(course.getPrice() + 100);
        return course;
    }

}
