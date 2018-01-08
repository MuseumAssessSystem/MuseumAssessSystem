package com.service;

import com.entity.DlassessEntity;
import com.entity.DxassessexpertEntity;

/**
 * Created by 10922 on 2018/1/8.
 */
public interface FileService {
    void addDxassessexpertEntity(DxassessexpertEntity deEntity,String ename,String year);
    void addDlassessEntity(DlassessEntity dlEntity,String ename,String year);
}
