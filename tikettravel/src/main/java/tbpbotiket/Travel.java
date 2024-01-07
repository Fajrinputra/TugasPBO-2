package tbpbotiket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Superclass Travel
public class Travel implements TravelServices, interfaceDb {
    String namaPelanggan;
    String tanggalKeberangkatan;
    String waktuKeberangkatan;
    String rute;
    Integer jumlahKursi;
    String noKursi = " ";
    int jumlahUnitSewa;
    int durasi;
    int jumlahHarga;
    Scanner scanner = new Scanner(System.in);

    public Travel() {
    }

    // Constructor
    public Travel(String customerName, String destination, String departure, String startDate, String departureTime,
            String routes, Integer ticketPrice) {

    }

    public void Travel(String nma, int jmlh, String tgl, int drsi) {
        this.namaPelanggan = nma;
        this.jumlahUnitSewa = jmlh;
        this.tanggalKeberangkatan = tgl;
        this.durasi = drsi;
    }

    public void setNama(String nama) {
        this.namaPelanggan = nama;
    }

    public void setwaktuKeberangkatan(String set) {
        this.waktuKeberangkatan = set;
    }

    public void settglKeberangkatan(String set) {
        this.tanggalKeberangkatan = set;
    }

    public void setnoKursi(String k) {
        this.noKursi = k;
    }

    public void setjumlahkursi(Integer jml) {
        this.jumlahKursi = jml;
    }

    @Override
    public void pemesanan() {
        System.out.println(" ");
        System.out.println("Pilih Layanan Yang Ingin Dipesan: ");
        System.out.println("1.Travel Transport");
        System.out.println("2.Travel Sewa");
        System.out.print("Pilih Layanan: ");
        Integer choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("");
                System.out.println("**Silahkan Masukkan Data Pemesanan Ticket Berikut**");
                System.out.println("Masukan Nama Anda: ");
                Scanner walawe = new Scanner(System.in);
                String namaPelanggan2 = walawe.nextLine();
                setNama(namaPelanggan2);
                System.out.println("Kursi Tersedia:");
                List<String> kursiTersedia = new ArrayList<>();
                kursiTersedia.add("01");
                kursiTersedia.add("02");
                kursiTersedia.add("03");
                kursiTersedia.add("04");
                kursiTersedia.add("05");
                kursiTersedia.add("06");
                kursiTersedia.add("07");
                kursiTersedia.add("08");
                kursiTersedia.add("09");
                kursiTersedia.add("10");
                kursiTersedia.add("11");
                kursiTersedia.add("12");
                for (String kursi : kursiTersedia) {
                    System.out.print(kursi + " ");
                }

                setnoKursi(" ");
                System.out.println(" ");
                System.out.println("Masukkan Jumlah Kursi Pemesanan: ");
                Integer jmlhKursi = scanner.nextInt();
                setjumlahkursi(jmlhKursi);
                for (int i = 0; i < jmlhKursi; i++) {
                    this.noKursi += kursiTersedia.get(i) + " ";
                }
                System.out.println("No Kursi: " + noKursi);

                List<String> routes = new ArrayList<>();
                routes.add("1. Padang-Jambi \t\t Rp 250.000");
                routes.add("2. Padang-Pekanbaru \t\t Rp 180.000");
                routes.add("3. Padang-Palembang \t\t Rp 350.000");
                routes.add("4. Padang-Lampung \t\t Rp 450.000");
                routes.add("5. Padang-Medan \t\t Rp 350.000");

                System.out.println("");
                System.out.println("Rute Keberangkatan \t\tHarga Tiket");
                for (String listroute : routes) {
                    System.out.println(listroute);
                }
                System.out.println("Pilih Rute Keberangkatan: ");
                Integer plhn = scanner.nextInt();
                if (plhn == 1) {
                    this.rute = "Padang-Jambi";
                    this.jumlahHarga = jmlhKursi * 250000;
                } else if (plhn == 2) {
                    rute = "Padang-Pekanbaru";
                    this.jumlahHarga = jmlhKursi * 180000;
                } else if (plhn == 3) {
                    this.rute = "Padang-Palembang";
                    this.jumlahHarga = jmlhKursi * 350000;
                } else if (plhn == 4) {
                    this.rute = "Padang-Lampung";
                    this.jumlahHarga = jmlhKursi * 450000;
                } else if (plhn == 5) {
                    this.rute = "Padang-Medan";
                    this.jumlahHarga = jmlhKursi * 350000;
                } else {
                    System.out.println("inputan yang anda Masukkan salah !");
                }

                System.out.println("");
                System.out.println("Pilih Jam Keberangkatan: ");
                System.out.println("1. 08:00 WIB");
                System.out.println("2. 20:00 WIB");
                System.out.println("Enter your choice (1/2): ");
                int choi = scanner.nextInt();
                if (choi == 1) {
                    setwaktuKeberangkatan("08:00 WIB");
                } else if (choi == 2) {
                    setwaktuKeberangkatan("20:00 WIB");
                } else {
                    System.out.println("Invalid choice!");
                }
                System.out.println("");
                System.out.println("Masukkan Tanggal Keberangkatan: ");
                String tglString = walawe.nextLine();
                settglKeberangkatan(tglString);

                Date tanggal = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd/MM/yyyy");
                String tanggalTransaksi = dateFormat.format(tanggal);

                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss z");
                String waktuTransaksi = timeFormat.format(tanggal);

                System.out.println(" ");
                System.out.println("==========================================");
                System.out.println("Detail Pesanan Tiket:");
                System.out.println("Tanggal Transaksi \t:" + tanggalTransaksi);
                System.out.println("Waktu transaksi \t:" + waktuTransaksi);
                System.out.println("Nama Pemesan \t\t:" + namaPelanggan2);
                System.out.println("Rute Tujuan Destinasi\t:" + rute);
                System.out.println("Tanggal Keberangkatan\t:" + tanggalKeberangkatan);
                System.out.println("Jumlah Kursi Pemesanan\t:" + jmlhKursi);
                System.out.println("No Kursi Pemesanan\t:" + noKursi);
                System.out.println("Jam Keberangkatan\t:" + waktuKeberangkatan);
                System.out.println("Total Harga Tiket\t:" + jumlahHarga);
                this.masukkanDataTransport();
                break;

            case 2:
                Scanner alahtuma = new Scanner(System.in);
                System.out.println("");
                System.out.println("**Silahkan Masukkan Data Pemesanan Berikut**");
                System.out.println("Masukkan Nama Anda: ");
                String namaPelanggan1 = alahtuma.nextLine();
                System.out.println("Masukkan jumlah Unit yang ingin disewa:");
                Integer jumlahUnit1 = scanner.nextInt();
                System.out.println("Masukkan tanggal Keberangkatan: ");
                String tglawal = scanner.next();
                System.out.println("Masukkan Durasi Sewa: ");
                Integer durasiSewa = scanner.nextInt();
                jumlahHarga = jumlahUnit1 * durasiSewa * 500000;
                this.Travel(namaPelanggan1, jumlahUnit1, tglawal, durasiSewa);

                Date tanggal1 = new Date();
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("EEEE, dd/MM/yyyy");
                String tanggalTransaksi1 = dateFormat1.format(tanggal1);

                SimpleDateFormat timeFormat1 = new SimpleDateFormat("HH:mm:ss z");
                String waktuTransaksi1 = timeFormat1.format(tanggal1);

                System.out.println(" ");
                System.out.println("==========================================");
                System.out.println("Detail Pesanan Tiket:");
                System.out.println("Tanggal Transaksi \t:" + tanggalTransaksi1);
                System.out.println("Waktu Transaksi \t:" + waktuTransaksi1);
                System.out.println("Nama Pelanggan \t\t:" + namaPelanggan);
                System.out.println("Jumlah Unit yang Disewa :" + jumlahUnitSewa);
                System.out.println("Tanggal Keberangkatan \t:" + tanggalKeberangkatan);
                System.out.println("Durasi Sewa \t\t:" + durasi + " Hari");
                System.out.println("Total Harga \t\t:" + jumlahHarga);
                this.masukkanDataSewa();
                break;

            default:
                break;
        }
    }

    @Override
    public void masukkanDataTransport() {
        String URL = "jdbc:mysql://localhost:3306/tbtravel_pbo";
        String USER = "root";
        String PASSWORD = "";
        try {
            // Membuat koneksi ke database (ganti dengan informasi koneksi Anda)
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Query untuk menyimpan data pelanggan ke database
            String query = "INSERT INTO pelanggantraveltransport (nama_pemesan, rute_tujuan_destinasi, tanggal_keberangkatan, jumlah_kursi_pemesanan, no_kursi_pemesanan, jam_keberangkatan, total_harga_tiket) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Menyetel parameter query dengan nilai-nilai dari objek Pemesanan
            preparedStatement.setString(1, namaPelanggan);
            preparedStatement.setString(2, rute);
            preparedStatement.setString(3, tanggalKeberangkatan);
            preparedStatement.setInt(4, jumlahKursi);
            preparedStatement.setString(5, noKursi);
            preparedStatement.setString(6, waktuKeberangkatan);
            preparedStatement.setInt(7, jumlahHarga);

            // Eksekusi query
            preparedStatement.executeUpdate();

            // Menutup koneksi
            preparedStatement.close();
            connection.close();

            System.out.println("Data Pelanggan Berhasil Disimpan Ke Database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void masukkanDataSewa() {
        String URL = "jdbc:mysql://localhost:3306/tbtravel_pbo";
        String USER = "root";
        String PASSWORD = "";
        try {
            // Membuat koneksi ke database (ganti dengan informasi koneksi Anda)
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Query untuk menyimpan data pelanggan ke database
            String query = "INSERT INTO pelanggantravelsewa (nama_pelanggan, jumlah_unit_sewa, tanggal_keberangkatan, durasi_sewa, total_harga) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Menyetel parameter query dengan nilai-nilai dari objek Pemesanan
            preparedStatement.setString(1, namaPelanggan);
            preparedStatement.setInt(2, jumlahUnitSewa);
            preparedStatement.setString(3, tanggalKeberangkatan);
            preparedStatement.setInt(4, durasi);
            preparedStatement.setInt(5, jumlahHarga);

            // Eksekusi query
            preparedStatement.executeUpdate();

            // Menutup koneksi
            preparedStatement.close();
            connection.close();

            System.out.println("Data Pelanggan Berhasil Disimpan Ke Database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void lihatDataPesanan() {
        Scanner okeDa = new Scanner(System.in);
        System.out.println("");
        System.out.println("Pilihan Data Pesanan Yang Dapat Dilihat");
        System.out.println("1.Travel Transport");
        System.out.println("2.Travel Sewa");
        System.out.println("Masukkan Pilihan: ");
        Integer plhan = okeDa.nextInt();
        if (plhan == 1) {
            this.lihatDataTransport();
        }
        if (plhan == 2) {
            this.lihatDataSewa();
        } else {
            System.out.println("");
        }

    }

    @Override
    public void lihatDataTransport() {
        String URL = "jdbc:mysql://localhost:3306/tbtravel_pbo";
        String USER = "root";
        String PASSWORD = "";
        try {
            // Membuat koneksi ke database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Query untuk mendapatkan semua data
            String query = "SELECT nama_pemesan, rute_tujuan_destinasi, tanggal_keberangkatan, jumlah_kursi_pemesanan, no_kursi_pemesanan, jam_keberangkatan, total_harga_tiket FROM pelanggantraveltransport";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Eksekusi query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Menampilkan data pemesanan travel transport
            System.out.println("");
            System.out.println("Data Pemesanan Travel Transport:");
            while (resultSet.next()) {
                String NmaPemesan = resultSet.getString("nama_pemesan");
                String ruteK = resultSet.getString("rute_tujuan_destinasi");
                String tanggalK = resultSet.getString("tanggal_keberangkatan");
                int jumlahK = resultSet.getInt("jumlah_kursi_pemesanan");
                String noK = resultSet.getString("no_kursi_pemesanan");
                String jamK = resultSet.getString("jam_keberangkatan");
                int harga = resultSet.getInt("total_harga_tiket");
                System.out.println("");
                System.out.println("Nama Pemesan \t\t:" + NmaPemesan);
                System.out.println("Rute Tujuan Destinasi\t:" + ruteK);
                System.out.println("Tanggal Keberangkatan\t:" + tanggalK);
                System.out.println("Jumlah Kursi Yang Dipesan:" + jumlahK);
                System.out.println("Nomor Kursi yang Dipesan:" + noK);
                System.out.println("Jam Keberangkatan\t:" + jamK);
                System.out.println("Total Harga \t\t:" + harga);
                System.out.println("");
            }

            // Menutup koneksi
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void lihatDataSewa() {
        String URL = "jdbc:mysql://localhost:3306/tbtravel_pbo";
        String USER = "root";
        String PASSWORD = "";

        try {
            // Membuat koneksi ke database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Query untuk mendapatkan semua data kamar
            String query = "SELECT nama_pelanggan, jumlah_unit_sewa, tanggal_keberangkatan, durasi_sewa, total_harga FROM pelanggantravelsewa";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Eksekusi query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Menampilkan data pemesanan travel sewa
            System.out.println("");
            System.out.println("Data Pemesanan Travel Sewa:");
            while (resultSet.next()) {
                String NmaPemesan = resultSet.getString("nama_pelanggan");
                int jumlahU = resultSet.getInt("jumlah_unit_sewa");
                String tanggalK = resultSet.getString("tanggal_keberangkatan");
                int durasiS = resultSet.getInt("durasi_sewa");
                int harga = resultSet.getInt("total_harga");
                System.out.println("");
                System.out.println("Nama Pemesan \t\t:" + NmaPemesan);
                System.out.println("Jumlah Unit yang Disewa :" + jumlahU);
                System.out.println("Tanggal keberangkatan \t:" + tanggalK);
                System.out.println("Durasi Sewa \t\t:" + durasiS + " Hari");
                System.out.println("Total Harga \t\t:" + harga);
                System.out.println("");
            }

            // Menutup koneksi
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void hapusDataPesanan() {
        System.out.println("");
        System.out.println("Pilihan Data Pesanan Yang Ingin Dihapus:");
        System.out.println("1.Travel Transport");
        System.out.println("2.Travel Sewa");
        System.out.println("Masukkan Pilihan: ");
        Integer plhan = scanner.nextInt();
        if (plhan == 1) {
            this.hapusDataTransport();
        }
        if (plhan == 2) {
            this.hapusDataSewa();
        } else {
            System.out.println(" ");
        }
    }

    @Override
    public void hapusDataTransport() {
        Scanner tambuahCiek = new Scanner(System.in);
        System.out.println("");
        System.out.println("Masukkan Nama Pelanggan Yang Ingin Dihapus: ");
        String namaPelanggan = tambuahCiek.nextLine();

        try {
            String URL = "jdbc:mysql://localhost:3306/tbtravel_pbo";
            String USER = "root";
            String PASSWORD = "";
            // Membuat koneksi ke database (ganti dengan informasi koneksi Anda)
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Query untuk mencari data pelanggan berdasarkan nama
            String queryCari = "SELECT * FROM pelanggantraveltransport WHERE nama_pemesan = ?";
            PreparedStatement preparedStatementCari = connection.prepareStatement(queryCari);
            preparedStatementCari.setString(1, namaPelanggan);

            // Eksekusi query pencarian
            ResultSet resultSet = preparedStatementCari.executeQuery();

            // Cek apakah data ditemukan
            if (resultSet.next()) {
                // Jika data ditemukan, tampilkan data lama
                System.out.println("Data Pelanggan Yang Ingin Dihapus:");
                String NmaPemesan = resultSet.getString("nama_pemesan");
                String ruteK = resultSet.getString("rute_tujuan_destinasi");
                String tanggalK = resultSet.getString("tanggal_keberangkatan");
                int jumlahK = resultSet.getInt("jumlah_kursi_pemesanan");
                String noK = resultSet.getString("no_kursi_pemesanan");
                String jamK = resultSet.getString("jam_keberangkatan");
                int harga = resultSet.getInt("total_harga_tiket");
                System.out.println("");
                System.out.println("Nama Pemesan \t\t:" + NmaPemesan);
                System.out.println("Rute Tujuan Destinasi\t:" + ruteK);
                System.out.println("Tanggal Keberangkatan\t:" + tanggalK);
                System.out.println("Jumlah Kursi Di Pesan\t:" + jumlahK);
                System.out.println("Nomor Kursi Yang Dipesan:" + noK);
                System.out.println("Jam Keberangkatan\t:" + jamK);
                System.out.println("Total Harga Tiket\t:" + harga);
                System.out.println("");
                // Konfirmasi pengguna
                System.out.print("Apakah Anda Yakin Ingin Menghapus Pesanan Ini? (y/n): ");
                String konfirmasi = tambuahCiek.nextLine().toLowerCase();

                if (konfirmasi.equals("y")) {
                    // Jika pengguna mengonfirmasi, lakukan penghapusan
                    String queryHapus = "DELETE FROM pelanggantraveltransport WHERE nama_pemesan = ?";
                    PreparedStatement preparedStatementHapus = connection.prepareStatement(queryHapus);
                    preparedStatementHapus.setString(1, namaPelanggan);

                    // Eksekusi query hapus
                    preparedStatementHapus.executeUpdate();

                    System.out.println("Data Pelanggan Berhasil Dihapus.");
                    System.out.println(" ");
                } else {
                    System.out.println("Penghapusan Dibatalkan.");
                    System.out.println(" ");
                }

                // Menutup koneksi
                preparedStatementCari.close();
                connection.close();
            } else {
                System.out.println("Data pelanggan dengan nama " + namaPelanggan + " tidak ditemukan!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusDataSewa() {
        Scanner coy = new Scanner(System.in);
        System.out.println("");
        System.out.println("Masukkan Nama Pelanggan Yang Ingin Dihapus: ");
        String namaPelanggan = coy.nextLine();

        try {
            String URL = "jdbc:mysql://localhost:3306/tbtravel_pbo";
            String USER = "root";
            String PASSWORD = "";
            // Membuat koneksi ke database (ganti dengan informasi koneksi Anda)
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Query untuk mencari data pelanggan berdasarkan nama
            String queryCari = "SELECT * FROM pelanggantravelsewa WHERE nama_pelanggan = ?";
            PreparedStatement preparedStatementCari = connection.prepareStatement(queryCari);
            preparedStatementCari.setString(1, namaPelanggan);

            // Eksekusi query pencarian
            ResultSet resultSet = preparedStatementCari.executeQuery();

            // Cek apakah data ditemukan
            if (resultSet.next()) {
                // Jika data ditemukan, tampilkan data lama
                String NmaPemesan = resultSet.getString("nama_pelanggan");
                int jumlahU = resultSet.getInt("jumlah_unit_sewa");
                String tanggalK = resultSet.getString("tanggal_keberangkatan");
                int durasiS = resultSet.getInt("durasi_sewa");
                int harga = resultSet.getInt("total_harga");
                System.out.println("");
                System.out.println("Nama Pemesan \t\t:" + NmaPemesan);
                System.out.println("Jumlah Unit Yang Disewa\t:" + jumlahU);
                System.out.println("Tanggal keberangkatan\t:" + tanggalK);
                System.out.println("Durasi Sewa \t\t:" + durasiS + " Hari");
                System.out.println("Total Harga \t\t:" + harga);
                System.out.println("");
                // Konfirmasi pengguna
                System.out.print("Apakah Anda Yakin Ingin Menghapus Pesanan Ini? (y/n): ");
                String konfirmasi = coy.nextLine().toLowerCase();

                if (konfirmasi.equals("y")) {
                    // Jika pengguna mengonfirmasi, lakukan penghapusan
                    String queryHapus = "DELETE FROM pelanggantravelsewa WHERE nama_pelanggan = ?";
                    PreparedStatement preparedStatementHapus = connection.prepareStatement(queryHapus);
                    preparedStatementHapus.setString(1, namaPelanggan);

                    // Eksekusi query hapus
                    preparedStatementHapus.executeUpdate();

                    System.out.println("Data Pelanggan Berhasil Dihapus.");
                    System.out.println(" ");
                } else {
                    System.out.println("Penghapusan Dibatalkan.");
                    System.out.println(" ");
                }

                // Menutup koneksi
                preparedStatementCari.close();
                connection.close();
            } else {
                System.out.println("Data Pelanggan Dengan Nama " + namaPelanggan + " Tidak Ditemukan!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}