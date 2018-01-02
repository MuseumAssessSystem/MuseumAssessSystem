package com.dao;

import com.entity.DxassessEntity;

import java.util.List;

/**
 * Created by admin on 2018/1/1.
 */
public interface DxassessDAO {
    void addDxassess(DxassessEntity dxassessEntity);
    void deleteDxassess(DxassessEntity dxassessEntity);
    void updateDxassess(DxassessEntity dxassessEntity);
    List<DxassessEntity> getDxassess(DxassessEntity dxassessEntity);
    //to do..
}
