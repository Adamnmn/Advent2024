import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Day3 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/text.txt");
        String bigString="";
        for(String file : fileData) {
            bigString+=file;
        }
        int total=0;

        ArrayList<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("mul\\([0-9]*,[0-9]*\\)").matcher(bigString);
        while (m.find()) {
            allMatches.add(m.group());
        }
        total += getTotal(allMatches);

      System.out.println(total);

    }


    public static int getTotal(ArrayList<String> matches) {
        int total = 0;
        for(String word : matches) {
            Matcher m = Pattern.compile("mul\\([1-9][0-9]{0,2},[1-9][0-9]{0,2}\\)").matcher(word);
            while (m.find()) {
                int num = Integer.parseInt(m.group());
                total+=num;
            }
        }
        return total;
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
