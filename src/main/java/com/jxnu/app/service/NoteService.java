package com.jxnu.app.service;

import com.jxnu.app.model.Note;

import java.util.List;

/**
 * Created by puchunwei on 16/5/2.
 */
public interface NoteService {

    void add(Note note);

    void delete(Long id);

    Note queryById(Long id);

    void update(Note note);

    List<Note> findAll();

    List<Note> queryNoteByCourse_id(Long id);



}
