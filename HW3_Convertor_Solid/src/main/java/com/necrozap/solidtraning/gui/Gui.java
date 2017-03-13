/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necrozap.solidtraning.gui;

/**
 *
 * @author artem
 */
public interface Gui {
    void addBtnGetOnClickListener(BtnGetOnClickListener listener);
    void setInputText(String text);
    String getInputText();
    void setInformationText(String text);
    String getInforamtionText();
    void start();
}
