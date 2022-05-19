package com.arnugroho.springboot.hello.dao;

import com.arnugroho.springboot.hello.model.entity.Mahasiswa;


public interface MahasiswaDao {
    Mahasiswa findByNamaHql(String nama);
}
