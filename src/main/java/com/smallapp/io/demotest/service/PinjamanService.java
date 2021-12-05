package com.smallapp.io.demotest.service;

import java.util.Date;

import com.smallapp.io.demotest.domain.Pinjaman;
import com.smallapp.io.demotest.repositories.PinjamanRepository;
import com.smallapp.io.demotest.request.PinjamanRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PinjamanService {

    @Autowired
    public PinjamanRepository pinjamanRepository;

    public void createPinjaman(PinjamanRequest pinjamanRequest) {
        Pinjaman pinjaman = new Pinjaman();
        pinjaman.setAnggota(pinjamanRequest.getAnggota());
        pinjaman.setAngsuran(pinjamanRequest.getAngsuran());
        pinjaman.setKode(pinjamanRequest.getKode());
        pinjaman.setTgl_pinjam(new Date());
        pinjaman.setTotal_pinjam(pinjamanRequest.getTotal_pinjam());
        pinjaman.setKeterangan(pinjamanRequest.getKeterangan());
        pinjaman.setStatus(pinjamanRequest.getStatus());

        pinjamanRepository.save(pinjaman);
    }

}
