package com.smallapp.io.demotest.request;

import javax.validation.constraints.Min;

public class CreateSimpananRequest {
    private String anggota;
    private String jenis;

    @Min(value = 0L, message = "saldo request value must be positive")
    private Long saldo;
    
    public String getAnggota() {
        return anggota;
    }
    public void setAnggota(String anggota) {
        this.anggota = anggota;
    }
    public String getJenis() {
        return jenis;
    }
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    public Long getSaldo() {
        return saldo;
    }
    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }
}
