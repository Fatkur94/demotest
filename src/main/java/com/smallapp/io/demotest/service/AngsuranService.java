package com.smallapp.io.demotest.service;

import java.util.Date;

import com.smallapp.io.demotest.config.Constants;
import com.smallapp.io.demotest.domain.Angsuran;
import com.smallapp.io.demotest.domain.Pinjaman;
import com.smallapp.io.demotest.repositories.AngsuranRepository;
import com.smallapp.io.demotest.repositories.PinjamanRepository;
import com.smallapp.io.demotest.request.CreateAngsuranRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AngsuranService {

    @Autowired
    public AngsuranRepository angsuranRepository;

    @Autowired
    public PinjamanRepository pinjamanRepository;

    public int create(CreateAngsuranRequest angsuranRequest) {
        Pinjaman pinjaman = pinjamanRepository.findOneByKode(angsuranRequest.getKode());
        Angsuran foundAngsuran = angsuranRepository.recentAngsuran(angsuranRequest.getKode());

        if ( pinjaman == null ||! pinjaman.getAnggota().equals(angsuranRequest.getAnggota()) ) {
            return Constants.NOT_FOUND;
        }
        if ( pinjaman.getStatus().equals(Constants.PAID)) {
            return Constants.ALREADY_PAID;
        }

        Angsuran angsuran = new Angsuran();
        angsuran.setAnggota(angsuranRequest.getAnggota());
        angsuran.setBayar(angsuranRequest.getBayar());
        angsuran.setKode(angsuranRequest.getKode());
        angsuran.setKeterangan(angsuranRequest.getKeterangan());
        angsuran.setTgl_bayar(new Date());
        angsuran.setStatus(Constants.PAID);
        if ( foundAngsuran == null ) 
            angsuran.setPeriode(1);
        else 
            angsuran.setPeriode(foundAngsuran.getPeriode() + 1);

        if ( pinjaman.getAngsuran() <= 1 )  {
            pinjaman.setStatus(Constants.PAID);
        }
        if ( foundAngsuran != null &&  pinjaman.getAngsuran() == angsuran.getPeriode() )  {
            pinjaman.setStatus(Constants.PAID);
            pinjaman.setTgl_lunas(new Date());
        }

        angsuranRepository.save(angsuran);
        
        return Constants.SUCCESS;
    }    
}