package serialisasi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationDemo {
    private static final String FILE_NAME = "product.ser";

    public static void main(String[] args) {
        // Membuat objek Product
        List<ProductItem> items = new ArrayList<>();
        items.add(new ProductItem("1", "Item 1", new ArrayList<>(), "Kategori A"));
        items.add(new ProductItem("2", "Item 2", new ArrayList<>(), "Kategori A"));
        Product product = new Product("1", "Product A", items, "Kategori A");

        // Menyimpan Product ke dalam file yang diserialisasi
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(product);
            oos.close();
            fos.close();
            System.out.println("Product berhasil disimpan.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Membaca Product dari file yang diserialisasi
        try {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Product loadedProduct = (Product) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Product berhasil di-load:");
            System.out.println(loadedProduct.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
