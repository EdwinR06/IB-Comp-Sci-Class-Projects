package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String dir = "/Users/edwinryerson/Documents/GitHub/IB-Comp-Sci-Class-Projects/IB Comp Sci Class Projects/src/FileIO/";

        File myFile = new File(dir + "numbers.csv");
        Scanner scanner = null;
        try {
            scanner = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }

        FileWriter fw = null;
        try {
            fw = new FileWriter(dir + "averages.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<int[]> data = new ArrayList<>();

        while (scanner.hasNext()) {

            String line = scanner.next();

            String[] r = line.split(",");
            int[] row  = new int[r.length];
            double sum = 0;
            int n = 0;
            for(int i = 0; i < r.length; i++) {
                row[i] = Integer.valueOf(r[i]);
                sum += row[i];
                n++;
            }
            data.add(row);
            double average = sum / n;
            try {
                fw.write(Double.toString(average));
                fw.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fw.close();



        // text reading
        String dir1 = "/Users/edwinryerson/Documents/GitHub/IB-Comp-Sci-Class-Projects/IB Comp Sci Class Projects/src/FileIO/text.csv";

        File myFile1 = new File(dir1);
        Scanner scanner1 = null;
        try {
            scanner = new Scanner(myFile1);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }

        ArrayList<String[]> data1 = new ArrayList<>();

        while (scanner.hasNext()) {

            String line = scanner.next();

            String[] r = line.split(",");
            data1.add(r);

            System.out.println(r[0]);
        }




    }
}
