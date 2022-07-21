package com.arnugroho.springboot.hello.controller;

import com.arnugroho.springboot.hello.controller.convert.MahasiswaConvert;
import com.arnugroho.springboot.hello.model.dto.MahasiswaDto;
import com.arnugroho.springboot.hello.model.entity.Mahasiswa;
import com.arnugroho.springboot.hello.service.MahasiswaNoTrxService;
import com.arnugroho.springboot.hello.service.MahasiswaTrxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trx")
public class MahasiswaTrxController {
    @Autowired
    private MahasiswaNoTrxService mahasiswaNoTrxService;
    @Autowired
    private MahasiswaTrxService mahasiswaTrxService;

    @PostMapping("/notrx")
    public MahasiswaDto saveNoTrx(@RequestBody MahasiswaDto mahasiswaDto){

        Mahasiswa entitymahasiswa = MahasiswaConvert.convertDtoToEntity(mahasiswaDto);
        Mahasiswa mahasiswa = mahasiswaNoTrxService.saveMahasiswaNoTrx(entitymahasiswa);

        return mahasiswaDto;
    }

    @PostMapping("/trx")
    public MahasiswaDto saveTrx(@RequestBody MahasiswaDto mahasiswaDto){

        Mahasiswa entitymahasiswa = MahasiswaConvert.convertDtoToEntity(mahasiswaDto);
        Mahasiswa mahasiswa = mahasiswaTrxService.saveMahasiswaTrx(entitymahasiswa);

        return mahasiswaDto;
    }

}
