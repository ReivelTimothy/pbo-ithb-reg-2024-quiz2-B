package controler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.jar.Attributes.Name;

import models.classes.Nama;

public class DBController {

    static DatabaseHandler conn = new DatabaseHandler();

    public static void main(String[] args) {
        showNama("Reivel");
        Nama nama = new Nama("rafael");
        Nama nama2 = new Nama("Ruben");
        System.out.println(insertNewUser(nama));
        // System.out.println(updateData(nama2, "Rafael"));

    }
    // SELECT AND SEARCH
    public static Nama showNama(String namaa) {

        Nama nama = new Nama("");
        try {

            conn.connect();
            String query = "SELECT * FROM haha WHERE nama = '"+ namaa +"'";
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {

                do {
                    nama.setNama(rs.getString("nama"));
                    System.out.println(rs.getString("nama"));
                } while (rs.next());

            } else {

                return null;

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        conn.disconnect();
        return nama;


    }


    // Insert 
    public static boolean insertNewUser(Nama nama) {

        String query = "INSERT INTO haha (nama) values (?)";
                
        try {

            conn.connect();
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, nama.getNama());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;

        } finally {

            conn.disconnect();

        }

    }

    // UPDATE
    public static boolean updateData(Nama nama, String namaGanti) {

        String query = "UPDATE haha SET nama=? WHERE nama=?";

        try {

            conn.connect();
            PreparedStatement stmt = conn.con.prepareStatement(query);

            stmt.setString(1, nama.getNama());
            // Where clause
            stmt.setString(2, namaGanti);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;

        } finally {

            conn.disconnect();

        }

    }

    // DELETE
    public static boolean deleteData(String nik) {

        String query = "DELETE FROM haha WHERE nama=?";

        try {

            conn.connect();
            PreparedStatement stmt = conn.con.prepareStatement(query);

            stmt.setString(1, nik);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;

        } finally {

            conn.disconnect();

        }

    }

}
