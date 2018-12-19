
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day201501 {

 
    public static void main(String[] args) {
    
        String elevatorButtons = new String();
        
        try {
            FileReader file = new FileReader("day1.txt");
            BufferedReader br = new BufferedReader(file);
            elevatorButtons = br.readLine();
            System.out.println("File found");
            br.close();
            file.close();
        
        } catch (FileNotFoundException ex) {
            System.err.println("file not found..");
        } catch (IOException ex) {
           System.err.println("Something happened..");
        }
        
        //Läs in filen till en sträng
        
        int floorNumber = 0;
        int basementButtonIndex = 0;
        
        for(int currentButtonNumber = 0; currentButtonNumber < elevatorButtons.length(); currentButtonNumber++){
            // kolla om (
            if(elevatorButtons.charAt(currentButtonNumber) == '(' ){
                floorNumber++;
            }
            if(elevatorButtons.charAt(currentButtonNumber) == ')' ){
                floorNumber--;
            }
            if((floorNumber == -1) && basementButtonIndex == 0){
                basementButtonIndex = currentButtonNumber;
            }
          
            
            // kolla om )
            
            
        }
        basementButtonIndex = basementButtonIndex + 1;
        System.out.println(" Part 1: We are at floor: " + floorNumber);
        System.out.println("Part 2: Basement floor at: " + basementButtonIndex);
       
    }
    
}
