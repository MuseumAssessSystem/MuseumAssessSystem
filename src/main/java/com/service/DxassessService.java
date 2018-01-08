package com.service;

import com.entity.DxassessEntity;

import java.util.List;

/**
 * Created by admin on 2018/1/3.
 */
public interface DxassessService {
    boolean addDxassess(DxassessEntity dxassessEntity);

    boolean updateDxassess(DxassessEntity dxassessEntity);

    boolean deleteDxassess(DxassessEntity dxassessEntity);

    List<DxassessEntity> getDxassessByYear(int year);
    List<DxassessEntity> getDxassessByMid(int mid);
}
