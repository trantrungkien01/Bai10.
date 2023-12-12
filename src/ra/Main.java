package ra;

import java.util.*;

public class Main {
    public static List<Categories> listCategories = new ArrayList<>();
    public static List<Product> listProduct = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        do {
            System.out.println("*************************SHOP MANAGEMENT***************\n" +
                    "1. Quản lý danh mục sản phẩm\n" +
                    "2. Quản lý sản phẩm\n" +
                    "3. Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    main.displayMenuCategories(scanner, main);
                    break;
                case 2:
                    main.displayMenuProduct(scanner, main);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng chọn 1-3!");
            }
        } while (true);
    }

    public void displayMenuCategories(Scanner scanner, Main main) {
        boolean isExit = true;
        do {
            System.out.println("***************** CATALOG MANAGEMENT**************\n" +
                    "1. Thêm mới danh mục\n" +
                    "2. Hiển thị thông tin các danh mục\n" +
                    "3. Cập nhật tên danh mục theo mã danh mục\n" +
                    "4. Xóa danh mục theo mã danh mục\n" +
                    "5. Thoát\n");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    main.inputCategories(scanner);
                    break;
                case 2:
                    main.displayCategories();
                    break;
                case 3:
                    main.updateCategories(scanner);
                    break;
                case 4:
                    main.deleteCategories(scanner);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng chọn 1-3!");
            }
        } while (isExit);
    }

    public void inputCategories(Scanner scanner) {
        System.out.println("Mời bạn nhập số lượng danh mục: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Categories categories = new Categories();
            categories.inputData(scanner);
            listCategories.add(categories);
        }
    }

    public void displayCategories() {
        System.out.println("- Thông tin danh mục: ");
        for (int i = 0; i < listCategories.size(); i++) {
            Categories categories = new Categories();
            categories.displayData();
            System.out.println("\n----------------------------------");
        }
    }

    public void updateCategories(Scanner scanner) {
        System.out.println("Mời bạn nhập mã danh mục cần cập nhật: ");
        int catalogIdUpdate = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        for (int i = 0; i < listCategories.size(); i++) {
            Categories categories = new Categories();
            if (categories.getCatalogId() == catalogIdUpdate) {
                categories.inputCatalogName(scanner, Main.listCategories);
                System.out.println("Tên danh mục danh mục đã được cập nhật");
                found = true;
                break;
            }
        }
        if (!found) {
            System.err.println("Không tìm thấy mã danh mục, vui lòng nhập lại");
        }
    }

    public void deleteCategories(Scanner scanner) {
        System.out.println("Mời bạn nhập mã danh mục cần xóa: ");
        int cataIdDelete = Integer.parseInt(scanner.nextLine());
        Iterator<Categories> iterator = listCategories.iterator();
        while (iterator.hasNext()) {
            Categories categories = new Categories();
            if (categories.getCatalogId() == cataIdDelete) {
                iterator.remove();
                System.out.println("Thông tin danh mục đã xóa");
            }
        }
        System.err.println("Không tìm thấy mã danh mục, vui lòng nhập lại");
    }

    public void displayMenuProduct(Scanner scanner, Main main) {
        boolean isExit = true;
        do {
            System.out.println("***************** PRODUCT MANAGEMENT**************\n" +
                    "1. Thêm mới sản phẩm\n" +
                    "2. Hiển thị thông tin sản phẩm\n" +
                    "3. Cập nhật giá sản phẩm theo mã sản phẩm\n" +
                    "4. Xóa sản phẩm theo mã sản phẩm\n" +
                    "5. Sắp xếp sản phẩm theo giá sản phẩm tăng dần\n" +
                    "6. Sắp xếp sản phẩm theo tên tăng dần\n" +
                    "7. Thống kê số lượng sản phẩm theo danh mục sản phẩm\n" +
                    "8. Tìm kiếm sản phẩm theo tên sản phẩm\n" +
                    "9. Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    main.inputProduct(scanner);
                    break;
                case 2:
                    main.displayProduct();
                    break;
                case 3:
                    main.updatePriceById(scanner);
                    break;
                case 4:
                    main.deleteProduct(scanner);
                    break;
                case 5:
                    main.sortProductbyPrice();
                    break;
                case 6:
                    main.sortProductByName();
                    break;
                case 7:
                    main.statisticalProduct();
                    break;
                case 8:
                    main.searchProductName(scanner);
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng chọn 1-3!");
            }
        } while (isExit);
    }

    public void inputProduct(Scanner scanner) {
        System.out.println("Nhập số lượng sản phẩm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Product product = new Product();
            product.inputData(scanner);
            listProduct.add(product);
        }
    }

    public void displayProduct() {
        for (int i = 0; i < listProduct.size(); i++) {
            Product product = new Product();
            product.displayData();
            System.out.println("\n-----------------------------------");
        }
    }

    public void updatePriceById(Scanner scanner) {
        System.out.println("Mời bạn nhập mã sản phẩm cần cập nhật: ");
        int productIdUpdate = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        for (int i = 0; i < listProduct.size(); i++) {
            Product product = new Product();
            if (product.getProductId().equals(productIdUpdate)) {
                product.inputPrice(scanner);
                System.out.println("Gía sản phẩm đã được cập nhật");
                found = true;
                break;
            }
        }
        if (!found) {
            System.err.println("Không tìm thấy mã danh mục, vui lòng nhập lại");
        }
    }

    public void deleteProduct(Scanner scanner) {
        System.out.println("Mời bạn nhập mã danh mục cần xóa: ");
        int productIdDelete = Integer.parseInt(scanner.nextLine());
        Iterator<Product> iterator = listProduct.iterator();
        while (iterator.hasNext()) {
            Product product = new Product();
            if (product.getProductId().equals(productIdDelete)) {
                iterator.remove();
                System.out.println("Thông tin danh mục đã xóa");
            }
        }
        System.err.println("Không tìm thấy mã danh mục, vui lòng nhập lại");
    }

    public void sortProductbyPrice() {
        Collections.sort(listProduct, Comparator.comparing(Product::getPrice));
    }

    public void sortProductByName() {
        Collections.sort(listProduct, Comparator.comparing(Product::getProductName));
    }

    public void statisticalProduct(){
        Map<String, Integer> statistical = new HashMap<>();
        for (int i = 0; i < listProduct.size(); i++) {
            Product product = listProduct.get(i);
            String catalogId = String.valueOf(product.getCatalogId()); // Lấy danh mục từ sản phẩm
            statistical.put(catalogId, statistical.getOrDefault(catalogId, 0) + 1);
        }
        // In ra thống kê
        for (String catalogId : statistical.keySet()) {
            System.out.println("Danh mục: " + catalogId + ", Số lượng: " + statistical.get(catalogId));
        }
    }

    public void searchProductName(Scanner scanner) {
        System.out.println("Mời bạn nhập tên sản phẩm: ");
        String searchProductName = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < listProduct.size(); i++) {
            Product product = listProduct.get(i);
            if (product.getProductName().equalsIgnoreCase(searchProductName)) {//Không phân biệt chữ hoa với chữ thường
                System.out.println(product);
            }
        }
        if (!found) {
            System.err.println("Không tìm thấy tên sản phẩm, vui lòng nhập lại!");
        }
    }
}
}
