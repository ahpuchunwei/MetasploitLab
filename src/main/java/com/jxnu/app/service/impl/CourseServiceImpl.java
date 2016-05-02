package com.jxnu.app.service.impl;

import com.jxnu.app.dao.CourseDao;
import com.jxnu.app.model.Course;
import com.jxnu.app.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by puchunwei on 16/5/1.
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;
    public void addCourse(Course course) { courseDao.addCourse(course);}

    public void deleteCourse(Long id) { courseDao.deleteCourse(id);}

    public void updateCourse(Course course) { courseDao.updateCourse(course);}

    public Course queryById(Long id) {
        return courseDao.queryById(id);
    }

    public List<Course> findAll() {
        return courseDao.findAll();
    }
}
