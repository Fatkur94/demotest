package com.smallapp.io.demotest.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trx_log")
public class TrxLog {

    @Id
    private String id;

    private String anggota;
    private String simpanpinjam;
    private String jenis;
    private String kode;
    private Long nominal;
    private String ketarangan;
    private String tgl_trx;

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
    public String getJenis() {
        return jenis;
    }
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    public String getKode() {
        return kode;
    }
    public void setKode(String kode) {
        this.kode = kode;
    }
    public Long getNominal() {
        return nominal;
    }
    public void setNominal(Long nominal) {
        this.nominal = nominal;
    }
    public String getKetarangan() {
        return ketarangan;
    }
    public void setKetarangan(String ketarangan) {
        this.ketarangan = ketarangan;
    }
    public String getTgl_trx() {
        return tgl_trx;
    }
    public void setTgl_trx(String tgl_trx) {
        this.tgl_trx = tgl_trx;
    }
}