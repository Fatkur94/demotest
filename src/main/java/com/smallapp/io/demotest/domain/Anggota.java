package com.smallapp.io.demotest.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "anggota")
public class Anggota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name="id", nullable = false)
    private Long id;
    
    @Column(name="nama", nullable = false)
    private String nama;

    @Column(name="alamat", nullable = false)
    private String alamat;

    @Column(name="group_name", nullable = false)
    private String groupName;

    @Column(name="keterangan", nullable = false)
    private String keterangan;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_lahir")
    private Date tglLahir;


    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
}
