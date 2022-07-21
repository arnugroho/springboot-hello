package com.arnugroho.springboot.hello.controller.convert;

import com.arnugroho.springboot.hello.model.dto.MahasiswaDto;
import com.arnugroho.springboot.hello.model.entity.Mahasiswa;

public class MahasiswaConvert {
    public static Mahasiswa convertDtoToEntity(MahasiswaDto dto){
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNim(dto.getNim());
        mahasiswa.setNama(dto.getNama());
        mahasiswa.setAlamat(dto.getAlamat());

        return mahasiswa;
    }

    public static MahasiswaDto convertEntityToDto(Mahasiswa entity){
        MahasiswaDto dto = new MahasiswaDto();
        dto.setNim(entity.getNim());
        dto.setNama(entity.getNama());
        dto.setAlamat(entity.getAlamat());

        return dto;
    }
}
