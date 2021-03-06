package com.arnugroho.springboot.hello.controller;

import com.arnugroho.springboot.hello.controller.convert.MahasiswaConvert;
import com.arnugroho.springboot.hello.model.dto.DefaultResponse;
import com.arnugroho.springboot.hello.model.dto.MahasiswaDetailDto;
import com.arnugroho.springboot.hello.model.dto.MahasiswaDto;
import com.arnugroho.springboot.hello.model.entity.DetailMahasiswa;
import com.arnugroho.springboot.hello.model.entity.Mahasiswa;
import com.arnugroho.springboot.hello.repository.DetailMahasiswaRepository;
import com.arnugroho.springboot.hello.repository.MahasiswaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {
    private final MahasiswaRepository mahasiswaRepository;
    private final DetailMahasiswaRepository detailMahasiswaRepository;

    public MahasiswaController(MahasiswaRepository mahasiswaRepository, DetailMahasiswaRepository detailMahasiswaRepository) {
        this.mahasiswaRepository = mahasiswaRepository;
        this.detailMahasiswaRepository = detailMahasiswaRepository;
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
            list.add(MahasiswaConvert.convertEntityToDto(m));
        }

        return list;
    }

    @GetMapping("/mahasiswadetail/{idMhs}")
    public MahasiswaDetailDto getListMahasiswa(@PathVariable Long idMhs){
        Optional<Mahasiswa> optionalMahasiswa = mahasiswaRepository.findById(idMhs);
        MahasiswaDetailDto dto = new MahasiswaDetailDto();
        if(optionalMahasiswa.isPresent()){
            Mahasiswa mahasiswa = optionalMahasiswa.get();
            dto.setNama(mahasiswa.getNama());
            dto.setGolonganDarah(mahasiswa.getDetailMahasiswa().getGolanganDarah());
//            Optional<DetailMahasiswa> optionalDetailMahasiswa =  detailMahasiswaRepository.findById(mahasiswa.getDetailId());
//            if(optionalDetailMahasiswa.isPresent()){
//                DetailMahasiswa detailMahasiswa = optionalDetailMahasiswa.get();
//                dto.setGolonganDarah(detailMahasiswa.getGolanganDarah());
//            }
        }
        return dto;
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
            response.setData(MahasiswaConvert.convertEntityToDto(optional.get()));
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
        Mahasiswa mahasiswa = MahasiswaConvert.convertDtoToEntity(mahasiswaDto);
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


}
