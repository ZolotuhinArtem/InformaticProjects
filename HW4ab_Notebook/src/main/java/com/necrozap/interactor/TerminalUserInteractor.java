/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necrozap.interactor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author artem
 */
public class TerminalUserInteractor implements UserInteractor{

    private InputStream inputStream;
    private OutputStream outputStream;
    private PrintWriter out;
    private BufferedReader in;
    
    public TerminalUserInteractor(){
        this.inputStream = System.in;
        this.outputStream = System.out;
        this.in = new BufferedReader(new InputStreamReader(inputStream));
        this.out = new PrintWriter(outputStream);
    }
    
    @Override
    public String read() throws UserInteractorReadException {
        String result = "";
        try {
            result = in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(TerminalUserInteractor.class.getName()).log(Level.SEVERE, null, ex);
            throw new UserInteractorReadException();
        } 
        return result;
    }

    @Override
    public void print(String text) throws UserInteractorPrintException {
        out.write(text);
        out.flush();
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
    
    
    
}
