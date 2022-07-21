package com.arnugroho.springboot.hello.service;

import com.arnugroho.springboot.hello.model.entity.Mahasiswa;

public interface MahasiswaNoTrxService {
    Mahasiswa saveMahasiswaNoTrx(Mahasiswa mahasiswa);
}
