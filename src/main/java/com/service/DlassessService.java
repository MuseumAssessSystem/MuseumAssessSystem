package com.service;

import com.entity.DlassessEntity;

import java.util.List;

/**
 * Created by X on 2018/1/5.
 */
public interface DlassessService {
   List<DlassessEntity> getDlassessByMid(int mid);
   List<DlassessEntity> getDlassess();
   List<DlassessEntity> getDlassessByYear(int year);
   boolean addDlassess(DlassessEntity dlassessEntity);
   boolean deleteDlassess(DlassessEntity dlassessEntity);
   boolean updateDlassess(DlassessEntity dlassessEntity);
   void computeDlassess(int year);
}
