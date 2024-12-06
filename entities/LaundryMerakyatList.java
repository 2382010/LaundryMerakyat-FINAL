package entities;

public class LaundryMerakyatList {

    private long id;
    private String namaPelanggan;
    private String nomorTelepon;
    private String alamatPelanggan;
    private String jenisPaket;
    private String jenisBarang;
    private int beratKg;
    private int hargaTotal;

    // Constructor kosong
    public LaundryMerakyatList() {}

    // Constructor dengan parameter
    public LaundryMerakyatList(long id, String namaPelanggan, String nomorTelepon, String alamatPelanggan,
                               String jenisPaket, String jenisBarang, int beratKg, int hargaTotal) {
        this.id = id;
        this.namaPelanggan = namaPelanggan;
        this.nomorTelepon = nomorTelepon;
        this.alamatPelanggan = alamatPelanggan;
        this.jenisPaket = jenisPaket;
        this.jenisBarang = jenisBarang;
        this.beratKg = beratKg;
        this.hargaTotal = hargaTotal;
    }

    // Getter dan Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getAlamatPelanggan() {
        return alamatPelanggan;
    }

    public void setAlamatPelanggan(String alamatPelanggan) {
        this.alamatPelanggan = alamatPelanggan;
    }

    public String getJenisPaket() {
        return jenisPaket;
    }

    public void setJenisPaket(String jenisPaket) {
        this.jenisPaket = jenisPaket;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public int getBeratKg() {
        return beratKg;
    }

    public void setBeratKg(int beratKg) {
        this.beratKg = beratKg;
    }

    public int getHargaTotal() {
        return hargaTotal;
    }

    public void setHargaTotal(int hargaTotal) {
        this.hargaTotal = hargaTotal;
    }

    @Override
    public String toString() {
        return "LaundryMerakyatList{" +
                "id=" + id +
                ", namaPelanggan='" + namaPelanggan + '\'' +
                ", nomorTelepon='" + nomorTelepon + '\'' +
                ", alamatPelanggan='" + alamatPelanggan + '\'' +
                ", jenisPaket='" + jenisPaket + '\'' +
                ", jenisBarang='" + jenisBarang + '\'' +
                ", beratKg=" + beratKg +
                ", hargaTotal=" + hargaTotal +
                '}';
    }
}
