package com.dao;

import com.entity.DxassessexpertEntity;
import com.entity.ExpertEntity;

import java.util.List;

/**
 * Created by admin on 2018/1/6.
 */
public interface DxassessexpertDAO
{
    void addDxassessexpert(DxassessexpertEntity dxassessexpertEntity);
    void updateDxassessexpert(DxassessexpertEntity dxassessexpertEntity);
    void deleteDxassessexpert(DxassessexpertEntity dxassessexpertEntity);
    List<DxassessexpertEntity> getDxassessexpert(DxassessexpertEntity dxassessexpertEntity);
    List<ExpertEntity> getOptionDxassessexpertByYear(int year);
}
