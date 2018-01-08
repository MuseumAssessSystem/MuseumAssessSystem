package com.service;

import com.entity.MuseumEntity;

import java.util.List;

/**
 * Created by X on 2018/1/3.
 */
public interface MuseumService {
    boolean addMuseum(MuseumEntity museumEntity);
    boolean deleteMuseum(int mid);
    boolean updateMuseum(MuseumEntity museumEntity);
    List<MuseumEntity> getAllMuseum();
    List<MuseumEntity> getMuseumByName(String mname);
    List<MuseumEntity> getMuseumById(int mid);
    List<MuseumEntity> getMuseumByMtype(String mtype);
    List<MuseumEntity> getMuseumByMclass(String mclass);
}
