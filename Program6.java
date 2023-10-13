import java.util.*;
import java.io.*;
//code by Sebastian Rodriguez -- program 6 ---Sorting arrays

public class Program6 {
    public static void main(String[] args) throws IOException {
        int[] bubbleArray = new int[20_000];
        int[] sortArray = new int[20_000];
        ArrayList<Integer> myArrayList = new ArrayList<Integer>();

        // Open NumbersInFile.txt, read each line into the two arrays and the ArrayList, then close the file.

        BufferedReader reader = new BufferedReader(new FileReader("NumbersInFile.txt"));
        String line;
        int counter = 0;
        while ((line = reader.readLine()) != null) {
            int currentNum = Integer.parseInt(line); // Convert the line of data into int
            bubbleArray[counter] = currentNum;
            sortArray[counter] = currentNum;
            myArrayList.add(currentNum);
            counter++;
        }

        // Bubble sort

        float time1 = System.nanoTime();

        for (int i = 0; i < bubbleArray.length; i++) {
            for (int j = i + 1; j < bubbleArray.length; j++) {
                if (bubbleArray[i] > bubbleArray[j]) {
                    int temp;
                    temp = bubbleArray[i];
                    bubbleArray[i] = bubbleArray[j];
                    bubbleArray[j] = temp;
                }
            }
            
        }

        float timeFinish1 = System.nanoTime();

        float elapsedTime1 = (timeFinish1 - time1) / 1_000_000_000;

        System.out.println("The time for bubble sort is(INTS): " + elapsedTime1);

        // Selection sort

        float time2 = System.nanoTime();
        for (int i = 0; i < sortArray.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < sortArray.length; j++) {
                if (sortArray[j] < sortArray[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = sortArray[i];
            sortArray[i] = sortArray[minIndex];
            sortArray[minIndex] = temp;
        }

        float timeFinish2 = System.nanoTime();

        float elapsedTime2 = (timeFinish2 - time2) / 1_000_000_000;

        System.out.println("The time for selection sort is (INTS): " + elapsedTime2);




        //PART 2 SYSTEM SORT


        String[] bubbleString = new String[10_000];
        String[] selectionString = new String[10_000];
        ArrayList<String> arrayListString = new ArrayList<String>();

        reader = new BufferedReader(new FileReader("StringsInFIle.txt"));

        counter = 0; 

        while((line = reader.readLine()) != null)
        {
            bubbleString[counter] = line;
            selectionString[counter] = line;
            arrayListString.add(line);

            counter++;
            
        }


        //bubble sort

        float time3 = System.nanoTime();

        for(int i = 0; i < bubbleString.length; i++)
        {
            for(int j = i+1; j< bubbleString.length; j++)
            {
                if((bubbleString[i].compareTo(bubbleString[j])) > 0 )
                {
                    String temp;
                    temp = bubbleString[j];
                    bubbleString[j] = bubbleString[i];
                    bubbleString[i] = temp;

                }
            }
        }

        float timeFinish3 = System.nanoTime();

        System.out.println("The time for bubble sort is(STRINGSS): " + ((timeFinish3 - time3)/ 1_000_000_000));

        //selection sort

        float time4 = System.nanoTime();

        for(int i = 0; i < selectionString.length - 1; i++) {
            int minIndex = i;

            for(int j = i + 1; j < selectionString.length; j++) {
                if(selectionString[j].compareTo(selectionString[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            String temp = selectionString[i];
            selectionString[i] = selectionString[minIndex];
            selectionString[minIndex] = temp;
        }

        float timeFinish4 = System.nanoTime();

        System.out.println("The time for selection sort (STRINGS): " + ((timeFinish4 - time4) / 1_000_000_000));



        //Collection sort
        float time5 = System.nanoTime();
        Collections.sort(arrayListString);
        float timeFinish5 = System.nanoTime();

        System.out.println("The time for Collection sort: " + (timeFinish5 - time5));


        

        //writing results into a new file

        BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"));

        writer.write("The time for bubble sort is(INTS): " + elapsedTime1 + "\n");
        writer.write("The time for selection sort is (INTS): " + elapsedTime2 +  "\n");
        writer.write("The time for bubble sort is(STRINGS): " + ((timeFinish3 - time3)/ 1_000_000_000)+ "\n");
        writer.write("The time for selection sort (STRINGS): " + ((timeFinish4 - time4) / 1_000_000_000)+ "\n");
        writer.write("The time for Collection sort: " + ((timeFinish5 - time5))+"    (Its very fast)" +"\n");

        writer.close();
        reader.close();

        
    }


    



}