package com.smallapp.io.demotest.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "pinjaman")
public class Pinjaman implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="anggota", nullable = false)
    private String anggota;

    @Column(name="kode", nullable = false)
    private String kode;

    @Column(name="total_pinjam", nullable = false)
    @Min(value = 0L, message = "total_pinjam value must be positive")
    private Long total_pinjam;

    @Column(name="tgl_pinjam")
    private Date tgl_pinjam;

    @Column(name="tgl_lunas")
    private Date tgl_lunas;

    @Column(name="angsuran", nullable = false)
    private int angsuran;

    @Column(name="status")
    private String status;

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

    public Long getTotal_pinjam() {
        return total_pinjam;
    }

    public void setTotal_pinjam(Long total_pinjam) {
        this.total_pinjam = total_pinjam;
    }

    public Date getTgl_pinjam() {
        return tgl_pinjam;
    }

    public void setTgl_pinjam(Date tgl_pinjam) {
        this.tgl_pinjam = tgl_pinjam;
    }

    public Date getTgl_lunas() {
        return tgl_lunas;
    }

    public void setTgl_lunas(Date tgl_lunas) {
        this.tgl_lunas = tgl_lunas;
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
