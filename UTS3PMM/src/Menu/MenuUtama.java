package Menu;

import Model.Mahasiswa;
import Penampungan.SingleLinkedList;
import Penampungan.BagianArrayList;
import java.util.*;

public class MenuUtama {
    private SingleLinkedList linkedList = new SingleLinkedList();
    private BagianArrayList bagianArrayList = new BagianArrayList();
    private Scanner input = new Scanner(System.in);

    public void tampilkanMenu() {
        int pilihan;
        do {
            System.out.println("\n========= MENU UTAMA =========");
            System.out.println("1. Tambah Data");
            System.out.println("2. Cari Data (berdasarkan NIM)");
            System.out.println("3. Cari Data (berdasarkan Nama)");
            System.out.println("4. Hapus Data (berdasarkan NIM)");
            System.out.println("5. Tampilkan Semua Data");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1 -> tambahData();
                case 2 -> cariBerdasarkanNim();
                case 3 -> cariBerdasarkanNama();
                case 4 -> hapusBerdasarkanNim();
                case 5 -> tampilkanData();
                case 6 -> System.out.println("Program selesai.");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 6);
    }

    private Mahasiswa inputMahasiswa() {
        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Prodi: ");
        String prodi = input.nextLine();
        System.out.print("Masukkan IPK: ");
        double ipk = input.nextDouble();
        input.nextLine();
        return new Mahasiswa(nim, nama, prodi, ipk);
    }

    private void tambahData() {
        Mahasiswa mhs = inputMahasiswa();

        long startLinked = System.nanoTime();
        linkedList.tambahData(mhs);
        long endLinked = System.nanoTime();

        long startArray = System.nanoTime();
        bagianArrayList.Tambah(mhs);
        long endArray = System.nanoTime();

        System.out.println("\nData berhasil ditambahkan ke kedua struktur!");
        System.out.println("Waktu proses (LinkedList): " + (endLinked - startLinked) + " ns");
        System.out.println("Waktu proses (ArrayList): " + (endArray - startArray) + " ns");
    }


    private void cariBerdasarkanNim() {
        System.out.print("Masukkan NIM yang dicari: ");
        String nim = input.nextLine();

        long startLinked = System.nanoTime();
        Mahasiswa hasilLinked = linkedList.cariData(nim, true);
        long endLinked = System.nanoTime();

        long startArray = System.nanoTime();
        Mahasiswa hasilArray = bagianArrayList.CariBerdasarkanNama(nim);
        long endArray = System.nanoTime();

        System.out.println("\n=== Hasil Pencarian Berdasarkan NIM ===");
        System.out.println("\n[LinkedList]");
        if (hasilLinked != null)
            System.out.println(hasilLinked);
        else
            System.out.println("Data tidak ditemukan.");
        System.out.println("Waktu proses: " + (endLinked - startLinked) + " ns");

        System.out.println("\n[ArrayList]");
        if (hasilArray != null)
            System.out.println(hasilArray);
        else
            System.out.println("Data tidak ditemukan.");
        System.out.println("Waktu proses: " + (endArray - startArray) + " ns");
    }

    private void cariBerdasarkanNama() {
        System.out.print("Masukkan Nama yang dicari: ");
        String nama = input.nextLine();

        long startLinked = System.nanoTime();
        Mahasiswa hasilLinked = linkedList.cariData(nama, false);
        long endLinked = System.nanoTime();

        long startArray = System.nanoTime();
        Mahasiswa hasilArray = bagianArrayList.CariBerdasarkanNim(nama);
        long endArray = System.nanoTime();

        System.out.println("\n=== Hasil Pencarian Berdasarkan Nama ===");
        System.out.println("\n[LinkedList]");
        if (hasilLinked != null)
            System.out.println(hasilLinked);
        else
            System.out.println("Data tidak ditemukan.");
        System.out.println("Waktu proses: " + (endLinked - startLinked) + " ns");

        System.out.println("\n[ArrayList]");
        if (hasilArray != null)
            System.out.println(hasilArray);
        else
            System.out.println("Data tidak ditemukan.");
        System.out.println("Waktu proses: " + (endArray - startArray) + " ns");
    }

    private void hapusBerdasarkanNim() {
        System.out.print("Masukkan NIM yang akan dihapus: ");
        String nim = input.nextLine();

        long startLinked = System.nanoTime();
        boolean hasilLinked = linkedList.hapusData(nim);
        long endLinked = System.nanoTime();

        long startArray = System.nanoTime();
        boolean hasilArray = bagianArrayList.HapusBerdasarkanNim(nim);
        long endArray = System.nanoTime();

        System.out.println("\n=== Hasil Penghapusan ===");
        System.out.println("[LinkedList] " + (hasilLinked ? "Berhasil" : "Data tidak ditemukan."));
        System.out.println("Waktu proses: " + (endLinked - startLinked) + " ns");

        System.out.println("[ArrayList] " + (hasilArray ? "Berhasil" : "Data tidak ditemukan."));
        System.out.println("Waktu proses: " + (endArray - startArray) + " ns");
    }

    private void tampilkanData() {
        System.out.println("\n======= DAFTAR MAHASISWA (LinkedList) =======");
        long startLinked = System.nanoTime();
        List<Mahasiswa> dataLinked = linkedList.getAllDataSorted(true);
        long endLinked = System.nanoTime();

        if (dataLinked.isEmpty()) {
            System.out.println("Data masih kosong.");
        } else {
            for (Mahasiswa m : dataLinked) {
                System.out.println(m);
            }
        }
        System.out.println("Waktu proses display (LinkedList): " + (endLinked - startLinked) + " ns");

        System.out.println("\n======= DAFTAR MAHASISWA (ArrayList) =======");
        long startArray = System.nanoTime();
        bagianArrayList.TampilkanData();
        long endArray = System.nanoTime();
        System.out.println("Waktu proses display (ArrayList): " + (endArray - startArray) + " ns");
    }
}