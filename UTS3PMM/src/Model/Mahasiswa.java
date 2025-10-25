package Model;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String prodi;
    private double ipk;

    public Mahasiswa(String nim, String nama, String prodi, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.ipk = ipk;
    }

    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public String getProdi() { return prodi; }
    public double getIpk() { return ipk; }

    @Override
    public String toString() {
        return String.format("NIM: %s | Nama: %s | Prodi: %s | IPK: %.2f", nim, nama, prodi, ipk);
    }
}