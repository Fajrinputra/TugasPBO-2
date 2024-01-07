package tbpbotiket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TravelSewa extends Travel {
    Scanner scanner = new Scanner(System.in);

    public void updateDataSewa() {
        String URL = "jdbc:mysql://localhost:3306/tbtravel_pbo";
        String USER = "root";
        String PASSWORD = "";
        System.out.print("Masukkan Nama Pelanggan Yang Ingin Diupdate: ");
        String namaPelanggan = scanner.next();

        try {
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
                Scanner last = new Scanner(System.in);
                // Jika data ditemukan, tampilkan data lama dan minta input data baru
                String NmaPemesan = resultSet.getString("nama_pelanggan");
                int jumlahU = resultSet.getInt("jumlah_unit_sewa");
                String tanggalK = resultSet.getString("tanggal_keberangkatan");
                int durasiS = resultSet.getInt("durasi_sewa");
                int harga = resultSet.getInt("total_harga");
                System.out.println("");
                System.out.println("Nama Pemesan \t\t:" + NmaPemesan);
                System.out.println("Jumlah Unit Yang Disewa :" + jumlahU);
                System.out.println("Tanggal Keberangkatan \t:" + tanggalK);
                System.out.println("Durasi Sewa \t\t:" + durasiS + "Hari");
                System.out.println("Total Harga \t\t:" + harga);
                System.out.println("");

                // Minta input data baru
                System.out.println("Masukkan Data Baru:");

                // Input untuk setiap atribut yang diizinkan diubah
                System.out.print("Masukkan jumlah Unit Sewa Baru: ");
                int jumlahunitbaru = last.nextInt();

                System.out.println("Masukkan Tanggal Keberangkatan Baru: ");
                String tanggalKeberangkatanBaru = last.next();

                System.out.println("Masukan Durasi Sewa Baru: ");
                int durasisewabaru = last.nextInt();

                int totalhargabaru = jumlahunitbaru * durasisewabaru * 500000;

                // Query UPDATE untuk mengubah tanggal_reservasi dan durasi
                String queryUpdate = "UPDATE pelanggantravelsewa SET jumlah_unit_sewa = ?, tanggal_keberangkatan = ?, durasi_sewa = ?, total_harga = ? WHERE nama_pelanggan = ?";
                PreparedStatement preparedStatementUpdate = connection.prepareStatement(queryUpdate);
                preparedStatementUpdate.setInt(1, jumlahunitbaru);
                preparedStatementUpdate.setString(2, tanggalKeberangkatanBaru);
                preparedStatementUpdate.setInt(3, durasisewabaru);
                preparedStatementUpdate.setInt(4, totalhargabaru);
                preparedStatementUpdate.setString(5, namaPelanggan);

                // Eksekusi query update
                preparedStatementUpdate.executeUpdate();

                System.out.println("Data Pelanggan Berhasil Diupdate.");

                // Menutup koneksi
                preparedStatementCari.close();
                preparedStatementUpdate.close();
                connection.close();
            } else {
                System.out.println("Data pelanggan dengan nama " + namaPelanggan + " tidak ditemukan.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
