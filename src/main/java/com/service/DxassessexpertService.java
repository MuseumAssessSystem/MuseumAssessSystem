package com.service;

import com.entity.DxassessexpertEntity;
import com.entity.ExpertEntity;

import java.util.List;

/**
 * Created by admin on 2018/1/6.
 */
public interface DxassessexpertService {
    boolean addDxassessexpert(DxassessexpertEntity dxassessexpertEntity);
    boolean updateDxassessexpert(DxassessexpertEntity dxassessexpertEntity);
    boolean deleteDxassessexpert(DxassessexpertEntity dxassessexpertEntity);
    List<DxassessexpertEntity> getDxassessexpert(DxassessexpertEntity dxassessexpertEntity);
    List<DxassessexpertEntity> getAllDxassessexpert();
    List<DxassessexpertEntity> getDxassessexpertByEdid(int edid);
    List<DxassessexpertEntity> getDxassessexpertByYear(int year);
    List<ExpertEntity> getOptionDxassessexpertByYear(int year);
}
