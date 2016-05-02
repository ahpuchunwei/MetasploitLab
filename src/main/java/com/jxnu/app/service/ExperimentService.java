package com.jxnu.app.service;

import com.jxnu.app.model.Experiment;

import java.util.List;

/**
 * Created by puchunwei on 16/5/1.
 */
public interface ExperimentService {

    void addExperiment(Experiment experiment);

    void deleteExperiment(Long id);

    Experiment queryById(Long id);

    void updateExperiment(Experiment experiment);

    List<Experiment> findAll();

    List<Experiment> queryByCourseId(Long id);

}
