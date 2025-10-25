package Penampungan;

import Model.Mahasiswa;

public class Node {
    public Mahasiswa data;
    public Node next;

    public Node(Mahasiswa data) {
        this.data = data;
        this.next = null;
    }
}