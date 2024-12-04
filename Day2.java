import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Day1Part2 {
    public static void main(String[] args) {
        ArrayList<String> lists = getFileData("src/text");
        ArrayList<Integer> numList = new ArrayList<Integer>();
        int total = 0;
        for(int i = 0; i<lists.size(); i++) {
            int num = Integer.parseInt(lists.get(i));
            numList.add(num);
        }

        for(int j = 0; j<numList.size(); j++) {
            int start = numList.get(j);
            int next = numList.get(j+1);
            if(!(Math.abs(start-next) > 3 || Math.abs(start-next) < 1 )) {
            
              PUT MORE CODE HERE\\\\\
                
                
            }
        }


    }


    public static int getAnswer(ArrayList<String> fileData) {
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.size(); j++) {
                int number = Integer.parseInt(fileData.get(i));
                int number2 = Integer.parseInt(fileData.get(j));

                if (number + number2 == 2020) {
                    return number * number2;
                }
            }
        }
        return -1;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
