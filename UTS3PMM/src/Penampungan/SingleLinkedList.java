package Penampungan;

import Model.Mahasiswa;
import java.util.*;

public class SingleLinkedList {
    private Node head;

    public void tambahData(Mahasiswa mhs) {
        Node newNode = new Node(mhs);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    public boolean hapusData(String nim) {
        if (head == null) return false;

        if (head.data.getNim().equalsIgnoreCase(nim)) {
            head = head.next;
            return true;
        }

        Node prev = null, curr = head;
        while (curr != null && !curr.data.getNim().equalsIgnoreCase(nim)) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) return false;
        prev.next = curr.next;
        return true;
    }

    public Mahasiswa cariData(String key, boolean cariByNim) {
        Node temp = head;
        while (temp != null) {
            if (cariByNim && temp.data.getNim().equalsIgnoreCase(key))
                return temp.data;
            else if (!cariByNim && temp.data.getNama().equalsIgnoreCase(key))
                return temp.data;
            temp = temp.next;
        }
        return null;
    }

    public List<Mahasiswa> getAllDataSorted(String criteria) { // <-- Parameter diubah
        List<Mahasiswa> list = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        if (criteria.equals("IPK")) {
            list.sort(Comparator.comparingDouble(Mahasiswa::getIpk).reversed());
        } else {
            list.sort(Comparator.comparing(Mahasiswa::getNim));
        }

        return list;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
