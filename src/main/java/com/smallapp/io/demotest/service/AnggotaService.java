package com.smallapp.io.demotest.service;

import com.smallapp.io.demotest.domain.Anggota;
import com.smallapp.io.demotest.repositories.AnggotaRepository;
import com.smallapp.io.demotest.request.CreateAnggotaRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AnggotaService {
    @Autowired
    public AnggotaRepository anggotaRepository;

    public void createAnggota(CreateAnggotaRequest anggotaRequest) {
        
        Anggota anggota = new Anggota();
        anggota.setNama(anggotaRequest.getNama());
        anggota.setAlamat(anggotaRequest.getAlamat());
        anggota.setKeterangan(anggotaRequest.getKeterangan());
        anggota.setTglLahir(anggotaRequest.getTgl_lahir());
        anggota.setGroupName(anggotaRequest.getGroup_name());
        anggotaRepository.save(anggota);
    }

    public void updateAnggotaInfo(Anggota anggota,String alamat, String keterangan) {
        anggota.setAlamat(alamat);
        anggota.setKeterangan(keterangan);
        anggotaRepository.save(anggota);
    }
    
    public void deleteAnggota(Anggota deleteAnggota) {
        anggotaRepository.delete(deleteAnggota);
    }
}
