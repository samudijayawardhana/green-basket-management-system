package Controller;

import Database.ProductDAO;

import java.util.List;
import modell.Product;

public class SalesAssistantController {

    private ProductDAO dao = new ProductDAO();

    public void addProduct(int id, String name, String category, double price, int stock) {
        Product product = new Product(id, name, category, price, stock);
        dao.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return dao.getAllProducts();
    }

   
public List<Product> searchByIdOrName(String keyword) {
    return dao.searchByIdOrName(keyword);
}
}