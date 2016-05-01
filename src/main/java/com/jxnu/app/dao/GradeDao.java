package com.jxnu.app.dao;

import com.jxnu.app.model.Grade;

/**
 * Created by puchunwei on 16/5/1.
 */
public interface GradeDao {

    void add(Grade grade);

    void delete(Long id);

    Grade queryById(Long id);

    void update(Grade grade);
}
