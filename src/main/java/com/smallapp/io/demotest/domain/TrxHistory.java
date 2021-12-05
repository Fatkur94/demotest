package com.smallapp.io.demotest.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "trx_history")
public class TrxHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="anggota", nullable = false)
    private String anggota;

    @Column(name="simpanpinjam", nullable = false)
    private String simpanPinjam;

    @Column(name="kode")
    private String kode;

    @Column(name="jenis", nullable = false)
    private String jenis;

    @Column(name="nominal", nullable = false)
    @Min(value = 0L, message = "nominal value must be positive")
    private Long nominal;

    @Column(name="keterangan")
    private String keterangan;

    @Column(name="tgl_trx")
    private Date tgl_trx;

    public String getAnggota() {
        return anggota;
    }

    public void setAnggota(String anggota) {
        this.anggota = anggota;
    }

    public String getSimpanPinjam() {
        return simpanPinjam;
    }

    public void setSimpanPinjam(String simpanPinjam) {
        this.simpanPinjam = simpanPinjam;
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

    public Date getTgl_trx() {
        return tgl_trx;
    }

    public void setTgl_trx(Date tgl_trx) {
        this.tgl_trx = tgl_trx;
    }
}
