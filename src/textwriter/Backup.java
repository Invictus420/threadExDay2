/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class Backup implements Runnable{

    List<String> backUp = new ArrayList();

    public Backup(List<String> backUp) {
        this.backUp=backUp;
    }
    

    
    @Override
    public void run() {
        while(true){
        FileWriter writer = null;
        try {
            writer = new FileWriter("backup.txt", false);
            PrintWriter out = new PrintWriter(writer);
            for (String b : backUp) {
                out.println(b);
            }
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }}
    
}
