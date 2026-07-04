class Buku {
    private String judul;
    private int stock;
    

    public Buku(String judul, int stock) { //constructor buku
        this.judul = judul;
        this.stock = stock;
    }
    public String getjudul() {return judul;}    // getter: mengembalikan nilai 
    public int getStock() {return stock;}       // getter: mengembalikan nilai
    public void kurangiStock() {this.stock--;}  // mengurangi stock buku ketika ada yang meminjam buku
}


public class PeminjamanBuku {
    public void pinjamBuku(Anggota a, Buku b) {
        if (b.getStock() > 0) {
            b.kurangiStock();   // mengurangi stock buku
            a.tambahPinjam();   // menambah jumlah pinjaman buku
            a.JudulBuku(b.getjudul());  // mengambil judul buku lalu dimasukkan ke List<String>
            System.out.println(a.getNama() + " meminjam buku " + b.getjudul());    
        }
        
        
    }
}

