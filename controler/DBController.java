package controler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import models.classes.Artworks;
import models.classes.Nama;

public class DBController {

    static DatabaseHandler conn = new DatabaseHandler();

    public static void main(String[] args) {
        Login("Reivel", "123");
        Nama nama = new Nama("Reivedl");

    }
    // SELECT AND SEARCH
    public static boolean Login(String email, String pass) {

        Nama nama = new Nama("");
        try {

            conn.connect();
            String query = "SELECT * FROM users WHERE  email = '"+ email +"'";
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {

                do {
                    nama.setNama(rs.getString("email"));
                    System.out.println(rs.getString("email"));
                    if (rs.getString("email").equalsIgnoreCase(email)) {
                        if (rs.getString("password").equalsIgnoreCase(pass)) {
                            return true;
                        }
                    }
                } while (rs.next());

            } else {
                System.out.println("tidak ada");
                return false;

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        conn.disconnect();
        return false;


    }


    public static ArrayList<Artworks> listArtworks(){
        ArrayList <Artworks> list = new ArrayList<>();
        Artworks artworks = new Artworks();
        try {

            conn.connect();
            String query = "SELECT * FROM artwork" ;
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {

                do {
                    System.out.println(rs.getString("title"));
                    artworks.setTitle(rs.getString("title"));
                    artworks.setDesc(rs.getString("decs"));
                    artworks.setImage_path(rs.getString("imagePath"));
                    list.add(artworks);

                } while (rs.next());

                return list;

            } else {
                System.out.println("tidak ada");
                return null;

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        conn.disconnect();


        return null;
    }


    // Insert 
    public static boolean insertNewArt(Artworks artworks) {

        String query = "INSERT INTO artwork (artid, title, desc, imagePath, userId) values (?,?,?,?,?)";
                
        try {

            conn.connect();
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setString(2, artworks.getTitle());
            stmt.setString(3, artworks.getDesc());
            stmt.setString(4, artworks.getImage_path());
            stmt.setInt(5, 0);

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
