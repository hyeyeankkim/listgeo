package dbmake;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class list {

    public static void main(String[] args) {

        String csvFile = "C:/Users/hyeyeon/Desktop/gsm1.csv";
        BufferedReader br = null;
        String line = " ";
        String temp = null;
        List<String> keylist = new LinkedList<String>();
        try {
       	   FileWriter writer = new FileWriter("C:/Users/hyeyeon/Desktop/list.csv");
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) !=null) {
                // use comma as separator
                if(line.indexOf("GPL570")>=0) {
             
                String[] col= line.split("\t");	
                for(int i=0; i<col.length;i++){               
    	               writer.append(col[i] + "\t");
    	            }
                writer.append("\n");
                }
                if(line.indexOf("GPL572")>=0) {
                    
                    String[] col= line.split("\t");	
                    for(int i=0; i<col.length;i++){               
        	               writer.append(col[i] + "\t");
        	            }
                    writer.append("\n");
                    }
                if(line.indexOf("GPL96")>=0) {
                    
                    String[] col= line.split("\t");	
                    for(int i=0; i<col.length;i++){               
        	               writer.append(col[i] + "\t");
        	            }
                    writer.append("\n");
                    }
                if(line.indexOf("GPL97")>=0) {
                    
                    String[] col= line.split("\t");	
                    for(int i=0; i<col.length;i++){               
        	               writer.append(col[i] + "\t");
        	            }
                    writer.append("\n");
                    }
                
                
                
            }
            writer.append("\n"); // 한 행 다 정리했으면 이제 다음행으로 넘어가기 

            writer.flush();
            writer.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    
}
