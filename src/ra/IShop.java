package ra;

import java.util.Scanner;

public interface IShop {
    void inputData(Scanner scanner);
    void  displayData();
    int compareTo(Product otherProduct);

}
