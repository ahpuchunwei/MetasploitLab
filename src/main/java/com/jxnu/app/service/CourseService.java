package com.jxnu.app.service;

import com.jxnu.app.model.Course;

import java.util.List;

/**
 * Created by puchunwei on 16/5/1.
 */
public interface CourseService {
    void addCourse(Course course);

    void deleteCourse(Long id);

    void updateCourse(Course course);

    Course queryById(Long id);

    List<Course> findAll();
}