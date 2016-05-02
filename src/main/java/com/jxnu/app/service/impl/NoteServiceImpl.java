package com.jxnu.app.service.impl;

import java.util.List;

import com.jxnu.app.dao.NoteDao;
import com.jxnu.app.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxnu.app.dao.CourseDao;
import com.jxnu.app.model.Course;
import com.jxnu.app.service.CourseService;

/**
 * Created by puchunwei on 16/5/1.
 */
@Service
public class NoteServiceImpl implements NoteDao {
    @Autowired
    NoteDao noteDao;

    public void add(Note note) { noteDao.add(note);}

    public void delete(Long id) { noteDao.delete(id); }

    public Note queryById(Long id) { return noteDao.queryById(id);}

    public void update(Note note) { noteDao.update(note);}

    public List<Note> findAll() { return noteDao.findAll() ;}

    public List<Note> queryByCourseid(Long id) {
        return null;
    }

    public List<Note> queryNoteByCourse_id(Long id) { return noteDao.queryNoteByCourse_id(id) ;}
}
