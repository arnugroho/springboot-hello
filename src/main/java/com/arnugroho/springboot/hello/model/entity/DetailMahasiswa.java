package com.arnugroho.springboot.hello.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_dtl_mhs")
public class DetailMahasiswa {
    @Id
    @Column(name = "dtl_id")
    private Integer detailId;
    @Column(name = "gol_darah")
    private String golanganDarah;
    @Column(name = "jenis_kelamin")
    private String jenisKelamin;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public String getGolanganDarah() {
        return golanganDarah;
    }

    public void setGolanganDarah(String golanganDarah) {
        this.golanganDarah = golanganDarah;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
}
