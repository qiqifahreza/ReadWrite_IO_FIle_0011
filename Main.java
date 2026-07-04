import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)throws IOException {                          // method inti yang akan dijalankan
        List<Anggota> anggota = new ArrayList<>();                                      // membuat objek ArrayList<>() baru dari Anggota
        PeminjamanBuku pb = new PeminjamanBuku();                                       // membuat objek dari PeminjamanBuku
        Anggota hasan = new Mahasiswa("hasan", 20, 2001, "Mahasiswa", "informatika");
        Anggota pIbnu = new Dosen("Pak Ibnu", 31, 1001, "Dosen", "Kalkulus");
        Anggota joy = new Karyawan("Joy", 27, 5001, "Karyawan", "Kepala Bagian");
        Anggota reyhan = new Mahasiswa("reyhan", 19, 2101, "Mahasiswa", "management");
        Anggota bLesti = new Dosen("Bu Lesti", 31, 1002, "Dosen", "Pengantar Teknologi Informasi");
        Anggota Albar = new Karyawan("Albar", 30, 5101, "Karyawan", "Pengawas"); 

        Buku sOF = new Buku("System Operation Foundations", 5);
        Buku thoCalc = new Buku("Thomas Calculus", 3);

        anggota.add(hasan);           // menambahkan data Mahasiswa
        anggota.add(pIbnu);                        // menambahkan data Dosen
        anggota.add(joy);               // menambahkan data Karyawan
        anggota.add(reyhan);           // menambahkan data Mahasiswa
        anggota.add(bLesti);   // menambahkan data Dosen
        anggota.add(Albar);                  // menambahkan data Karyawan
        
        System.out.println("=== DAFTAR BUKU ===");  // daftar stock awal buku
        System.out.println("Judul: " + sOF.getjudul() + "  |  Stock: " + sOF.getStock());
        System.out.println("Judul: " + thoCalc.getjudul() + "  |  Stock: " + thoCalc.getStock() + "\n");
        
        pb.pinjamBuku(joy, sOF);    //joy meminjam System Operation Foundation sebanyak 4 kali
        pb.pinjamBuku(joy, sOF);
        pb.pinjamBuku(joy, sOF);
        pb.pinjamBuku(hasan, sOF);  //hasan meminjam System Operation Foundation sebanyak 1 kali
        pb.pinjamBuku(joy, sOF);
        pb.pinjamBuku(pIbnu, sOF);  //pak Ibnu tidak bisa meminjam arena stok System Operation Foundation telah habis
        pb.pinjamBuku(bLesti, thoCalc); //bu lesti meminjam System Operation Foundation sebanyak 1 kali
        System.out.println("\n" + joy.getNama() + " meminjam sebanyak: " + joy.getJumlahPinjam());
        System.out.println(hasan.getNama() + " meminjam sebanyak: " + hasan.getJumlahPinjam());
        System.out.println(pIbnu.getNama() + " meminjam sebanyak: " + pIbnu.getJumlahPinjam()); // hasilnya 0 karena kehabisa stock System Operation Foundation
        System.out.println(bLesti.getNama() + " meminjam sebanyak: " + bLesti.getJumlahPinjam());
        
        Anggota.simpanAnggota(anggota, "anggota.txt");            // memanggil simpanAnggota(List<Anggota>, namafile): membuat file (namafile) dan menyimpan semua list anggota kedalamnya
        Anggota.bacaAnggota("anggota.txt");                       // memanggil bacaAnggota(namafile): membaca isi dari (namafile) secara mentah-mentah(<String>)

        System.out.println("\n=== SISA DAFTAR BUKU ===");       // daftar stock buku yang telah di pinjam
        System.out.println("Judul: " + sOF.getjudul() + "  |  Stock: " + sOF.getStock());
        System.out.println("Judul: " + thoCalc.getjudul() + "  |  Stock: " + thoCalc.getStock() + "\n");
        
    }
}