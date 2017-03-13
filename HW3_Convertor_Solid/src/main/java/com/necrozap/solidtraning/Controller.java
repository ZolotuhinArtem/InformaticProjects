package com.necrozap.solidtraning;

import com.necrozap.solidtraning.converter.Converter;
import com.necrozap.solidtraning.converter.CurrencyConverter;
import com.necrozap.solidtraning.gui.BtnGetOnClickListener;
import com.necrozap.solidtraning.gui.Gui;
import com.necrozap.solidtraning.gui.SwingGui;
import com.necrozap.solidtraning.repositories.CurrencyRepository;
import com.necrozap.solidtraning.repositories.SimpleCurrencyConverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author artem
 */
public class Controller {
    
    private Converter converter;
    private Gui gui;
    
    public static void main(String[] args) {
        Converter converter = new CurrencyConverter(new SimpleCurrencyConverter(), 
                CurrencyRepository.TypeCurrencty.USDtoRUB);
        Gui gui = new SwingGui();
        Controller controller = new Controller(converter, gui);
    }

    private Controller(Converter converter, Gui gui) {
        this.converter = converter;
        this.gui = gui;
        this.gui.addBtnGetOnClickListener(new BtnGetOnClickListener() {
            @Override
            public void onClick() {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String result = converter.convert(gui.getInputText());
                        gui.setInformationText(result);
                    }
                });
                thread.start();
            }
        });
        this.gui.start();
    }
    
}
