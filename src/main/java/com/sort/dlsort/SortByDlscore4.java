package com.sort.dlsort;

import com.entity.DlassessEntity;

import java.util.Comparator;

/**
 * Created by X on 2018/1/7.
 */
public class SortByDlscore4 implements Comparator<DlassessEntity> {
    public int compare(DlassessEntity o1,DlassessEntity o2){
        if(o1.getDlscore4()>o2.getDlscore4()){
            return -1;
        }else if(o1.getDlscore4()<o2.getDlscore4()){
            return 1;
        }else{
            return 0;
        }
    }
}