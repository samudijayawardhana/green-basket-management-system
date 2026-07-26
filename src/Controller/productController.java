
package Controller;
import Database. ProductDAO;

import java.util.List;
import modell.Product;

public class productController {
    
    private ProductDAO dao = new ProductDAO();

    public List<Product> lowStock() {
        return dao.lowStockProducts();
    }
}


