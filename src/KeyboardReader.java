// Program that reads user input and prints it

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class KeyboardReader {
     public static void main(String[] arg) throws IOException {
         // BR take an input stream reader parameter
         // ISR takes an input stream parameter
         BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
         System.out.println(keyboard.readLine());

         URL u = new URL("https://www.whitehouse.gov/");
         InputStream ins = u.openStream();
         InputStreamReader isr = new InputStreamReader(ins);
         BufferedReader whiteHouse = new BufferedReader(isr);
         System.out.println(whiteHouse.readLine());
     }
}
