/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buhleswork.productsalesreport;

/**
 *
 * @author ignit
 */
public class ProductSales  implements IproductSales{
     // Calculate total sales
    @Override
    public int TotalSales(int[][] productSales) {

        int total = 0;

        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {
                total += productSales[i][j];
            }
        }

        return total;
    }

    // Calculate average sales
    @Override
    public double AverageSales(int[][] productSales) {

        int total = TotalSales(productSales);
        int count = 0;

        for (int i = 0; i < productSales.length; i++) {
            count += productSales[i].length;
        }

        return (double) total / count;
    }

    // Calculate maximum sale
    @Override
    public int MaxSale(int[][] productSales) {

        int maximum = productSales[0][0];

        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {

                if (productSales[i][j] > maximum) {
                    maximum = productSales[i][j];
                }
            }
        }

        return maximum;
    }

    // Calculate minimum sale
    @Override
    public int MinSale(int[][] productSales) {

        int minimum = productSales[0][0];

        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {

                if (productSales[i][j] < minimum) {
                    minimum = productSales[i][j];
                }
            }
        }

        return minimum;
    }
}
