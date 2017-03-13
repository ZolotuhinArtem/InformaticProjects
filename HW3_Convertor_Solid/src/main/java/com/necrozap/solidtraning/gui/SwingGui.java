/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necrozap.solidtraning.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author artem
 */
public class SwingGui extends JFrame implements Gui{

    private JButton btnGet;
    private JTextArea inputText;
    private JLabel informationText;
    private JList<String> selectList;

    public SwingGui() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        this.setTitle("Hi :)");
        btnGet = new JButton("GET");
        inputText = new JTextArea();
        selectList = new JList<>();
        informationText = new JLabel();
        panel.add(inputText);
        panel.add(selectList);
        panel.add(btnGet);
        panel.add(informationText);
        setContentPane(panel);
        setBounds(100, 100, 240, 320);
        
    }
    
    
    
    
    @Override
    public void addBtnGetOnClickListener(final BtnGetOnClickListener listener) {
        this.btnGet.addActionListener((ActionEvent e) -> {
            listener.onClick();
        });
    }
    public void setSelectItems(String[] items) {
        this.selectList.setListData(items);
    }
    
    public String getSelectedItem() {
        return this.selectList.getSelectedValue();
    }

    @Override
    public void setInputText(String text) {
        this.inputText.setText(text);
    }

    @Override
    public String getInputText() {
        return this.inputText.getText();
    }

    @Override
    public void setInformationText(String text) {
        this.informationText.setText(text);
    }

    @Override
    public String getInforamtionText() {
        return this.informationText.getText();
    }

    @Override
    public void start() {
        this.setVisible(true);
    }
    
}
