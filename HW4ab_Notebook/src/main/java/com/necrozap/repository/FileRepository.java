/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necrozap.repository;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author artem
 */

/*
*       :)
*       I stole part of code from https://github.com/istamendil/kfu-programming-java2/blob/master/NoteBook/src/info/istamendil/notebook/data/FileDb.java
*/
public class FileRepository implements Repository{

    private File file;

    public FileRepository(File file) {
        this.file = file;
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    @Override
    public void save(Object obj) throws RepositoryException {
        Object[] data = this.load();
        try (FileOutputStream stream = new FileOutputStream(this.file)) {
            Object[] newData = new Object[data.length + 1];
            System.arraycopy(data, 0, newData, 0, data.length);
            newData[newData.length - 1] = obj;
            stream.write(this.convertToBytes(newData));
        }  catch (IOException ex) {
            Logger.getLogger(FileRepository.class.getName()).log(Level.SEVERE, null, ex);
            throw new RepositoryException("DB error: " + ex.getMessage());
        }
    }

    @Override
    public Object[] load() throws RepositoryException {
        try {
            byte[] data;
            data = Files.readAllBytes(this.file.toPath());
            if (data.length > 0) {
                return (Object[]) this.convertFromBytes(data);
            }
            else {
                return new Object[0];
            }
        } catch (IOException | ClassNotFoundException ex) {
            throw new RepositoryException("DB error: " + ex.getMessage());
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    private byte[] convertToBytes(Object object) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(object);
            return bos.toByteArray();
        }
    }

    private Object convertFromBytes(byte[] data) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
                ObjectInput in = new ObjectInputStream(bis)) {
            return in.readObject();
        }
    }

    @Override
    public void clear() throws RepositoryException {
        Object[] data = new Object[0];
        try (FileOutputStream stream = new FileOutputStream(this.file)) {
            stream.write(this.convertToBytes(data));
        }  catch (IOException ex) {
            Logger.getLogger(FileRepository.class.getName()).log(Level.SEVERE, null, ex);
            throw new RepositoryException("DB error: " + ex.getMessage());
        }
    }
    
}
