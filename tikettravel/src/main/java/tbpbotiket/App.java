package tbpbotiket;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SystemLogin signin = new SystemLogin();
        Travel pesanan1 = new Travel();
        TravelTransport transport1 = new TravelTransport();
        TravelSewa sewa1 = new TravelSewa();
        signin.login();
        int pilihan = 0;
        while (pilihan != 5) {
            System.out.println("");
            System.out.println("----------------------------------------------------");
            System.out.println("== Selamat Datang Di JTRANSPORT.id Layanan Sistem ==");
            System.out.println("");
            System.out.println("Pilihan Layanan:");
            System.out.println("1.Melakukan Pemesanan");
            System.out.println("2.Lihat Data Pesanan");
            System.out.println("3.Update Data Pesanan");
            System.out.println("4.Delete Data Pesanan");
            System.out.println("5.Tutup Sistem");
            try {
                System.out.print("Pilih Layanan (1-5): ");
                pilihan = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Pilih Dengan Memasukkan Pilihan Angka!");
            }

            switch (pilihan) {
                case 1:
                    pesanan1.pemesanan();
                    break;
                case 2:
                    pesanan1.lihatDataPesanan();
                    break;
                case 3:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("");
                    System.out.println("Pilih Data Pesanan Yang Ingin Diupdate:");
                    System.out.println("1.Travel Transport");
                    System.out.println("2.Travel Sewa");
                    System.out.println("Masukkan Pilihan : ");
                    Integer plhan = scanner.nextInt();
                    if (plhan == 1) {
                        transport1.updateDataTransport();
                    }
                    if (plhan == 2) {
                        sewa1.updateDataSewa();
                    } else {
                        System.out.println(" ");
                    }
                    break;
                case 4:
                    pesanan1.hapusDataPesanan();
                    break;
                case 5:
                    System.out.println("");
                    System.out.println("Terima Kasih Telah Menggunakan Layanan Kami, Sampai Jumpa Di Lain Kesempatan.");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Pilihan tidak Valid, Silahkan Pilih Lagi!");
                    System.out.println("");
                    break;
            }

        }

    }
}
