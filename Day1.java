import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Day1 {
    public static void main(String[] args) {

        ArrayList<String> data = getFileData("text");
        ArrayList<Integer> firstNumbers = new ArrayList<>();
        ArrayList<Integer> secondNumbers = new ArrayList<>();
        int total = 0;
        
        for(String word : data) {
            String[] tempList = word.split(" {3}");
            String first = tempList[0];
            String second = tempList[1];
            firstNumbers.add(first);
            secondNumbers.add(second);
            int num1 = Integer.parseInt(first);
            int num2 = Integer.parseInt(second);
            int num3 = num1-num2;
            total+=num3;
        }
            
    
    }
      
        
    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File("text");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if(!line.equals(""))
                        fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
    
}

