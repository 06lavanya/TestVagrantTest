import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


        class Product implements Comparable<Product> {
            private int productId;
            private String productName;
            private int GST;
            private double price;
            private int quantity;

            public Product(int i, String leather_wallet, double v) {
            }

            public Product(int productId, String productName, int
                    GST, double price, int quantity) {
                this.productId = productId;
                this.productName = productName;
                this.GST = GST;
                this.price = price;
                this.quantity = quantity;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public Integer getGST() {
                return GST;
            }

            public void setGST(Integer GST) {
                this.GST = GST;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            @Override
            public int compareTo(Product p) {
                return this.productId - p.productId;
            }

            @Override
            public String toString() {
                return "price=        " + price + ", GST=           "
                        + GST + ", productId=           " + productId
                        + ", productName=              " + productName;
            }

            public Integer GST() {
                return null;
            }

            static class ProductInnerClass implements Comparator<Product> {
                @Override
                public int compare(Product p1, Product p2) {
                    int i = Double.compare(p1.getGST(), p2.getGST());
                    if (i == 0) {
                        return p1.getProductId() - p2.getProductId();
                    }
                    return i;
                }
            }

        }


       public class Main {
            public static void main(String[] args) throws NumberFormatException, IOException {
                ArrayList<Product> productList = new ArrayList<Product>();
                productList.add(new Product(1, "LEATHER WALLET", (int) 1100.0,18,1));
                productList.add(new Product(2, "UMBRELLA", (int) 900.0,12,4));
                productList.add(new Product(3, "CIGARETTE", (int) 200.0,28,3));
                productList.add(new Product(4, "HONEY", (int) 100.0,0,2));
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int i = 1;
                while (i < 3) {
                    System.out.println("1 : Sort by id");
                    System.out.println("2 : Sort by name");
                    System.out.println("3 : Sort by max_GST");
                    int ch = Integer.parseInt(br.readLine());
                    switch (ch) {
                        case 1:
                            Collections.sort(productList);
                            System.out.println("Sorted product : ");
                            for (Product p : productList) {
                                System.out.println(p);
                            }
                            break;
                        case 2:
                            Collections.sort(productList, new Comparator<Product>() {
                                @Override
                                public int compare(Product p1, Product p2) {
                                    int i = p1.getProductName().compareToIgnoreCase
                                            (p2.getProductName());
                                    if (i == 0) {
                                        return p1.getGST().
                                                compareTo(p2.GST());
                                    }
                                    return i;
                                }
                            });
                            System.out.println("Sorted product : ");
                            for (Product p : productList) {
                                System.out.println(p);
                            }
                            break;
                        case 3:
                            Collections.sort(productList, new Product.ProductInnerClass());
                            System.out.println("Sorted product : ");
                            for (Product p : productList) {
                                System.out.println(p);
                            }
                            break;
                        default:
                            System.out.println("Invalid Option");
                            System.exit(0);
                    }
                }
            }
        }








