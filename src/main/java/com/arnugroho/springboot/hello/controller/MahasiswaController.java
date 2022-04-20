package com.arnugroho.springboot.hello.controller;

import com.arnugroho.springboot.hello.model.Mahasiswa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {
    @GetMapping("/")
    public Mahasiswa getMahasiswa(){
        Mahasiswa m = new Mahasiswa();
        m.setNama("akbar");
        m.setAlamat("Bogor");
        return m;
    }

    @GetMapping("/mahasiswas")
    public List<Mahasiswa> getListMahasiswa(){
        List<Mahasiswa> list = listData();

        return list;
    }

    @GetMapping("/{name}")
    public Mahasiswa getByName(@PathVariable String name){
        List<Mahasiswa> list = listData();
        Mahasiswa mahasiswa = new Mahasiswa();
        for (Mahasiswa m : list){
            if(m.getNama().equalsIgnoreCase(name)){
                mahasiswa = m;
            }
        }
        return mahasiswa;
    }

    public List<Mahasiswa> listData(){
        List<Mahasiswa> list = new ArrayList<>();
        Mahasiswa m = new Mahasiswa();
        m.setNama("akbar");
        m.setAlamat("Bogor");

        list.add(m);

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNama("nugroho");
        mahasiswa.setAlamat("jakarta");
        list.add(mahasiswa);
        return list;
    }
}
