package View;

import Model.entities.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SystemGUI extends JFrame implements ActionListener {
    List<Product> products = new ArrayList<>();

    public SystemGUI() {
        this.setTitle("Polimorphysm");
        JPanel bgPanel = new JPanel();
        JPanel registerPanel = new JPanel();
        JPanel productList = new JPanel();

        //Register Panel
        JLabel lblRgProduct = new JLabel("Register Product");
        JLabel lblRgName = new JLabel("Name");
        JLabel lblRgPrice = new JLabel("Price");
        JLabel lblRgType = new JLabel("Type");
        String[] type = {"common", "used", "imported"};
        JComboBox typeList = new JComboBox(type);

        JLabel lblRgCustoms = new JLabel("Customs Fee");
        JLabel lblRgManufacture = new JLabel("Manufacture Date");
        JButton btnClear = new JButton("Clear");
        JButton btnRegisterPr = new JButton("Register Product");
        //inputs:Register panel

        JTextField fieldName = new JTextField();
        JTextField fieldPrice = new JTextField();
        JTextField fieldCustoms = new JTextField();
        JTextField fieldManufacture = new JTextField();
        //Products Panel
        JLabel lblPrStatus = new JLabel("Product #");
        JLabel lblPrList = new JLabel("Products List");
        JLabel lblPrName = new JLabel("Name");
        JLabel lblPrPrice = new JLabel("Price");
        JLabel lblPrType = new JLabel("Type");
        JLabel lblPrCustoms = new JLabel("Customs Fee");
        JLabel lblPrManufacture = new JLabel("Manufacture Date");
        JButton btnNext = new JButton("Next");
        JButton btnPrev = new JButton("Previous");


        //end of panel
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(800, 900));

        bgPanel.setBounds(0, 0, 800, 800);
        bgPanel.setBackground(Color.GRAY);
        //panel

        registerPanel.setBackground(new Color(0x232323));
        productList.setBackground(new Color(0x232323));

        registerPanel.setBounds(0, 0, 800, 440);
        productList.setBounds(0, 444, 800, 456);

        registerPanel.setLayout(null);
        productList.setLayout(null);

        //label:title
        Font title = new Font("segoe ui", Font.PLAIN, 30);
        lblRgProduct.setBounds(291, 20, 220, 40);
        lblRgProduct.setForeground(Color.white);
        lblRgProduct.setFont(title);

        lblPrList.setBounds(316, 464, 169, 40);
        lblPrList.setForeground(Color.white);
        lblPrList.setFont(title);


        //RegisterPanel
        Font rgFont = new Font("segoe ui", Font.PLAIN, 24);

        lblRgName.setForeground(Color.white);
        lblRgPrice.setForeground(Color.white);
        lblRgType.setForeground(Color.white);
        lblRgCustoms.setForeground(Color.white);
        lblRgManufacture.setForeground(Color.white);


        lblRgName.setFont(rgFont);
        lblRgPrice.setFont(rgFont);
        lblRgType.setFont(rgFont);
        lblRgCustoms.setFont(rgFont);
        lblRgManufacture.setFont(rgFont);


        registerPanel.add(lblRgName).setBounds(172, 76, 66, 33);
        registerPanel.add(lblRgPrice).setBounds(185, 137, 53, 33);
        registerPanel.add(lblRgType).setBounds(188, 203, 52, 32);
        registerPanel.add(typeList).setBounds(253, 205, 148, 28);
        registerPanel.add(lblRgCustoms).setBounds(97, 260, 141, 33);
        registerPanel.add(lblRgManufacture).setBounds(47, 320, 194, 32);

        registerPanel.add(fieldName).setBounds(247, 76, 426, 33);
        registerPanel.add(fieldPrice).setBounds(247, 137, 426, 33);
        registerPanel.add(fieldCustoms).setBounds(247, 260, 426, 33);
        registerPanel.add(fieldManufacture).setBounds(247, 319, 426, 33);

        registerPanel.add(btnClear).setBounds(249, 384, 198, 40);
        registerPanel.add(btnRegisterPr).setBounds(475, 384, 198, 40);

        //Products list
        Font prFont = new Font("segoe ui", Font.PLAIN, 18);
        lblPrName.setFont(prFont);
        lblPrPrice.setFont(prFont);
        lblPrType.setFont(prFont);
        lblPrCustoms.setFont(prFont);
        lblPrManufacture.setFont(prFont);
        lblPrStatus.setFont(prFont);

        lblPrName.setForeground(Color.white);
        lblPrPrice.setForeground(Color.white);
        lblPrType.setForeground(Color.white);
        lblPrCustoms.setForeground(Color.white);
        lblPrManufacture.setForeground(Color.white);
        lblPrStatus.setForeground(Color.white);

        productList.add(lblPrList).setBounds(316, 20, 170, 40);
        productList.add(lblPrName).setBounds(201, 75, 50, 24);
        productList.add(lblPrPrice).setBounds(211, 120, 40, 24);
        productList.add(lblPrType).setBounds(212, 165, 38, 24);
        productList.add(lblPrCustoms).setBounds(148, 209, 102, 24);
        productList.add(lblPrManufacture).setBounds(106, 254, 150, 22);
        productList.add(lblPrStatus).setBounds(107, 320, 120, 31);

        productList.add(btnPrev).setBounds(249, 320, 200, 40);
        productList.add(btnNext).setBounds(475, 320, 200, 40);

        productList.add(btnNext);
        productList.add(btnPrev);

        this.add(productList);
        this.add(registerPanel);
        this.add(bgPanel);

        productList.add(lblPrList);
        registerPanel.add(lblRgProduct);

        this.pack();
        this.setLocationRelativeTo(null);


        btnNext.addActionListener(this);
        btnPrev.addActionListener(this);
        btnClear.addActionListener(this);
        btnRegisterPr.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();
        switch (action) {
            case "Clear":
                clearInputs();
                break;
            case "Register Product":
                register();
                break;
            case "Previous":
                productView(1);
                break;
            case "Next":
                productView(2);
                break;

        }

    }

    public void register() {

    }

    public void clearInputs() {

    }



    public void productView(int pos) {

    }





}

