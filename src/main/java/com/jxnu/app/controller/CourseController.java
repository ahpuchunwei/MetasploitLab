package com.jxnu.app.controller;

import com.jxnu.app.model.Course;
import com.jxnu.app.model.Experiment;
import com.jxnu.app.model.Note;
import com.jxnu.app.service.CourseService;
import com.jxnu.app.service.ExperimentService;
import com.jxnu.app.service.NoteService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.Date;
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

    @Autowired
    NoteService       noteService;

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
    public ModelAndView addCourse(@RequestParam(value = "imgFile", required = false) MultipartFile file,
                                  @RequestParam Map<String, String> data) {
        Course course = new Course();
        course.setName(data.get("name"));
        course.setIntroduction(data.get("introduction"));
        Long teacherId = Long.parseLong(data.get("teacher"));
        course.setTeacher(teacherId);

        String fileName = file.getOriginalFilename();
        String path = "/Users/puchunwei/data/images/";

        if (StringUtils.isNotBlank(fileName)) {
            String prefix = fileName.substring(fileName.lastIndexOf("."));
            // md5(文件名+时间戳)
            fileName = DigestUtils.md5Hex(fileName + new Date()) + prefix;
        }
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        // 保存图片文件
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {

        }
        if (StringUtils.isNotEmpty(fileName)) {
            course.setImage_url("/data/images/" + fileName);
        }
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

    @RequestMapping("/courseDetail")
    public ModelAndView courseDetail(@RequestParam Map<String, String> data) {
        ModelAndView modelAndView = new ModelAndView("/Index/index/courseDetail");

        Long courseId = Long.parseLong(data.get("id"));
        Course course = courseService.queryById(courseId);

        modelAndView.addObject("course", course);
        List<Experiment> experimentList = experimentService.queryByCourseId(courseId);

        modelAndView.addObject("course", course);
        modelAndView.addObject("experimentList", experimentList);
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
        experiment.setContent(data.get("editorValue"));
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

    @RequestMapping("/experimentDetail")
    public ModelAndView experimentDetail(@RequestParam Map<String, String> data) {
        ModelAndView modelAndView = new ModelAndView("/Index/index/experimentDetail");
        Long experimentId = Long.parseLong(data.get("id"));
        Experiment experiment = experimentService.queryById(experimentId);
        modelAndView.addObject("experiment", experiment);
        return modelAndView;
    }



    @RequestMapping("/addNote")
    public ModelAndView addNote(@RequestParam Map<String, String> data) {
        Note note = new Note();
        note.setContent(data.get("content"));
        Long course_id = Long.parseLong(data.get("id"));
        note.setCourse_id(course_id);
        Long user_id = Long.parseLong(data.get("id"));
        note.setUser_id(user_id);
        noteService.add(note);
        return null;
    }

    @RequestMapping("/noteDetail")
    public ModelAndView noteDetail(@RequestParam Map<String, String> data) {
        ModelAndView modelAndView = new ModelAndView("/Index/index/courseDetail");
        Long course_id=Long.parseLong(data.get("id"));

        List<Note> noteList=noteService.queryNoteByCourse_id(course_id);
        modelAndView.addObject("noteList", noteList);

        return modelAndView;
    }
}
