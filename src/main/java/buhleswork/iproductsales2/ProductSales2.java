/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buhleswork.iproductsales2;

/**
 *
 * @author ignit
 */
public class ProductSales2 implements IProductSales2 {
    

    // Sales limit
    private final int SALES_LIMIT = 500;

    // Product sales data
    private int[][] productSales = {
        {300, 150, 700},
        {250, 200, 600}
    };

    // Return the product sales data
    @Override
    public int[][] GetProductSales() {

        return productSales;
    }

    // Calculate total sales
    @Override
    public int GetTotalSales() {

        int total = 0;

        for (int i = 0; i < productSales.length; i++) {

            for (int j = 0; j < productSales[i].length; j++) {

                total += productSales[i][j];
            }
        }

        return total;
    }

    // Calculate sales over the limit
    @Override
    public int GetSalesOverLimit() {

        int count = 0;

        for (int i = 0; i < productSales.length; i++) {

            for (int j = 0; j < productSales[i].length; j++) {

                if (productSales[i][j] > SALES_LIMIT) {

                    count++;
                }
            }
        }

        return count;
    }

    // Calculate sales under the limit
    @Override
    public int GetSalesUnderLimit() {

        int count = 0;

        for (int i = 0; i < productSales.length; i++) {

            for (int j = 0; j < productSales[i].length; j++) {

                if (productSales[i][j] < SALES_LIMIT) {

                    count++;
                }
            }
        }

        return count;
    }

    // Calculate the number of years processed
    @Override
    public int GetProductsProcessed() {

        return productSales.length;
    }

    // Calculate average sales
    @Override
    public double GetAverageSales() {

        int total = GetTotalSales();

        int count = 0;

        for (int i = 0; i < productSales.length; i++) {

            count += productSales[i].length;
        }

        return (double) total / count;
    }
}
 

