package com.smallapp.io.demotest.request;

import javax.validation.constraints.Min;

public class CreateAngsuranRequest {
    private String anggota;
    private String kode;

    @Min(value = 0L, message = "bayar request value must be positive")
    private Long bayar;
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
    public String getKeterangan() {
        return keterangan;
    }
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
