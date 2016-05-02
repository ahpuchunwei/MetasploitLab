package com.jxnu.app.dao;

import com.jxnu.app.model.Note;

import java.util.List;

/**
 * Created by puchunwei on 16/5/1.
 */
public interface NoteDao {

    void add(Note note);

    void delete(Long id);

    Note queryById(Long id);

    void update(Note note);

    List<Note> findAll();

     List<Note> queryNoteByCourse_id(Long id);
}
