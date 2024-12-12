import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("Day2Input.txt");
        ArrayList<String[]> grid = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++){
            grid.add(i, fileData.get(i).split(" "));
            System.out.println(Arrays.toString(grid.get(i)));
            boolean increase = isIncreasing(grid.get(i));
            System.out.println(increase);
            boolean decrease = isDecrease(grid.get(i));
            System.out.println(decrease);
            int isSafe = 0;
            if (checkSafe(grid.get(i)) == 0){
                isSafe = isSafe + 1;
            }
        }
    }


    public static boolean isIncreasing(String[] numbers) {
        if (Integer.parseInt(numbers[0]) < Integer.parseInt(numbers[1])){
            return true;
        }
        return false;
    }

    public static boolean isDecrease(String[] numbers) {
        if (Integer.parseInt(numbers[0]) > Integer.parseInt(numbers[1])){
            return true;
        }
        return false;
    }

    public static int checkSafe(String[] numbers) {
        int unsafe = 0;
        if (isIncreasing(numbers)){
            for (int i = 0; i < numbers.length; i++){
                System.out.println(numbers[i]);
                if (i + 1 <= numbers.length - 1) {
                    if ((Integer.parseInt(numbers[i + 1]) - Integer.parseInt(numbers[i]) <= 3) && Integer.parseInt(numbers[i + 1]) - Integer.parseInt(numbers[i]) > 0) {
                        System.out.println("safe" + (Integer.parseInt(numbers[i + 1]) - Integer.parseInt(numbers[i])));
                    }
                    else{
                        unsafe++;
                    }
                }
            }
        }
        if (isDecrease(numbers)){
            for (int i = numbers.length - 1; i != 0; i--){
                System.out.println(numbers[i]);
                if ((Integer.parseInt(numbers[i]) - Integer.parseInt(numbers[i - 1]) <= 3) && Integer.parseInt(numbers[i]) - Integer.parseInt(numbers[i - 1]) > -3) {
                    System.out.println("safe" + (Integer.parseInt(numbers[i]) - Integer.parseInt(numbers[i - 1])));
                }
                else{
                    unsafe++;
                    }
            }

        }
        System.out.println("unsafe: ");
        return unsafe;
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
