package com.arnugroho.springboot.hello.model.entity;


import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;

@Entity
@Table(name = "t_mahasiswa")
public class Mahasiswa {
    @Id
    @Column(name = "nim")
    private Long nim;
    @Column(name = "nama")
    private String nama;
    @Column(name = "uname", unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "alamat")
    private String alamat;

    @Column(name = "detailid")
    private Integer detailId;

    @OneToOne
    @JoinColumn(name = "detailid", insertable = false, updatable = false)
    private DetailMahasiswa detailMahasiswa;

    public Mahasiswa() {
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Long getNim() {
        return nim;
    }

    public void setNim(Long nim) {
        this.nim = nim;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public DetailMahasiswa getDetailMahasiswa() {
        return detailMahasiswa;
    }

    public void setDetailMahasiswa(DetailMahasiswa detailMahasiswa) {
        this.detailMahasiswa = detailMahasiswa;
    }
}
