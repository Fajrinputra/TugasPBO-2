package tbpbotiket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TravelTransport extends Travel {
    Scanner scanner = new Scanner(System.in);

    public void updateDataTransport() {
        String URL = "jdbc:mysql://localhost:3306/tbtravel_pbo";
        String USER = "root";
        String PASSWORD = "";
        System.out.println("");
        System.out.print("Masukkan Nama Pelanggan Yang Ingin Diupdate: ");
        String namaPelanggan = scanner.next();

        try {
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
                // Jika data ditemukan, tampilkan data lama dan minta input data baru
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
                System.out.println("Jumlah Kursi Dipesan\t:" + jumlahK);
                System.out.println("Nomor Kursi Yang Dipesan:" + noK);
                System.out.println("Jam Keberangkatan\t:" + jamK);
                System.out.println("Total Harga Tiket\t:" + harga);
                System.out.println("");

                // Minta input data baru
                System.out.println("Masukkan Data Baru:");

                // Input untuk setiap atribut yang diizinkan diubah
                System.out.println("Masukkan Tanggal Keberangkatan Baru:");
                String tanggalKeberangkatanBaru = scanner.nextLine();

                System.out.println("Pilih Jam Keberangkatan Baru: ");
                System.out.println("08:00 WIB");
                System.out.println("20:00 WIB");
                System.out.println("Pilihan: ");
                String waktuKeberangkatanBaru = scanner.next();

                // Query UPDATE untuk mengubah tanggal dan jam keberangkatan
                String queryUpdate = "UPDATE pelanggantraveltransport SET tanggal_keberangkatan = ?, jam_keberangkatan = ? WHERE nama_pemesan = ?";
                PreparedStatement preparedStatementUpdate = connection.prepareStatement(queryUpdate);
                preparedStatementUpdate.setString(1, tanggalKeberangkatanBaru);
                preparedStatementUpdate.setString(2, waktuKeberangkatanBaru);
                preparedStatementUpdate.setString(3, namaPelanggan);

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
