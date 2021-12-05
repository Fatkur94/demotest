package com.smallapp.io.demotest.request;

public class CreateTrxHistoryRequest {
    private String anggota;
    private String simpanpinjam;
    private String kode;
    private String jenis;
    private Long nominal;
    private String keterangan;
    public String getAnggota() {
        return anggota;
    }
    public void setAnggota(String anggota) {
        this.anggota = anggota;
    }
    public String getSimpanpinjam() {
        return simpanpinjam;
    }
    public void setSimpanpinjam(String simpanpinjam) {
        this.simpanpinjam = simpanpinjam;
    }
    public String getKode() {
        return kode;
    }
    public void setKode(String kode) {
        this.kode = kode;
    }
    public String getJenis() {
        return jenis;
    }
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    public Long getNominal() {
        return nominal;
    }
    public void setNominal(Long nominal) {
        this.nominal = nominal;
    }
    public String getKeterangan() {
        return keterangan;
    }
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
}