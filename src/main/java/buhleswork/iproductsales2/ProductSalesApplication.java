/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buhleswork.iproductsales2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author ignit
 */
public class ProductSalesApplication extends JFrame{
      //  public static void main(String[] args) {}

       // Create the sales object
    private ProductSales2 sales = new ProductSales2();

    // GUI components
    private JTextArea txtSalesData;
    private JLabel lblYearsProcessed;

    private JButton btnLoad;
    private JButton btnSave;

    // Constructor
    public ProductSalesApplication() {

        setTitle("Product Sales Application");

        setSize(450, 400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        // Create the menu bar
        createMenu();

        // Create the main panel
        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout(10, 10));

        panel.setBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        // Create buttons
        btnLoad = new JButton("Load Product Data");

        btnSave = new JButton("Save Product Data");

        // Create text area
        txtSalesData = new JTextArea(10, 30);

        txtSalesData.setEditable(false);

        // Add scroll bar
        JScrollPane scrollPane = new JScrollPane(txtSalesData);

        // Create label
        lblYearsProcessed = new JLabel("Years Processed: ");

        // Create button panel
        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(2, 1, 5, 5));

        buttonPanel.add(btnLoad);

        buttonPanel.add(btnSave);

        // Add components to main panel
        panel.add(buttonPanel, BorderLayout.NORTH);

        panel.add(scrollPane, BorderLayout.CENTER);

        panel.add(lblYearsProcessed, BorderLayout.SOUTH);

        add(panel);

        // Load button event
        btnLoad.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                loadProductData();
            }
        });

        // Save button event
        btnSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                saveProductData();
            }
        });
    }

    // Create menu system
    private void createMenu() {

        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");

        JMenuItem exitItem = new JMenuItem("Exit");

        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(exitItem);

        // Tools menu
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem loadItem = new JMenuItem("Load Product Data");

        JMenuItem saveItem = new JMenuItem("Save Product Data");

        JMenuItem clearItem = new JMenuItem("Clear");

        loadItem.addActionListener(e -> loadProductData());

        saveItem.addActionListener(e -> saveProductData());

        clearItem.addActionListener(e -> clearData());

        toolsMenu.add(loadItem);

        toolsMenu.add(saveItem);

        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);

        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);
    }

    // Load product data and calculate sales
    private void loadProductData() {

        int total = sales.GetTotalSales();

        double average = sales.GetAverageSales();

        int overLimit = sales.GetSalesOverLimit();

        int underLimit = sales.GetSalesUnderLimit();

        int years = sales.GetProductsProcessed();

        // Display results in text area
        txtSalesData.setText("");

        txtSalesData.append("Total Sales: " + total + "\n");

        txtSalesData.append(
            String.format("Average Sales: %.0f%n", average)
        );

        txtSalesData.append("Sales over limit: " + overLimit + "\n");

        txtSalesData.append("Sales under limit: " + underLimit + "\n");

        // Update years processed label
        lblYearsProcessed.setText("Years Processed: " + years);
    }

    // Save report to data.txt
    private void saveProductData() {

        try {

            PrintWriter writer = new PrintWriter(
                new FileWriter("data.txt")
            );

            writer.println("DATA LOG");

            writer.println("********************************");

            writer.print(txtSalesData.getText());

            writer.println("********************************");

            writer.close();

            JOptionPane.showMessageDialog(
                this,
                "Product data saved successfully to data.txt"
            );

        } catch (IOException e) {

            JOptionPane.showMessageDialog(
                this,
                "Error saving product data: " + e.getMessage()
            );
        }
    }

    // Clear the text area and years label
    private void clearData() {

        txtSalesData.setText("");

        lblYearsProcessed.setText("Years Processed: ");
    }

    // Main method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ProductSalesApplication app =
                new ProductSalesApplication();

            app.setVisible(true);
        });
    }
 
}
