package dbmake;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class test2 {
	public static void main(String[] args) {

        String csvFile = "C:/Users/hyeyeon/Desktop/listsql.csv";
        BufferedReader br = null;
        String line = " ";
        String temp = null;
//        Map<Integer,String> id2str = new HashMap<Integer,String>();
//        Map<String,Integer> str2id = new HashMap<String,Integer>();
        
        List<String> keylist = new LinkedList<String>();
        try {
       	   FileWriter writer = new FileWriter("C:/Users/hyeyeon/Desktop/file_new10.csv");
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) !=null) {
                // use comma as separator
                            
                String[] col= line.split("\t");	
                //tab���� �����ϱ�
                    // use comma as separator
                	for(int i=0; i<col.length;i++){
                
                	 writer.append(col[i] + "\t");
             		
             		if(i==4){ //11�������� ; �̰͵� �����ϱ� 
             			String[] chara1 = col[i].split(";"); 
             			for(int j=0; j<chara1.length;j++){ // ���� age : 36 �̰� age, 36�̷��� ������ �迭�ȿ� �־�α�
             				String[] key2522 = chara1[j].split(":");
             				String key = key2522[0];
             				if(!keylist.contains(key))
             					keylist.add(key); //age �κ�
             				String value = "";
             				if( key2522.length >= 2 )
             					value = key2522[1]; //36�κ�
             			}
                     	writer.append("\t"); //;�� ���� �� ������ �ѹ� �ǳʶٱ� 	
             		}
             	
                	}

                    writer.append("\n"); // �� �� �� ���������� ���� ���������� �Ѿ�� 
                }
            
 
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
