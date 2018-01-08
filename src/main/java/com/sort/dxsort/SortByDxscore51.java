package com.sort.dxsort;

import com.entity.DxassessEntity;

import java.util.Comparator;

/**
 * Created by admin on 2018/1/7.
 */
public class SortByDxscore51 implements Comparator<DxassessEntity> {
    public int compare(DxassessEntity o1, DxassessEntity o2){
        if(o1.getDxscore1()>o2.getDxscore51()){
            return -1;
        }else if(o1.getDxscore1()<o2.getDxscore51()){
            return 1;
        }else{
            return 0;
        }
    }
}
