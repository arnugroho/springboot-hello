package com.arnugroho.springboot.hello.controller;

import com.arnugroho.springboot.hello.model.dto.DefaultResponse;
import com.arnugroho.springboot.hello.model.dto.MahasiswaDto;
import com.arnugroho.springboot.hello.model.entity.Mahasiswa;
import com.arnugroho.springboot.hello.repository.MahasiswaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {
    private final MahasiswaRepository mahasiswaRepository;

    public MahasiswaController(MahasiswaRepository mahasiswaRepository) {
        this.mahasiswaRepository = mahasiswaRepository;
    }

    @GetMapping("/")
    public MahasiswaDto getMahasiswa(){
        MahasiswaDto m = new MahasiswaDto();
        m.setNama("akbar");
        m.setAlamat("Bogor");
        return m;
    }

    @GetMapping("/mahasiswas")
    public List<MahasiswaDto> getListMahasiswa(){
//        List<MahasiswaDto> list = listData();
        List<MahasiswaDto> list = new ArrayList();
        for(Mahasiswa m :mahasiswaRepository.findAll()){
            list.add(convertEntityToDto(m));
        }

        return list;
    }

    @GetMapping("/getbyname/{name}")
    public DefaultResponse<MahasiswaDto> getByName(@PathVariable String name){
//        List<MahasiswaDto> list = listData();
//        MahasiswaDto mahasiswaDto = new MahasiswaDto();
//        for (MahasiswaDto m : list){
//            if(m.getNama().equalsIgnoreCase(name)){
//                mahasiswaDto = m;
//            }
//        }
        DefaultResponse<MahasiswaDto> response = new DefaultResponse<>();
        Optional<Mahasiswa> optional = mahasiswaRepository.findByNama(name);
        if(optional.isPresent()){
            response.setMessage("Data Ditemukan");
            response.setData(convertEntityToDto(optional.get()));
        } else {
            response.setMessage("Data Tidak Ditemukan");
        }
        return response;
    }

    public List<MahasiswaDto> listData(){
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

    @PostMapping("/save")
    public DefaultResponse<MahasiswaDto> savemahasiswa(@RequestBody MahasiswaDto mahasiswaDto){
        Mahasiswa mahasiswa = convertDtoToEntity(mahasiswaDto);
        DefaultResponse<MahasiswaDto> response = new DefaultResponse<>();
        Optional<Mahasiswa> optional = mahasiswaRepository.findById(mahasiswaDto.getNim());
        if(optional.isPresent()){
            response.setMessage("Error, Data Sudah Tersedia");
        } else {
            mahasiswaRepository.save(mahasiswa);
            response.setMessage("Berhasil Simpan Data");
            response.setData(mahasiswaDto);
        }

        return response;
    }

    public Mahasiswa convertDtoToEntity(MahasiswaDto dto){
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNim(dto.getNim());
        mahasiswa.setNama(dto.getNama());
        mahasiswa.setAlamat(dto.getAlamat());

        return mahasiswa;
    }

    public MahasiswaDto convertEntityToDto(Mahasiswa entity){
        MahasiswaDto dto = new MahasiswaDto();
        dto.setNim(entity.getNim());
        dto.setNama(entity.getNama());
        dto.setAlamat(entity.getAlamat());

        return dto;
    }
}
