package com.arnugroho.springboot.hello.model.dto;

public class MahasiswaDetailDto {
    private String nama;
    private String golonganDarah;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(String golonganDarah) {
        this.golonganDarah = golonganDarah;
    }
}
