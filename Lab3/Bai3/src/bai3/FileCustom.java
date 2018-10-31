/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.io.*;

/**
 *
 * @author duong
 */
public class FileCustom {
    public void readFile(String filename){
        File file = new File(filename);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            int content;
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                    ex.printStackTrace();
            }
        }
    }
    
    public void writeFile(String content, String filename){
        FileOutputStream fop = null;
        File file;
        try {
            file = new File(filename);
            fop = new FileOutputStream(file);

            // create file if not exists
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                        fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
