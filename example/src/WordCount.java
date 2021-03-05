import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore.Entry;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Count {
	//���������������ֱ��������ַ���������������Ч������ʮ����Ƶ��ߵĵ���д���ļ�
	static void countChar(FileInputStream fis) throws IOException 
	{
		int count_char=0;
	}
	void countWord(FileInputStream fis)
	{
		int count_word=0;
	}
	void countLine(FileInputStream fis) 
	{
		int count_line=0;
	}
	void countWordFrequency(FileInputStream fis)
	{
		
	}
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\ling\\Desktop\\�½��ı��ĵ�.txt");
    	//����������ļ��Ķ�ȡ
    	InputStreamReader read = new InputStreamReader(fis);    	
    	//�����ڶ�ȡָ���ļ�   
        BufferedReader in = new BufferedReader(read);  
        String str=null;//����һ���ַ������ͱ���str
        int count_char=0;//����ͳ�����ַ��� 
        int count_line=0;
        String regxSpace = "\\s*";
        Map<String,Integer> map = new HashMap<String,Integer>();
        while ((str = in.readLine())!= null) 
        {//readLine()����, ���ڶ�ȡһ��,ֻҪ��ȡ���ݲ�Ϊ�վ�һֱִ��   	
        	count_char += str.length();  
        	//����Ϊ����ʱ��������һ
        	if(!str.matches(regxSpace))
        		count_line++;
        	//ͳ�Ƶ�������ͳ�Ƶ��ʳ��ִ���
        	String[]ss = str.split("\\s+|\\W");
        	for(String s:ss)
			{
        		if(s.matches("[a-z,A-Z]{4,}.*")) 
        		{
	        		if(map.containsKey(s.toLowerCase()))        			
						map.put(s.toLowerCase(), map.get(s.toLowerCase())+1);
					else
						map.put(s.toLowerCase(), 1);
        		}
			}
        }
        
        List<String> result = new ArrayList<>();
        List<Map.Entry<String,Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer>e1,Map.Entry<String,Integer>e2){
                int re = e2.getValue().compareTo(e1.getValue());
                if(re!=0){return re;}
                else{return e1.getKey().compareTo(e2.getKey());}
            }
        });
        for(int i=0;i<map.size();i++){
            result.add(list.get(i).getKey());
        }
        for(int i=0;i<10;i++){
            System.out.println(list.get(i));
        }          
        System.out.print(count_line);
        System.out.print(count_char);
        fis.close();
	}
	
}

