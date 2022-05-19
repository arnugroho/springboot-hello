package com.arnugroho.springboot.hello.controller;

import com.arnugroho.springboot.hello.model.dto.DefaultResponse;
import com.arnugroho.springboot.hello.model.dto.MahasiswaDto;
import com.arnugroho.springboot.hello.model.entity.Mahasiswa;
import com.arnugroho.springboot.hello.service.MahasiswaDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mahasiswadao")
public class MahasiswaDaoController {
    @Autowired
    private MahasiswaDaoService mahasiswaDaoService;

//    @GetMapping("/")
//    public MahasiswaDto getMahasiswa(){
//        MahasiswaDto m = new MahasiswaDto();
//        m.setNama("akbar");
//        m.setAlamat("Bogor");
//        return m;
//    }
//
//    @GetMapping("/mahasiswas")
//    public List<MahasiswaDto> getListMahasiswa(){
////        List<MahasiswaDto> list = listData();
//        List<MahasiswaDto> list = new ArrayList();
//        for(Mahasiswa m :mahasiswaRepository.findAll()){
//            list.add(convertEntityToDto(m));
//        }
//
//        return list;
//    }

    @GetMapping("/getbyname/{name}")
    public DefaultResponse<MahasiswaDto> getByName(@PathVariable String name) {
//        List<MahasiswaDto> list = listData();
//        MahasiswaDto mahasiswaDto = new MahasiswaDto();
//        for (MahasiswaDto m : list){
//            if(m.getNama().equalsIgnoreCase(name)){
//                mahasiswaDto = m;
//            }
//        }
        DefaultResponse<MahasiswaDto> response = new DefaultResponse<>();
        Mahasiswa mahasiswa = mahasiswaDaoService.findByNamaHql(name);
        if (mahasiswa != null) {
            response.setMessage("Data Ditemukan");
            response.setData(convertEntityToDto(mahasiswa));
        } else {
            response.setMessage("Data Tidak Ditemukan");
        }
        return response;
    }

    public List<MahasiswaDto> listData() {
        List<MahasiswaDto> list = new ArrayList<>();
        MahasiswaDto m = new MahasiswaDto();
        m.setNama("akbar");
        m.setAlamat("Bogor");

        list.add(m);

        MahasiswaDto mahasiswaDto = new MahasiswaDto();
        mahasiswaDto.setNama("nugroho");
        mahasiswaDto.setAlamat("jakarta");
        list.add(mahasiswaDto);
        return list;
    }

//    @PostMapping("/save")
//    public DefaultResponse<MahasiswaDto> savemahasiswa(@RequestBody MahasiswaDto mahasiswaDto) {
//        Mahasiswa mahasiswa = convertDtoToEntity(mahasiswaDto);
//        DefaultResponse<MahasiswaDto> response = new DefaultResponse<>();
//        Optional<Mahasiswa> optional = mahasiswaRepository.findById(mahasiswaDto.getNim());
//        if (optional.isPresent()) {
//            response.setMessage("Error, Data Sudah Tersedia");
//        } else {
//            mahasiswaRepository.save(mahasiswa);
//            response.setMessage("Berhasil Simpan Data");
//            response.setData(mahasiswaDto);
//        }
//
//        return response;
//    }
//
    public Mahasiswa convertDtoToEntity(MahasiswaDto dto) {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNim(dto.getNim());
        mahasiswa.setNama(dto.getNama());
        mahasiswa.setAlamat(dto.getAlamat());

        return mahasiswa;
    }

    public MahasiswaDto convertEntityToDto(Mahasiswa entity) {
        MahasiswaDto dto = new MahasiswaDto();
        dto.setNim(entity.getNim());
        dto.setNama(entity.getNama());
        dto.setAlamat(entity.getAlamat());

        return dto;
    }
}
