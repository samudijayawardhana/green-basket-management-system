package Database;

import modell.Product;
import java.util.List;

import java.sql.*;
import java.util.ArrayList;


public class ProductDAO {

    public void addProduct(Product product) {
        String sql = "INSERT INTO products VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, product.getProductId());
            pst.setString(2, product.getProductName());
            pst.setString(3, product.getCategory());
            pst.setDouble(4, product.getPrice());
            pst.setInt(5, product.getStock());

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection con = DBConnection.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("productid"),
                        rs.getString("productname"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                );
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Product> searchByIdOrName(String keyword) {

        List<Product> list = new ArrayList<>();

        String sql = "SELECT * FROM products WHERE productid LIKE ? OR productname LIKE ?";

        try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, "%" + keyword + "%");
            pst.setString(2, "%" + keyword + "%");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("productid"),
                        rs.getString("productname"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                );
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Product> lowStockProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE stock <= 5";

        try (Connection con = DBConnection.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("productid"),
                        rs.getString("productname"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                        
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
