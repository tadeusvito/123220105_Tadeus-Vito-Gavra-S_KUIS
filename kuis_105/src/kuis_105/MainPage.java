/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuis_105;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Lab Informatika
 */
public class MainPage extends JFrame {
    
    private JButton motorButton, mobilButton, saveButton, finishButton;
    private JTextField nameField, phoneField, daysField;
    private JRadioButton[] vehicleOptions;
    private double[] vehiclePrices = {50.0, 100.0, 150.0}; // Harga untuk motor, mobil, dan truk
    private JLabel nameLabelResult, phoneLabelResult, vehicleLabelResult, daysLabelResult, totalLabel;
    private JPanel panel1, panel2, panel3, panel4;
    private double totalCost = 0.0;

    public MainPage() {
        setTitle("Aplikasi Rental Kendaraan");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Frame 1: Pilihan Kendaraan
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5, 1));
        JLabel header = new JLabel("Selamat Datang!");
        JLabel label1 = new JLabel("Silakan pilih jenis kendaraan:");
        motorButton = new JButton("Motor");
        mobilButton = new JButton("Getek");
        panel1.add(label1);
        panel1.add(motorButton);
        panel1.add(mobilButton);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Frame 2/3: Detail Penyewaan
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(10, 2));
        JLabel label2 = new JLabel("Masukkan detail penyewaan:");
        JLabel nameLabel = new JLabel("Nama Penyewa:");
        nameField = new JTextField(10);
        JLabel phoneLabel = new JLabel("Nomor Telepon:");
        phoneField = new JTextField(10);
        JLabel daysLabel = new JLabel("Jumlah Hari:");
        daysField = new JTextField(10);
        panel2.add(label2);
        panel2.add(new JLabel(""));
        panel2.add(nameLabel);
        panel2.add(nameField);
        panel2.add(phoneLabel);
        panel2.add(phoneField);
        panel2.add(daysLabel);
        panel2.add(daysField);
        
        vehicleOptions = new JRadioButton[3];
        ButtonGroup vehicleGroup = new ButtonGroup();
        for (int i = 0; i < 3; i++) {
            vehicleOptions[i] = new JRadioButton();
            vehicleOptions[i].setText("Kendaraan " + (i + 1) + " - Rp " + vehiclePrices[i] + " per hari");
            vehicleOptions[i].setActionCommand(String.valueOf(i));
            vehicleGroup.add(vehicleOptions[i]);
            panel2.add(vehicleOptions[i]);
        }

        saveButton = new JButton("Simpan");
        panel2.add(saveButton);
        
 // Frame 4: Detail dan Total Harga
        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(10, 2));
        JLabel label3 = new JLabel("Detail penyewaan:");
        nameLabelResult = new JLabel();
        phoneLabelResult = new JLabel();
        daysLabelResult = new JLabel();
        vehicleLabelResult = new JLabel();
        totalLabel = new JLabel();
        panel3.add(label3);
        panel3.add(new JLabel(""));
        panel3.add(new JLabel("Nama Penyewa:"));
        panel3.add(nameLabelResult);
        panel3.add(new JLabel("Nomor Telepon:"));
        panel3.add(phoneLabelResult);
        panel3.add(new JLabel("Jumlah Hari:"));
        panel3.add(daysLabelResult);
        panel3.add(new JLabel("Jenis Kendaraan:"));
        panel3.add(vehicleLabelResult);
        panel3.add(new JLabel("Total Harga:"));
        panel3.add(totalLabel);

        // Frame 4: Tombol Selesai
        panel4 = new JPanel();
        finishButton = new JButton("Selesai");
        panel4.add(finishButton);

        motorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(panel1);
                add(panel2);
                revalidate();
                repaint();
            }
        });

        mobilButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(panel1);
                add(panel2);
                revalidate();
                repaint();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    String phone = phoneField.getText();
                    int days = Integer.parseInt(daysField.getText());
                    int selectedOption = Integer.parseInt(vehicleGroup.getSelection().getActionCommand());
                    double price = vehiclePrices[selectedOption];
                    totalCost = price * days;

                    nameLabelResult.setText(name);
                    phoneLabelResult.setText(phone);
                    daysLabelResult.setText(String.valueOf(days));
                    vehicleLabelResult.setText("Kendaraan " + (selectedOption + 1));
                    totalLabel.setText("Rp " + totalCost);

                    remove(panel2);
                    add(panel3);
                    revalidate();
                    repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainPage.this, "Masukkan jumlah hari dengan angka.");
                }
            }
        });

        finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Menutup aplikasi
            }
        });

        add(panel1);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainPage();
            }
        });
    }
    }
