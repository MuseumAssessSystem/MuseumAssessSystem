package com.dao;

import com.entity.ExpertEntity;

import java.util.List;

/**
 * Created by 10922 on 2017/12/29.
 */
public interface ExpertDAO {
    void addExpert(ExpertEntity expertEntity);
    void deleteExpert(ExpertEntity expertEntity);
    void updateExpert(ExpertEntity expertEntity);
    List<ExpertEntity> getExpert(ExpertEntity expertEntity);
    //to do..
}
