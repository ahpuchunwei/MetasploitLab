package com.jxnu.app.dao;

import com.jxnu.app.model.Notes;

/**
 * Created by puchunwei on 16/5/1.
 */
public interface NoteDao {

    void add(Notes notes);

    void delete(Long id);

    Notes queryById(Long id);

    void update(Notes notes);
}
