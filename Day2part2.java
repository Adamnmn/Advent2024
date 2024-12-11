import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Day2 {
    public static void main(String[] args) {
        int total = 0;
        ArrayList<String> lists = getFileData("src/test.txt");
        ArrayList<ArrayList> numList = new ArrayList<ArrayList>();
        for(String word : lists) {
            String[] tempList = word.split(" ");
            ArrayList<Integer> miniNumList = new ArrayList<Integer>();
            for(int i = 0; i<tempList.length; i++) {
                int num = Integer.parseInt(tempList[i]);
                miniNumList.add(num);
            }
            numList.add(miniNumList);

        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(checkDifferences(list));


//        for(int k = 0; k<numList.size(); k++) {
//            ArrayList<Integer> miniNumList = numList.get(k);
//            String stat;
//            String stat2;
//            boolean stat3 = true;
//            int num1= miniNumList.get(0);
//            int num2 = miniNumList.get(1);
//            int problemIndex = 0;
//            if(num1>num2) {
//                stat = "decrease";
//            }
//            else {
//                stat = "increase";
//            }
//            for(int p = 0; p < miniNumList.size()-1; p++) {
//                int start = miniNumList.get(p);
//                int next = miniNumList.get(p+1);
//                if(miniNumList.get(p) < miniNumList.get(p+1)) {
//                    stat2="increase";
//                }
//                else {
//                    stat2="decrease";
//                }
//
//                if(!(stat2.equals(stat)) || (Math.abs(start - next) > 3 || Math.abs(start - next) < 1)) {
//                    stat3=false;
//                    problemIndex=p+1;
//                }
//
//                System.out.println(stat3 + " " + start + " " + next);
//
//            }
//            if(stat3) {
//                total++;
//            }
//            else {
//                miniNumList.remove(problemIndex);
//                for (int h = 0; h < miniNumList.size() - 1; h++) {
//                    int start = miniNumList.get(h);
//                    int next = miniNumList.get(h + 1);
//                    if (miniNumList.get(h) < miniNumList.get(h + 1)) {
//                        stat2 = "increase";
//                    } else {
//                        stat2 = "decrease";
//                    }
//                    if (!(stat2.equals(stat)) || (Math.abs(start - next) > 3 || Math.abs(start - next) < 1)) {
//                        stat3 = false;
//                    }
//
//                }
//                if (stat3) {
//                    total++;
//                }
//
//            }
//
//        }

        System.out.println(total);


    }

    // write a method that checks if the differences between numbers are good or not
    public static boolean checkDifferences(ArrayList<Integer> list) {
        for (int i = 0; i < list.size()-1; i++) {
            int current = list.get(i);
            int next = list.get(i+1);
            int diff = Math.abs(current-next);
            if (diff > 3 || diff < 1) {
                return false;
            }
        }
        return true;
    }

    // write a method that checks if a list is ONLY increasing
    public static boolean checkIncreasing(ArrayList<Integer> list) {
        String stat;
        String stat2;
        int num1 = list.get(0);
        int num2 = list.get(1);
        if (num1 > num2) {
            stat = "decrease";
        } else {
            stat = "increase";
        }

        for (int i = 0; i < list.size() - 1; i++) {
            int start = list.get(i);
            int next = list.get(i + 1);
            if (!stat2.equals(stat)) {
                return false;


            }
            return true;
        }
    }

        
          
          

    // write a method that checks if a list if ONLY decreasing

    // write a method that checks that the first method returns true and that the second OR third method returns true

    public static boolean findNext(ArrayList<Integer> list, int position) {
        int start = list.get(position);
        int next = list.get(position + 1);
        if (start > next) {
            return false;
        }
        else {
            return true;
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
