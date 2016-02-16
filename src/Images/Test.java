/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Images;

/**
 *
 * @author Alex
 */
public class Test {
    
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
        
        Threads t1 = new Threads("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");
        Threads t2 = new Threads("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png");
        Threads t3 = new Threads("https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png");
        
        Thread a1 = new Thread(t1);
        Thread a2 = new Thread(t2);
        Thread a3 = new Thread(t3);
        
        long start = System.nanoTime();
        
        a1.start();
        a2.start();
        a3.start();
        
        a1.join();
        a2.join();
        a3.join();
        
        long end = System.nanoTime();
        System.out.println("Time Sequential: "+(end-start));
        
        System.out.println(t1.getSum() + t2.getSum() + t3.getSum());
        
    }
    
}
