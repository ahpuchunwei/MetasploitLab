package com.jxnu.app.dao;

import com.jxnu.app.model.Experiment;

/**
 * Created by puchunwei on 16/5/1.
 */
public interface ExperimentDao {

    void add(Experiment experiment);

    void delete(Long id);

    Experiment queryById(Long id);

    void update(Experiment experiment);
}
