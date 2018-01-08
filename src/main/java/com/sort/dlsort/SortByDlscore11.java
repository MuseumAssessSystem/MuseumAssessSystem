package com.sort.dlsort;

import com.entity.DlassessEntity;

import java.util.Comparator;

/**
 * Created by X on 2018/1/7.
 */
public class SortByDlscore11 implements Comparator<DlassessEntity> {
    public int compare(DlassessEntity o1,DlassessEntity o2){
        if(o1.getDlscore11()>o2.getDlscore11()){
            return -1;
        }else if(o1.getDlscore11()<o2.getDlscore11()){
            return 1;
        }else{
            return 0;
        }
    }
}
