package com.dao;

import com.entity.TotalassessEntity;

import java.util.List;

/**
 * Created by 10922 on 2018/1/8.
 */
public interface TotalassessDAO {
    void addTEntity(TotalassessEntity tEntity);
    void deleteTEntity(TotalassessEntity tEntity);
    void updateTEntity(TotalassessEntity tEntity);
    List<TotalassessEntity> getTEntity(TotalassessEntity tEntity);
}
