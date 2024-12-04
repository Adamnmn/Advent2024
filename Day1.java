import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Day1 {
    public static void main(String[] args) {

        ArrayList<String> data = getFileData("src/text");
        ArrayList<Integer> firstNumbers = new ArrayList<Integer>();
        ArrayList<Integer> secondNumbers = new ArrayList<Integer>();
        ArrayList<Integer> orderedFirstNumbers = new ArrayList<Integer>();
        ArrayList<Integer> orderedSecondNumbers = new ArrayList<Integer>();
        int total = 0;
        for(String word : data) {
            String[] tempList = word.split(" {3}");
            String first = tempList[0];
            String second = tempList[1];
            int num1 = Integer.parseInt(first);
            int num2 = Integer.parseInt(second);
            firstNumbers.add(num1);
            secondNumbers.add(num2);
        }
        Collections.sort(firstNumbers);
        Collections.sort(secondNumbers);


        System.out.println(firstNumbers);
        System.out.println(secondNumbers);

        for(int i = 0; i<firstNumbers.size(); i++) {
            int num1 = firstNumbers.get(i);
            int num2 = secondNumbers.get(i);
            int combine = Math.abs(num1-num2);
            total+=combine;
        }

        System.out.println(total);

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
