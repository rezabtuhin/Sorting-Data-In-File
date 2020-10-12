
package sortfile;

/**
 *
 * @author Rezab
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SortFile {
    public static void main(String[] args) {
        String line2,line3;
        String[] val;
        ArrayList<String> x = new ArrayList<>();
        
        //Reading The CGPA Value from file
        try{
            BufferedReader f = new BufferedReader(new FileReader("students.txt"));
            while ((line2 = f.readLine())!=null){
                val = line2.split(" ");
                String d = val[2];
                x.add(d);

            }

        }catch (Exception e){

        }
        //Reading The CGPA Value from file
        
        //Removing Duplicate Value and Sorting it in Descending Order
        HashSet hs = new HashSet();
        hs.addAll(x);
        x.clear();
        x.addAll(hs);
        Collections.sort(x,Collections.reverseOrder());
        //Removing Duplicate Value and Sorting it in Descending Order
        
        //Importing The sorted value in New Text File
        try{
            FileWriter f = new FileWriter("demo.txt");
            PrintWriter p = new PrintWriter(f);
            p.print(x);
            p.close();
        }catch (Exception E){

        }
        //Importing The sorted value in New Text File

        
        try{
            BufferedReader match = new BufferedReader(new FileReader("demo.txt")); //Reading that new File for the sorted values
            while ((line3 = match.readLine())!=null){
                line3 = line3.replaceAll(",","");  //Making them obstacle free String 
                line3 = line3.replaceAll("]","");  //Making them obstacle free String
                line3 = line3.replace("[","");     //Making them obstacle free String
                String[] g = line3.split(" ");     //Making them obstacle free String
                for(int p = 0;p<g.length;p++){
                    try{
                        BufferedReader m = new BufferedReader(new FileReader("students.txt"));  //Reading the source file
                        String t;
                        while ((t = m.readLine())!=null){
                            if(t.contains(g[p])){                                                   //Comparing & appending 
                                try{                                                                //data into new file
                                    FileWriter f = new FileWriter("Final File.txt",true);
                                    PrintWriter l = new PrintWriter(f);
                                    l.println(t);
                                    l.close();

                                }catch (Exception E){

                                }
                            }
                        }

                    }catch (Exception E){

                    }
                }
            }
        }catch (Exception E){

        }
        System.out.println("File Created..!");
    }
}
