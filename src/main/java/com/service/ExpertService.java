package com.service;

import com.entity.ExpertEntity;
import java.util.List;
/**
 * Created by admin on 2018/1/3.
 */
public interface ExpertService {
    boolean addExpert(ExpertEntity expertEntity);

    List getAllExpert();
    ExpertEntity getExpertByEname(String ename);
    ExpertEntity getExpertByEid(int eid);
    boolean updateExpert(ExpertEntity expertEntity);
    boolean deleteExpert(int eid);
}
