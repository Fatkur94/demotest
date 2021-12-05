package com.smallapp.io.demotest.request;

import javax.validation.constraints.Min;

public class PinjamanRequest {
    private String anggota;
    private String kode;
    
    @Min(value = 0L, message = "The value must be positive")
    private Long total_pinjam;
    private int angsuran;
    private String status;
    private String keterangan;
    
    public String getAnggota() {
        return anggota;
    }
    public void setAnggota(String anggota) {
        this.anggota = anggota;
    }
    public String getKode() {
        return kode;
    }
    public void setKode(String kode) {
        this.kode = kode;
    }
    public Long getTotal_pinjam() {
        return total_pinjam;
    }
    public void setTotal_pinjam(Long total_pinjam) {
        this.total_pinjam = total_pinjam;
    }
    public int getAngsuran() {
        return angsuran;
    }
    public void setAngsuran(int angsuran) {
        this.angsuran = angsuran;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getKeterangan() {
        return keterangan;
    }
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

}
