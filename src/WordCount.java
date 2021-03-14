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
	static int count_char=0;//�ַ���
	static int count_word=0;//������
	static int count_line=0;//��Ч����
	static int count_Word_Frequency=10;//�����Ƶ��ߵĵ�����
	static Map<String,Integer> map = new HashMap<String,Integer>();//��¼���ʳ��ֵĴ���
	static String input;
	static String output;
	//����ʮ����Ƶ��ߵĵ��ʲ�д���ļ�
	static void countWordFrequency() throws FileNotFoundException
	{
		List<String> result = new ArrayList<>();
        List<Map.Entry<String,Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>()
        {	//������value���бȽ�
        	public int compare(Map.Entry<String,Integer>e1,Map.Entry<String,Integer>e2)
        	{
                int re = e2.getValue().compareTo(e1.getValue());
                if(re!=0)
                	return re;
                else
                	return e1.getKey().compareTo(e2.getKey());
            }
        });
        //���ȽϺ�Ľṹ����result��
        for(int i=0;i<map.size();i++)
            result.add(list.get(i).getKey());
        //��������������������ļ���
        File file = new File(output);		
		try (PrintWriter output = new PrintWriter(file);) {
			output.println("characters:"+count_char);
			output.println("words:"+map.size());
			output.println("line:"+count_line);
			for(int i=0;i<count_Word_Frequency;i++)
				output.println(list.get(i).getKey()+":"+list.get(i).getValue());
		}
	}
	public static void main(String[] args) throws Exception {
		//�û�����Ҫ��ȡ��������ļ�·��
		Scanner doc = new Scanner(System.in);	
		input = doc.nextLine();
		output = doc.nextLine();	
		File file = new File(output);		
		if(!file.exists())  
	    {  
	        try {  
	            file.createNewFile();  
	        } catch (IOException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	    } 
		FileInputStream fis = new FileInputStream(input);
    	//����������ļ��Ķ�ȡ
    	InputStreamReader read = new InputStreamReader(fis);    	
    	//�����ڶ�ȡָ���ļ�   
        BufferedReader in = new BufferedReader(read);  
        String str=null;//����һ���ַ������ͱ���str
        String regxSpace = "\\s*";//�����ʾ�ո񡢿��е�
        //readLine()����, ���ڶ�ȡһ��,ֻҪ��ȡ���ݲ�Ϊ�վ�һֱִ��   
        while ((str = in.readLine())!= null) 
        {	
        	//ÿ���ַ������
        	count_char += str.length();  
        	//����Ϊ����ʱ��������һ
        	if(!str.matches(regxSpace))
        		count_line++;
        	//ͳ�Ƶ�������ͳ�Ƶ��ʳ��ִ���
        	String[]ss = str.split("\\s+|\\W");//��ʾ�ո񡢿��л��߷�������ĸ��������зָ�
        	for(String s:ss)
			{
        		if(s.matches("[a-z,A-Z]{4,}.*")) //�жϷָ����ַ����Ƿ����ĸ���ĸ��ͷ�ĵ���
        		{//mapͳ����Щ����
	        		if(map.containsKey(s.toLowerCase()))  //toLowerCase���Ӵ�Сд      			
						map.put(s.toLowerCase(), map.get(s.toLowerCase())+1);
					else
						map.put(s.toLowerCase(), 1);
        		}
			}
        }      
        countWordFrequency();      
        //�ر�fis
        fis.close();
	}
	
}

