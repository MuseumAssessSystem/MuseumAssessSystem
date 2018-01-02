package com.dao;

import com.entity.MuseumEntity;

import java.util.List;

/**
 * Created by X on 2018/1/1.
 */
public interface MuseumDAO {
    void addMuseum(MuseumEntity museumEntity);
    void deleteMuseum(MuseumEntity museumEntity);
    void updateMuseum(MuseumEntity museumEntity);
    List<MuseumEntity> getMuseum(MuseumEntity museumEntity);
}
