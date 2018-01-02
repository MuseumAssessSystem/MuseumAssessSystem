package com.dao;

import com.entity.DlassessEntity;

import java.util.List;

/**
 * Created by X on 2018/1/1.
 */
public interface DlassessDAO {
    void addDlassess(DlassessEntity dlassessEntity);
    void deleteDlassess(DlassessEntity dlassessEntity);
    void updateDlassess(DlassessEntity dlassessEntity);
    List<DlassessEntity> getDlassess(DlassessEntity dlassessEntity);
}
