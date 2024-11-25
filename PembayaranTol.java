import java.util.Scanner;

public class PembayaranTol {

    static final int[] TARIF_KENDARAAN = {10000, 15000, 20000}; 
    static final int TARIF_PER_KM = 2000; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("================================");
            System.out.println("Selamat datang di sistem pembayaran Tol!");
            System.out.println("1. Mobil (Rp 10.000)");
            System.out.println("2. Truk (Rp 15.000)");
            System.out.println("3. Bus (Rp 20.000)");
            System.out.println("4. Keluar");
            System.out.print("Pilih jenis kendaraan (1-4): ");
            int pilihan = scanner.nextInt();

            if (pilihan == 4) {
                System.out.println("Terima kasih telah menggunakan layanan tol.");
                break; 
            }

            if (pilihan < 1 || pilihan > 3) {
                System.out.println("Pilihan tidak valid. Silakan pilih antara 1-3.");
                continue; 
            }

            int tarifTol = getTarif(pilihan - 1); 
            System.out.println("Anda memilih kendaraan jenis " + getJenisKendaraan(pilihan));
            System.out.println("Tarif tol dasar yang harus dibayar adalah: Rp " + tarifTol);

            System.out.print("Masukkan jarak yang ditempuh (dalam km): ");
            int jarak = scanner.nextInt();

            int tarifPerJarak = jarak * TARIF_PER_KM;
            System.out.println("Tarif untuk jarak " + jarak + " km adalah: Rp " + tarifPerJarak);

            int totalTarif = tarifTol + tarifPerJarak;
            System.out.println("Total tarif tol yang harus dibayar: Rp " + totalTarif);

            System.out.print("Masukkan jumlah uang yang dibayar: Rp ");
            int uangDibayar = scanner.nextInt();

            prosesPembayaran(uangDibayar, totalTarif);
        }

        scanner.close();
    }

    public static String getJenisKendaraan(int jenis) {
        switch (jenis) {
            case 1: return "Mobil";
            case 2: return "Truk";
            case 3: return "Bus";
            default: return "Tidak diketahui";
        }
    }

    public static int getTarif(int jenis) {
        return TARIF_KENDARAAN[jenis];
    }

    public static void prosesPembayaran(int uangDibayar, int totalTarif) {
        if (uangDibayar >= totalTarif) {
            int kembalian = uangDibayar - totalTarif;
            System.out.println("Pembayaran berhasil!");
            System.out.println("Kembalian Anda: Rp " + kembalian);
        } else {
            System.out.println("Uang yang dibayar tidak cukup. Pembayaran gagal.");
        }
    }
}
