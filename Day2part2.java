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

        for(int i = 0; i<numList.size()-1; i++) {
            ArrayList<Integer> miniNumList = numList.get(i);
            if(check(miniNumList)) {
                total++;
            }
            else {

                int current = miniNumList.get(i);
                int next = miniNumList.get(i+1);
                if(current-next > 0) {
                    miniNumList.remove(increaseProblem(miniNumList));

                }
                else {
                    miniNumList.remove(decreaseProblem(miniNumList));
                }
            if(check(miniNumList)) {
                total++;
            }
            }
        }

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



public static int boundProblem(ArrayList<Integer> list) {
    for (int i = 0; i < list.size() - 1; i++) {
        int current = list.get(i);
        int next = list.get(i + 1);
        int diff = Math.abs(current - next);
        if (diff > 3 || diff < 1) {
            return i+1;
        }

    }
    return 0;
}

    public static int decreaseProblem(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int start = list.get(i);
            int next = list.get(i + 1);
            if ((start > next) || (Math.abs(start-next) > 3) || (Math.abs(start-next) < 1)) {
                return i+1;
            }

        }
        return 0;

    }


    public static int increaseProblem(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int start = list.get(i);
            int next = list.get(i + 1);
            if ((start < next) || (Math.abs(start-next) > 3) || (Math.abs(start-next) < 1)) {
                return i+1;
            }

        }
        return 0;

    }




    // write a method that checks if a list is ONLY increasing
    public static boolean checkIncreasing(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int start = list.get(i);
            int next = list.get(i + 1);
            if (start > next) {
             return false;
            }

        }
        return true;
    }

    public static boolean checkDecreasing(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int start = list.get(i);
            int next = list.get(i + 1);
            if (start > next) {
                return false;
            }
        }
        return true;
    }



    public static boolean check(ArrayList<Integer> list) {
        boolean first = false;
        boolean second = false;
        boolean third = false;
        first = checkDifferences(list);
        second = checkIncreasing(list);
        third = checkDecreasing(list);
        if(first) {
            if(second || third){
                return true;
            }
        }
        return false;
    }


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
