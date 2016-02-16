/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Images;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *
 * @author Alex
 */
public class Threads implements Runnable {
    
    private String url;
    private byte[] bits;
    private int sum =0;

    public Threads(String url) {
        this.url = url;
    }
    
    protected byte[] getBytesFromUrl(String url){
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        try{
            InputStream is = new URL(url).openStream();
            byte[] bytebuff = new byte[4096];
            int read;
            while((read = is.read(bytebuff)) > 0){
                bis.write(bytebuff, 0, read);
            }
        } catch(IOException ex){System.out.println(ex);}
          return bis.toByteArray();  
        
    }

    @Override
    public void run() {
        
        bits = getBytesFromUrl(url);
        
        for (byte bit : bits) {
            sum = sum + bit;
        }
        
    }

    public int getSum() {
        return sum;
    }
    
}
