import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

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
        while ((str = in.readLine())!= null) 
        {//readLine()����, ���ڶ�ȡһ��,ֻҪ��ȡ���ݲ�Ϊ�վ�һֱִ��   	
        	count_char += str.length();  
        	if(!str.matches(regxSpace))
        		count_line++;
        }
        System.out.print(count_line);
        System.out.print(count_char);
        fis.close();
	}
}
