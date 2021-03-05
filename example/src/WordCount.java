import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
	static int count_char=0;
	static int count_word=0;
	static int count_line=0;
	static int count_Word_Frequency=10;
	static Map<String,Integer> map = new HashMap<String,Integer>();
	//����ʮ����Ƶ��ߵĵ��ʲ�д���ļ�
	static void countWordFrequency() throws FileNotFoundException
	{
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
        for(int i=0;i<map.size();i++)
            result.add(list.get(i).getKey());
        File file = new File("C:\\Users\\ling\\Desktop\\1.txt");		
		try (PrintWriter output = new PrintWriter(file);) {
			output.println("characters:"+count_char);
			output.println("words:"+count_word);
			output.println("line:"+count_line);
        for(int i=0;i<count_Word_Frequency;i++)
		    output.println(list.get(i).getKey()+":"+list.get(i).getValue());
		}
	}
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\ling\\Desktop\\�½��ı��ĵ�.txt");
    	//����������ļ��Ķ�ȡ
    	InputStreamReader read = new InputStreamReader(fis);    	
    	//�����ڶ�ȡָ���ļ�   
        BufferedReader in = new BufferedReader(read);  
        String str=null;//����һ���ַ������ͱ���str
        String regxSpace = "\\s*";
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
        
        countWordFrequency();      
        
        fis.close();
	}
	
}

