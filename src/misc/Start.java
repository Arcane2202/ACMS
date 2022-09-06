/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package misc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author anime
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
                LocalDateTime now = LocalDateTime.now();  
                System.out.println(dtf.format(now)); 
                String date = dtf.toString();
        SplashScreen obj = new SplashScreen();
        obj.setVisible(true);
        try{
            for(int i=0 ; i<=100 ; i++){
                
                Thread.sleep(25);
                
                obj.labelMain.setText(Integer.toString(i)+"%");
                obj.progressbarMain.setValue(i);
                
                if(i==100)
                {
                    obj.dispose();
                    new OptionMenu().setVisible(true);
                }
                
            }
        }catch(Exception e){
            
        }
    }
    
}
