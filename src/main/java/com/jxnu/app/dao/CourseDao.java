package com.jxnu.app.dao;

import com.jxnu.app.model.Course;

import java.util.List;

/**
 * Created by puchunwei on 16/5/1.
 */
public interface CourseDao {

    void addCourse(Course course);

    void deleteCourse(Long id);

    void updateCourse(Course course);

    Course queryById(Long id);

    List<Course> findall();
}
