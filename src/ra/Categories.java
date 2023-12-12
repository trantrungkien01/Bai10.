package ra;

import com.sun.tools.javac.Main;

import java.util.List;
import java.util.Scanner;

public class Categories {
    private int catalogId;
    private String catalogName;
    private boolean status;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, boolean status) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.status = status;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.status = status;
    }

    @Override
    public void displayData() {
        System.out.printf("Mã danh mục: %s - Tên danh mục: %s - Trạng thái: %s", this.catalogId, this.catalogName, (this.status == true ? "Còn" : "Hết"));
    }

    @Override
    public int compareTo() {
        return 0;
    }

    public int inputCatalogId(List<Categories> listcategories) {
        try {
            if (listcategories.size() == 0) {
                return 1;
            } else {
                int max = listcategories.get(0).getCatalogId();
                for (int i = 0; i < listcategories.size(); i++) {
                    if (listcategories.get(i).getCatalogId() > max) {
                        max = listcategories.get(i).getCatalogId();
                    }
                }
                return max + 1;
            }
        } catch (Exception e) {
            System.err.println("Có lỗi: " + e);
        }
        return 1;
    }

    public String inputCatalogName(Scanner scanner, List<Categories> listCategories) {
        System.out.println("Nhập tên danh mục: ");
        do {
            String catalogName = scanner.nextLine();
            boolean isExit = false;
            for (int i = 0; i < listCategories.size(); i++) {
                if (listCategories.get(0).getCatalogName().equals(catalogName)) {
                    isExit = true; //bị trùng
                    break;
                }
            }
            if (isExit) {
                System.err.println("Tên danh mục đã tồn tại, vui lòng nhập lại");
            } else {
                return catalogName;
            }
        } while (true);
    }

    public boolean inputCatalogStatus(Scanner scanner) {
        System.out.println("Nhập trạng thái danh mục: ");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("Trạng thái danh mục chỉ nhận true/false, vui lòng nhập lại!");
            }
        } while (true);
    }
}

