package edu.lcc.citp.inventory;

import edu.lcc.citp.utility.CollectionFileStorageUtility;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Reads and writes Product data from and to inventory storage. This uses a
 * file-based storage utility.
 *
 * @author hoffmanz
 */
public class InventoryManager {

    /**
     * Provides the list of all products in the storage.
     *
     * @return The list of all products.
     * @throws IOException If the file could not be accessed.
     * @throws ClassNotFoundException If the Product class does not match the
     * products in the file.
     */
    public List<Product> getProductList() throws IOException, ClassNotFoundException {

        return new ArrayList<>(CollectionFileStorageUtility.load(Product.class));

    }

    /**
     * Provides a single product by unique UPC.
     *
     * @param upc The UPC of the product to find.
     * @return The found product, or null if there is no product with that UPC.
     * @throws IOException If the file could not be accessed.
     * @throws ClassNotFoundException If the Product class does not match the
     * products in the file.
     */
    public Product getProduct(String upc) throws IOException, ClassNotFoundException {

        Product matchP = null;
        for (Product p : getProductList()) {
            if (p.getUpc().equals(upc)) {
                matchP = p;
            }
        }

        return matchP;

    }

    /**
     * Add a new product to storage.
     *
     * @param p The new product to store.
     * @throws IOException If the file could not be accessed.
     * @throws ClassNotFoundException If the Product class does not match the
     * products in the file.
     */
    public void addProduct(Product p) throws IOException, ClassNotFoundException {

        List<Product> pList = getProductList();

        if (getProduct(p.getUpc()) != null) {
            System.out.println("Product already exists.");
        } else {
            pList.add(p);
            Collections.sort(pList);
            CollectionFileStorageUtility.save(pList, Product.class);
        }

    }

    /**
     * Updates an existing product in the storage. Will only update the non-null
     * fields of the parameter object. In other words, it is not possible to
     * update a field to null.
     *
     * @param p The product to update, matched by UPC.
     * @throws IOException If the file could not be accessed.
     * @throws ClassNotFoundException If the Product class does not match the
     * products in the file.
     */
    public void updateProduct(Product p) throws IOException, ClassNotFoundException {

        List<Product> pList = getProductList();

        Product matchP = null;
        for (Product pElement : pList) {
            if (pElement.getUpc().equals(p.getUpc())) {
                matchP = pElement;
            }
        }

        if (matchP == null) {
            System.out.println("Product not found.");
        } else {
            if (p.getLongDetails() != null) {
                matchP.setLongDetails(p.getLongDetails());
            }
            if (p.getPrice() != null) {
                matchP.setPrice(p.getPrice());
            }
            if (p.getShortDetails() != null) {
                matchP.setShortDetails(p.getShortDetails());
            }
            if (p.getStock() != null) {
                matchP.setStock(p.getStock());
            }

            CollectionFileStorageUtility.save(pList, Product.class);
        }

    }

    /**
     * Removes a product from the storage.
     *
     * @param upc The UPC of the product to remove.
     * @throws IOException If the file could not be accessed.
     * @throws ClassNotFoundException If the Product class does not match the
     * products in the file.
     */
    public void removeProduct(String upc) throws IOException, ClassNotFoundException {

        List<Product> pList = getProductList();

        Product matchP = null;
        for (Product p : pList) {
            if (p.getUpc().equals(upc)) {
                matchP = p;
                break;
            }
        }

        if (matchP == null) {
            System.out.println("Product not found.");
        } else {
            pList.remove(matchP);
            CollectionFileStorageUtility.save(pList, Product.class);
        }

    }
}
