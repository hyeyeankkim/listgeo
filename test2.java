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
                //tab으로 분할하기
                    // use comma as separator
                	for(int i=0; i<col.length;i++){
                
                	 writer.append(col[i] + "\t");
             		
             		if(i==4){ //11번쨰열은 ; 이것도 구분하기 
             			String[] chara1 = col[i].split(";"); 
             			for(int j=0; j<chara1.length;j++){ // 이제 age : 36 이걸 age, 36이렇게 나눠서 배열안에 넣어두기
             				String[] key2522 = chara1[j].split(":");
             				String key = key2522[0];
             				if(!keylist.contains(key))
             					keylist.add(key); //age 부분
             				String value = "";
             				if( key2522.length >= 2 )
             					value = key2522[1]; //36부분
             			}
                     	writer.append("\t"); //;로 구분 후 탭으로 한번 건너뛰기 	
             		}
             	
                	}

                    writer.append("\n"); // 한 행 다 정리했으면 이제 다음행으로 넘어가기 
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
