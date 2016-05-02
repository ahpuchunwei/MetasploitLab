package com.jxnu.app.service.impl;

import com.jxnu.app.dao.ExperimentDao;
import com.jxnu.app.model.Experiment;
import com.jxnu.app.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by puchunwei on 16/5/1.
 */
@Service
public class ExperimentServiceImpl implements ExperimentService {

    @Autowired
    ExperimentDao experimentDao;

    public void addExperiment(Experiment experiment) {
        experimentDao.addExperiment(experiment);
    }

    public void deleteExperiment(Long id) {
        experimentDao.deleteExperiment(id);
    }

    public Experiment queryById(Long id) {
        return experimentDao.queryById(id);
    }

    public void updateExperiment(Experiment experiment) {
        experimentDao.updateExperiment(experiment);
    }

    public List<Experiment> findAll() {
        return experimentDao.findAll();
    }

    public List<Experiment> queryByCourseId(Long id) {
        return experimentDao.queryByCourseId(id);
    }
}
