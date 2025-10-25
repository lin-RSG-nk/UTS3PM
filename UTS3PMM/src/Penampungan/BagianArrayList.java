package Penampungan;

import Model.Mahasiswa;

import java.util.ArrayList;


public class BagianArrayList {
    private ArrayList<Mahasiswa> list = new ArrayList<>();

    public void Tambah(Mahasiswa mhs) {
        list.add(mhs);
    }

    public Mahasiswa CariBerdasarkanNama(String nim) {
        for (Mahasiswa mhs : list) {
            if (mhs.getNim().equalsIgnoreCase(nim)) {
                return mhs;
            }
        }
        return null;
    }

    public Mahasiswa CariBerdasarkanNim(String nama) {
        for (Mahasiswa mhs : list) {
            if (mhs.getNama().equalsIgnoreCase(nama)) {
                return mhs;
            }
        }
        return null;
    }

    public boolean HapusBerdasarkanNim(String nim) {
        for (Mahasiswa mhs : list) {
            if (mhs.getNim().equalsIgnoreCase(nim)) {
                list.remove(mhs);
                return true;
            }
        }
        return false;
    }


    public void TampilkanData() {
        if (list.isEmpty()) {
            System.out.println("Data masih kosong.");
            return;
        }
        System.out.println("==============================================");
        System.out.printf("%-15s %-20s %-15s %-5s\n", "NIM", "NAMA", "PRODI", "IPK");
        System.out.println("==============================================");
        for (Mahasiswa mhs : list) {
            System.out.printf("%-15s %-20s %-15s %-5.2f\n",
                    mhs.getNim(), mhs.getNama(), mhs.getProdi(), mhs.getIpk());
        }
        System.out.println("==============================================");
    }
}
