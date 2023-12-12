package ra;

import com.sun.tools.javac.Main;

import java.util.List;
import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float price;
    private String title;
    private int catalogId;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, float price, String title, int catalogId, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.catalogId = catalogId;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.productId = inputProductId(scanner, Main.listProduct);
        this.productName = inputProductName(scanner, Main.listProduct);
        this.price = inputPrice(scanner);
        System.out.println("Mời bạn nhập tiêu đề sản phẩm: ");
        this.title = scanner.nextLine();
        this.catalogId = inputCatalogId(scanner, Main.listProduct);
        this.status = inputStatus(scanner);
    }

    public String inputProductId(Scanner scanner, List<Product> listProduct) {
        System.out.println("Nhập mã sản phẩm:");
        do {
            String productId = scanner.nextLine();
            if (listProduct.size() == 4) {
                if (productId.charAt(0) == 'P') {
                    boolean isDuplicate = false;
                    for (int i = 0; i < listProduct.size(); i++) {
                        if (listProduct.get(i).getProductId().equals(productId)) {
                            isDuplicate = true;
                            break;
                        }
                    }
                    if (isDuplicate) {
                        System.err.println("Mã sản phẩm đã tồn tại, vui lòng nhập lại!");
                    } else {
                        return productId;
                    }
                } else {
                    System.err.println("Mã sản phẩm phải bắt đầu là P, vui lòng nhập lại!");
                }
            } else {
                System.err.println("Mã sản phẩm phải có 4 ký tự, vui lòng nhập lại!");
            }
        } while (true);
    }

    public String inputProductName(Scanner scanner, List<Product> listProduct) {
        System.out.println("Mời bạn nhập tên sản phẩm: ");
        do {
            String productName = scanner.nextLine();
            boolean isDuplicate = false;

            for (int i = 0; i < listProduct.size(); i++) {
                if (listProduct.get(i).getProductName().equals(productName)){
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                System.err.println("Tên sản phẩm bị trùng, vui lòng nhập lại!");
            } else {
                return productName;
            }

        } while (true);
    }

    public float inputPrice(Scanner scanner) {
        System.out.println("Mời bạn nhập giá sản phẩm: ");
        do {
            float price = Float.parseFloat(scanner.nextLine());
            if (price > 0) {
                return price;
            } else {
                System.err.println("Gía sản phẩm phải lớn hơn 0, vui lòng nhận lại!");
            }
        } while (true);
    }

    public int inputCatalogId(Scanner scanner, List<Categories> listCategories) {
        System.out.println("Chọn danh mục của sản phẩm: ");
        for (int i = 0; i < listCategories.size(); i++) {
            System.out.printf("%d.%s\n", i + 1, listCategories.get(i).getCatalogName());
        }
        System.out.println("Lựa chọn của bạn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice < 1 || choice > listCategories.size()) {
            System.err.println("Lựa chọn không hợp lệ, vui lòng chọn lại");
        }
        return listCategories.get(choice - 1).getCatalogId();
    }

    public Boolean inputStatus(Scanner scanner) {
        System.out.println("Mời bạn nhập trạng thái sản phẩm: ");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                Boolean.parseBoolean(status);
            } else {
                System.err.println("Trạng thái sản phẩm chị nhận giá trị true/false, vui lòng nhập lại!");
            }
        } while (true);
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sản phẩm: %s - Tên sản phẩm: %s - Gía: %s\n" +
                "Tiêu đề: %s - Mã danh mục: %s - Trạng thái: %s", this.productId, this.productName, this.price, this.title, this.catalogId, (this.status == true ? "Còn bán" : "Ngừng bán"));
    }
    @Override
    public int compareTo(Product otherProduct){
        return Float.compare(this.price, otherProduct.price);
    }
}

