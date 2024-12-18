import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Day2 {
    public static void main(String[] args) {
        int total = 0;
        ArrayList<String> lists = getFileData("src/text");
        ArrayList<String> numList = new ArrayList<String>();
        String[] stones = lists.get(0).split(" ");

        for(String word : stones) {
            numList.add(word);
        }



        System.out.println(numList);


    }


    public static void interpretmethod(String word) {
       if()
    }
public static String replaceNumber(String word) {
        if(Integer.parseInt(word) == 0){
            return "1";
        }
        else if(word.length()%2 == 0) {
            String word1 = word.substring(0, word.length()/2);
            String word2 = word.substring(word.length()/2, word.length());
            word2 = String.valueOf(Integer.parseInt(word2));
            return word1 + " " + word2;
        }
        else {
            int num = Integer.parseInt(word);
            num = num*2024;
            return Integer.toString(num);
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
