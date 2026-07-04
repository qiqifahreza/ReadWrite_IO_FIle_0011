import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Mahasiswa extends Anggota {                                       // Inheritance Mahasiswa dari Anggota
    private String departmen;                                           // Attribute yang hanya dimiliki oleh class Mahasiswa

    public Mahasiswa(String nama, int umur, int ID, String jenis, String departmen) { // constructor Mahasiswa
        super(nama, umur, ID, jenis);
        this.departmen = departmen;
    }

    public String getDepartmen() {return departmen;}                    // getter: mengembalikan nilai departmen

    @Override                                                           // Override: mendefinisikan ulang method 'getSpesifikasi()'
    public String getSpesifikasi() {
        return "Departemen: " + departmen;
    }
}
class Dosen extends Anggota {                                           // Inheritance Dosen dari Anggota
    private String peMK;                                                // Attribute yang hanya dimiliki oleh class Dosen

    public Dosen(String nama, int umur, int ID, String jenis, String peMK) {          // constructor Dosen
        super(nama, umur, ID, jenis);
        this.peMK = peMK;
    }

    public String getPeMK() {return peMK;}                              // getter: mengembalikan nilai peMK

    @Override                                                           // Override: mendefinisikan ulang method 'getSpesifikasi()'
    public String getSpesifikasi() {
        return "Pengampu Mata Kuliah: " + peMK;
    }
}

class Karyawan extends Anggota {                                        // Inheritance Karyawan dari Anggota
    private String jabatan;                                             // Attribute yang hanya dimiliki oleh class Karyawan

    public Karyawan(String nama, int umur, int ID, String jenis, String jabatan) {    // constructor Karyawan
        super(nama, umur, ID, jenis);
        this.jabatan = jabatan;
    }

    public String getJabatan() {return jabatan;}                        // getter: mengembalikan nilai jabatan

    @Override                                                           // Override: mendefinisikan ulang method 'getSpesifikasi()'
    public String getSpesifikasi() {
        return "Jabatan: " + jabatan;
    }
}


abstract public class Anggota {
    private String nama;
    private int umur;
    private int ID;
    private String jenis;
    private int jumlahPinjam = 0;
    private List<String> b = new ArrayList<>();

    public Anggota(String nama, int umur, int ID, String jenis) {                     // constructor anggota
        this.nama = nama;
        this.umur = umur;
        this.ID = ID;
        this.jenis = jenis;
    }

    public String getNama() {return nama;}                              //  getter: mengembalikan nilai    
    public int getumur() {return umur;}                                 //  getter: mengembalikan nilai
    public int getID() {return ID;}                                     //  getter: mengembalikan nilai
    public String getJenis() {return jenis;}                            //  getter: mengembalikan nilai
    public int tambahPinjam() {return jumlahPinjam++;}                  //  menambahkan jumlah pinjam buku
    public int getJumlahPinjam() {return jumlahPinjam;}                 //  getter: mengembalikan nilai
    public void JudulBuku(String judulBuku) {b.add(judulBuku);}         //  memasukkan judul buku yang berhasil di pinjam
    public String getJudulBuku() {return b.toString();}                 //  mengubah List<String> menjadi teks String agar berhasil dimasukkan ke FileWritter
    abstract public String getSpesifikasi();                            //  abstract: karena tidak memiliki nilai maka menggunakan abstract <getter>

    
    public static void simpanAnggota(List<Anggota> anggota, String namaFile )throws IOException {
        FileWriter fw = new FileWriter(namaFile);
        for (Anggota a : anggota) {                                     // looping untuk mengambil satu per satu objek di dalam List
            fw.write(
                "nama: " + a.getNama() + "\n" + 
                "Umur: " + a.getumur() + "\n" + 
                "ID: " + a.getID() +"\n" + 
                "Jenis: " + a.getJenis() + "\n" + 
                a.getSpesifikasi() + "\n" +
                "Buku yang Di pinjam: " + a.getJudulBuku() + "\n" +
                "Jumlah Buku yang Di pinjam: " + a.getJumlahPinjam() +
                "\n\n");
        }                                                               // menulis dan disimpan kedalam (namafile)
        fw.close();                                                     // menutup FileWritter
    }

    public static void bacaAnggota(String namaFile)throws IOException {
        List<String> Baris = Files.readAllLines(Paths.get(namaFile));   // membaca isi dari (namafile) secara mentah-mentah(<String>)
            for (String s : Baris) {                                    // looping untuk mengambil satu per satu objek di dalam List
                System.out.println(s);                                  // menampilkan output semua isi dari (namafile)
            }
    }
}