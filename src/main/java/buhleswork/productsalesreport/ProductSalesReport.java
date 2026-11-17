/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package buhleswork.productsalesreport;

/**
 *
 * @author ignit
 */
public class ProductSalesReport {

    public static void main(String[] args) {
        //Declaration of two dimentional arrays
        int[][] productSales = {{300, 150, 700},{250, 200, 600}};
        
       // Single-dimensional array containing yearly totals
        int[] yearlyTotals = new int[productSales.length];

        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {
                yearlyTotals[i] += productSales[i][j];
            }
        }

        // Create an object of ProductSales
        ProductSales  sales = new ProductSales();

        // Display the sales report
        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("----------------------------");

        System.out.println("Year 1 Total: " + yearlyTotals[0]);
        System.out.println("Year 2 Total: " + yearlyTotals[1]);

        System.out.println("----------------------------");
        System.out.println("Total sales: "
                + sales.TotalSales(productSales));

        System.out.printf("Average sales: %.0f%n",
                sales.AverageSales(productSales));

        System.out.println("Maximum sale: "
                + sales.MaxSale(productSales));

        System.out.println("Minimum sale: "
                + sales.MinSale(productSales));

        System.out.println("----------------------------");
    }
}
        