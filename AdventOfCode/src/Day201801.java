
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;




public class Day201801 {
    
   public Day201801(){
       //Läs in frekvenserna och summera
       
       FileReader file;
       int frequency = 0;
       try {
           file = new FileReader("day1.2018.txt");
           BufferedReader br = new BufferedReader(file);
           String line = br.readLine();
           while(!( line == null)){
               frequency += Integer.parseInt(line);
               line = br.readLine();
           }
           System.out.println("Part 1: Frequency: " + frequency);
           br.close();
           file.close();
           
       } catch (FileNotFoundException ex) {
           System.err.println("File not found..");
       } catch (IOException ex) {
           System.err.println("Something happened..");
       }
            
   }
    
    public static void main(String[] args){
        new Day201801();
    }
    
}
