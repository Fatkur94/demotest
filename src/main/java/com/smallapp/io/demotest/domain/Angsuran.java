package com.smallapp.io.demotest.domain;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.*;

import javax.persistence.*;

@Entity
@Table(name = "angsuran")
public class Angsuran implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="anggota", nullable = false)
    private String anggota;

    @Column(name="kode", nullable = false)
    private String kode;

    @Min(value = 0L, message = "bayar value must be positive")
    @Column(name="bayar", nullable = false)
    private Long bayar;

    @Column(name="periode", nullable = false)
    private int periode;

    @Column(name="status")
    private String status;

    @Column(name="tgl_bayar")
    private Date tgl_bayar;

    @Column(name="keterangan")
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

    public Long getBayar() {
        return bayar;
    }

    public void setBayar(Long bayar) {
        this.bayar = bayar;
    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTgl_bayar() {
        return tgl_bayar;
    }

    public void setTgl_bayar(Date tgl_bayar) {
        this.tgl_bayar = tgl_bayar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
