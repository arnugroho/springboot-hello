package com.arnugroho.springboot.hello.service;

import com.arnugroho.springboot.hello.model.entity.Mahasiswa;

public interface MahasiswaDaoService {
    Mahasiswa findByNamaHql(String nama);
}
