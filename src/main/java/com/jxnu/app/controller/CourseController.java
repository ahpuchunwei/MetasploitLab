package com.jxnu.app.controller;

import com.jxnu.app.model.Course;
import com.jxnu.app.model.Experiment;
import com.jxnu.app.service.CourseService;
import com.jxnu.app.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by puchunwei on 16/5/1.
 */
@Controller
public class CourseController {

    @Autowired
    CourseService     courseService;

    @Autowired
    ExperimentService experimentService;

    @RequestMapping("/courseManage")
    public ModelAndView courseManage() {
        ModelAndView modelAndView = new ModelAndView("/Admin/courseManage/index");
        List<Course> courseList = courseService.findAll();
        modelAndView.addObject("courseList", courseList);
        return modelAndView;
    }

    @RequestMapping("/addCourseUI")
    public ModelAndView addCourseUI() {
        ModelAndView modelAndView = new ModelAndView("/Admin/CourseManage/add");
        return modelAndView;
    }

    @RequestMapping("/addCourse")
    public ModelAndView addCourse(@RequestParam Map<String, String> data) {
        Course course = new Course();
        course.setName(data.get("name"));
        course.setIntroduction(data.get("introduction"));
        Long teacherId = Long.parseLong(data.get("teacher"));
        course.setTeacher(teacherId);
        course.setImage_url(data.get("image_url"));
        courseService.addCourse(course);

        ModelAndView modelAndView = courseManage();
        return modelAndView;

    }

    @RequestMapping("/deleteCourse")
    public ModelAndView deleteCourse(@RequestParam Map<String, String> data) {
        Long courseId = Long.parseLong(data.get("id"));
        courseService.deleteCourse((courseId));
        ModelAndView modelAndView = courseManage();
        return modelAndView;
    }

    @RequestMapping("/editCourseUI")
    public ModelAndView editCourseUI(@RequestParam Map<String, String> data) {
        Long courseId = Long.parseLong(data.get("id"));
        Course course = courseService.queryById((courseId));
        ModelAndView modelAndView = new ModelAndView("/Admin/courseManage/edit");
        modelAndView.addObject("course", course);
        return modelAndView;
    }

    @RequestMapping("/editCourse")
    public ModelAndView editCourse(@RequestParam Map<String, String> data) {
        Long courseId = Long.parseLong(data.get("id"));
        Course course = courseService.queryById((courseId));
        course.setName(data.get("name"));
        course.setIntroduction(data.get("introduction"));
        course.setTeacher(Long.parseLong(data.get("teacher")));
        course.setImage_url(data.get("image_url"));
        courseService.updateCourse(course);

        ModelAndView modelAndView = courseManage();
        return modelAndView;
    }

    /* 实验内容管理 */
    @RequestMapping("/experimentManage")
    public ModelAndView experimentManage() {
        ModelAndView modelAndView = new ModelAndView("/Admin/experimentManage/index");
        List<Experiment> experimentList = experimentService.findAll();
        modelAndView.addObject("experimentList", experimentList);
        return modelAndView;

    }

    @RequestMapping("/addExperimentUI")
    public ModelAndView addExperimentUI() {
        ModelAndView modelAndView = new ModelAndView("/Admin/experimentManage/add");
        List<Course> courseList = courseService.findAll();
        modelAndView.addObject("courseList", courseList);
        return modelAndView;
    }

    @RequestMapping("/addExperiment")
    public ModelAndView addExperiment(@RequestParam Map<String, String> data) {
        Experiment experiment = new Experiment();
        experiment.setTitle(data.get("title"));
        experiment.setContent(data.get("content"));
        experiment.setCourseId(Long.parseLong(data.get("courseId")));
        experimentService.addExperiment(experiment);

        ModelAndView modelAndView = experimentManage();
        return modelAndView;
    }

    @RequestMapping("/deleteExperiment")
    public ModelAndView deleteExperiment(@RequestParam Map<String, String> data) {
        Long experimentId = Long.parseLong(data.get("id"));
        experimentService.deleteExperiment(experimentId);
        ModelAndView modelAndView = experimentManage();
        return modelAndView;
    }

    @RequestMapping("/editExperimentUI")
    public ModelAndView editExperimentUI(@RequestParam Map<String, String> data) {
        Long experimentId = Long.parseLong(data.get("id"));
        Experiment experiment = experimentService.queryById(experimentId);
        ModelAndView modelAndView = new ModelAndView("/Admin/experimentManage/edit");
        modelAndView.addObject("experiment", experiment);

        List<Course> courseList = courseService.findAll();
        modelAndView.addObject("courseList", courseList);
        return modelAndView;
    }

    @RequestMapping("/editExperiment")
    public ModelAndView editExperiment(@RequestParam Map<String, String> data) {
        Long experimentId = Long.parseLong(data.get("id"));
        Experiment experiment = experimentService.queryById(experimentId);
        experiment.setTitle(data.get("title"));
        experiment.setContent(data.get("content"));
        experiment.setCourseId(Long.parseLong(data.get("courseId")));

        experimentService.updateExperiment(experiment);

        ModelAndView modelAndView = experimentManage();
        return modelAndView;
    }

}
