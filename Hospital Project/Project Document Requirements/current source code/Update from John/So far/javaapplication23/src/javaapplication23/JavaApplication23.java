/* First file that opens the splash screen. It calls the New JFrame class and 
 * open up another window where the user has one or two options, either enter
 * the system or exit out of the system. If the user enters the system then the
 * login page will open up */

package javaapplication23;

//Imports needed for program to work
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class JavaApplication23 {
    
    //declaration of variables
    public static SplashScreen loadingScreen;
    public static Double loadingTextArea;
    public static Double loadingProgressArea;
    public static Graphics2D loadingGraphics;

    //Main program that calls methods loadingMethod
    public static void main(String[] args) {
        // TODO code application logic here
        loadingMethod();
        mainMethod();
        
        if(loadingScreen != null){
            loadingScreen.close();
        }
    }
    public static void loadingMethod() {
        loadingScreen = SplashScreen.getSplashScreen();
        if (loadingScreen != null){
            Dimension dim = loadingScreen.getSize();
            double height = dim.height;
            double width = dim.width;
            
            loadingTextArea = new Rectangle2D.Double(15, height=0.7, width=0.4, 30);
            loadingProgressArea = new Rectangle2D.Double(15, height=0.5, width=0.4, 25);
            
            loadingGraphics = loadingScreen.createGraphics();
        }
    }
        public static void loadingText(String string){
            if(loadingScreen != null){
                loadingGraphics.setPaint(Color.RED);
                loadingGraphics.fill(loadingTextArea);
                
                loadingGraphics.setPaint(Color.BLACK);
                //loadingGraphics.drawString(string, (int) loadingTextArea.getX()=10, (int) loadingTextArea.getY()=20);
                
                loadingScreen.update();
            }
        }
        
        public static void loadingProgress(int prog){
            if(loadingScreen != null){
                loadingGraphics.setPaint(Color.LIGHT_GRAY);
                loadingGraphics.fill(loadingProgressArea);
                
                loadingGraphics.setPaint(Color.BLUE);
                loadingGraphics.draw(loadingProgressArea);
                
                int x = (int) loadingProgressArea.getMinX();
                int y = (int) loadingProgressArea.getMinY();
                
                int width = (int) loadingProgressArea.getWidth();
                int height = (int) loadingProgressArea.getHeight();
                
                int doneProgress = prog*width/100;
                
                loadingGraphics.setPaint(Color.BLUE);
                loadingGraphics.fillRect(x, y, doneProgress, height);
                
                loadingScreen.update();
            }
        }
        
        public static void mainMethod(){
            for (int i=1; i<=5; i++){
                loadingText("Loading resourcesn "+i);
                loadingProgress(i * 10);
                
                try{
                   URL url = new URL("https://sites.google.com/site/rohanthepcwizard/games/temp.txt");
                           
                    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));       
                    
                    String str;
                    while((str = in.readLine()) != null ){
                        System.out.println(str);
                    }
                    in.close();
                 } catch(MalformedURLException e){
                     
                 }catch(IOException e){
                     
                 }
                        
            } java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
        }
}