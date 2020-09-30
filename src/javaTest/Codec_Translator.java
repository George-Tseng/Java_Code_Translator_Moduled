package javaTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Codec_Translator {
	
	/*沒有輸出檔案的引數、輸入/輸出編碼的引數*/
	static void charsetTranslate(File fileFrom){		
		String inputChar = "MS950", outputChar = "UTF-8", outputFileRoute = "";
		String [] pathSpace;
		int charLen = 2;
		File fileTo;
		
		/*使用相同路徑，檔名補上編碼*/
		pathSpace = fileFrom.getPath().split(".txt");
		for(int i = 0; i < pathSpace.length; i++) {
			outputFileRoute = outputFileRoute + pathSpace[i];
		}
		outputFileRoute =  outputFileRoute + "_" + outputChar + ".txt";
		fileTo = new File(outputFileRoute);
		
		/*開始執行*/
		try (
				/*建立讀取用物件*/
				InputStreamReader isr0 = new InputStreamReader(new FileInputStream(fileFrom), inputChar);
				/*建立寫入用物件*/
				OutputStreamWriter osw0 = new OutputStreamWriter(new FileOutputStream(fileTo), outputChar);
			){
				int count;
				char [] charSpace;
				/*MS950 2 bit, GBK 2 bit, UTF-8 3 bit*/
				charSpace = new char[charLen];
				/*讀到不回傳-1代表還有資料*/
				while((count = isr0.read(charSpace)) != -1){
	                osw0.write(charSpace, 0, count);
	            }
				System.out.println("轉換工作已完成，檔案路徑為："+fileTo+"\n檔案採用的編碼為："+outputChar);
	            
				/*關閉InputStreamReader物件*/
	            isr0.close();
	            /*關閉OutputStreamWriter物件*/
	            osw0.flush();
	            osw0.close();
			}
			catch(UnsupportedEncodingException excep0) {
				excep0.printStackTrace();
			}
			catch(FileNotFoundException excep1) {
				excep1.printStackTrace();
			}
			catch(IOException excep2) {
				excep2.printStackTrace();
			}
	}
	
	/*沒有輸出檔案的引數、輸出編碼的引數*/
	static void charsetTranslate(File fileFrom,  String codecInfoFrom){		
		String inputChar = "MS950", outputChar = "UTF-8", outputFileRoute = "";
		String [] pathSpace;
		int charLen = 2;
		File fileTo;
		
		/*非預設時*/
		if(codecInfoFrom.equals("") != true) {
			if(codecInfoFrom.equals("MS950") == true || codecInfoFrom.equals("GBK") == true) {
				charLen = 2;
			}
			else if(codecInfoFrom.equals("UTF-8") == true) {
				charLen = 3;
			}
			/*編碼賦值*/
			inputChar = codecInfoFrom;
		}
		
		/*使用相同路徑，檔名補上編碼*/
		pathSpace = fileFrom.getPath().split(".txt");
		for(int i = 0; i < pathSpace.length; i++) {
			outputFileRoute = outputFileRoute + pathSpace[i];
		}
		outputFileRoute =  outputFileRoute + "_" + outputChar + ".txt";
		fileTo = new File(outputFileRoute);
		
		/*開始執行*/
		try (
				/*建立讀取用物件*/
				InputStreamReader isr0 = new InputStreamReader(new FileInputStream(fileFrom), inputChar);
				/*建立寫入用物件*/
				OutputStreamWriter osw0 = new OutputStreamWriter(new FileOutputStream(fileTo), outputChar);
			){
				int count;
				char [] charSpace;
				/*MS950 2 bit, GBK 2 bit, UTF-8 3 bit*/
				charSpace = new char[charLen];
				/*讀到不回傳-1代表還有資料*/
				while((count = isr0.read(charSpace)) != -1){
	                osw0.write(charSpace, 0, count);
	            }
				System.out.println("轉換工作已完成，檔案路徑為："+fileTo+"\n檔案採用的編碼為："+outputChar);
	            
				/*關閉InputStreamReader物件*/
	            isr0.close();
	            /*關閉OutputStreamWriter物件*/
	            osw0.flush();
	            osw0.close();
			}
			catch(UnsupportedEncodingException excep0) {
				excep0.printStackTrace();
			}
			catch(FileNotFoundException excep1) {
				excep1.printStackTrace();
			}
			catch(IOException excep2) {
				excep2.printStackTrace();
			}
	}
	
	/*沒有輸出檔案的引數*/
	static void charsetTranslate(File fileFrom,  String codecInfoFrom, String codecInfoTo){		
		String inputChar = "MS950", outputChar = "UTF-8", outputFileRoute = "";
		String [] pathSpace;
		int charLen = 2;
		File fileTo;
		
		/*非預設時*/
		if(codecInfoFrom.equals("") != true && codecInfoTo.equals("") != true) {
			if(codecInfoFrom.equals("MS950") == true || codecInfoFrom.equals("GBK") == true) {
				charLen = 2;
			}
			else if(codecInfoFrom.equals("UTF-8") == true) {
				charLen = 3;
			}
			/*編碼賦值*/
			inputChar = codecInfoFrom;
			outputChar = codecInfoTo;
		}
		
		/*使用相同路徑，檔名補上編碼*/
		pathSpace = fileFrom.getPath().split(".txt");
		for(int i = 0; i < pathSpace.length; i++) {
			outputFileRoute = outputFileRoute + pathSpace[i];
		}
		outputFileRoute =  outputFileRoute + "_" + codecInfoTo + ".txt";
		fileTo = new File(outputFileRoute);
		
		/*開始執行*/
		try (
				/*建立讀取用物件*/
				InputStreamReader isr0 = new InputStreamReader(new FileInputStream(fileFrom), inputChar);
				/*建立寫入用物件*/
				OutputStreamWriter osw0 = new OutputStreamWriter(new FileOutputStream(fileTo), outputChar);
			){
				int count;
				char [] charSpace;
				/*MS950 2 bit, GBK 2 bit, UTF-8 3 bit*/
				charSpace = new char[charLen];
				/*讀到不回傳-1代表還有資料*/
				while((count = isr0.read(charSpace)) != -1){
	                osw0.write(charSpace, 0, count);
	            }
				System.out.println("轉換工作已完成，檔案路徑為："+fileTo+"\n檔案採用的編碼為："+outputChar);
	            
				/*關閉InputStreamReader物件*/
	            isr0.close();
	            /*關閉OutputStreamWriter物件*/
	            osw0.flush();
	            osw0.close();
			}
			catch(UnsupportedEncodingException excep0) {
				excep0.printStackTrace();
			}
			catch(FileNotFoundException excep1) {
				excep1.printStackTrace();
			}
			catch(IOException excep2) {
				excep2.printStackTrace();
			}
	}
	
	/*給滿引數*/
	static void charsetTranslate(File fileFrom, File fileTo, String codecInfoFrom){		
		String inputChar = "MS950", outputChar = "UTF-8";
		int charLen = 2;
		
		/*非預設時*/
		if(codecInfoFrom.equals("") != true) {
			if(codecInfoFrom.equals("MS950") == true || codecInfoFrom.equals("GBK") == true) {
				charLen = 2;
			}
			else if(codecInfoFrom.equals("UTF-8") == true) {
				charLen = 3;
			}
			/*編碼賦值*/
			inputChar = codecInfoFrom;
		}
		
		/*開始執行*/
		try (
				/*建立讀取用物件*/
				InputStreamReader isr0 = new InputStreamReader(new FileInputStream(fileFrom), inputChar);
				/*建立寫入用物件*/
				OutputStreamWriter osw0 = new OutputStreamWriter(new FileOutputStream(fileTo), outputChar);
			){
				int count;
				char [] charSpace;
				/*MS950 2 bit, GBK 2 bit, UTF-8 3 bit*/
				charSpace = new char[charLen];
				/*讀到不回傳-1代表還有資料*/
				while((count = isr0.read(charSpace)) != -1){
	                osw0.write(charSpace, 0, count);
	            }
				System.out.println("轉換工作已完成，檔案路徑為："+fileTo+"\n檔案採用的編碼為："+outputChar);
				
				/*關閉InputStreamReader物件*/
	            isr0.close();
	            /*關閉OutputStreamWriter物件*/
	            osw0.flush();
	            osw0.close();
			}
			catch(UnsupportedEncodingException excep0) {
				excep0.printStackTrace();
			}
			catch(FileNotFoundException excep1) {
				excep1.printStackTrace();
			}
			catch(IOException excep2) {
				excep2.printStackTrace();
			}
	}
	
	/*給滿引數*/
	static void charsetTranslate(File fileFrom, File fileTo, String codecInfoFrom, String codecInfoTo){		
		String inputChar = "MS950", outputChar = "UTF-8";
		int charLen = 2;
		
		/*非預設時*/
		if(codecInfoFrom.equals("") != true && codecInfoTo.equals("") != true) {
			if(codecInfoFrom.equals("MS950") == true || codecInfoFrom.equals("GBK") == true) {
				charLen = 2;
			}
			else if(codecInfoFrom.equals("UTF-8") == true) {
				charLen = 3;
			}
			/*編碼賦值*/
			inputChar = codecInfoFrom;
			outputChar = codecInfoTo;
		}
		
		/*開始執行*/
		try (
				/*建立讀取用物件*/
				InputStreamReader isr0 = new InputStreamReader(new FileInputStream(fileFrom), inputChar);
				/*建立寫入用物件*/
				OutputStreamWriter osw0 = new OutputStreamWriter(new FileOutputStream(fileTo), outputChar);
			){
				int count;
				char [] charSpace;
				/*MS950 2 bit, GBK 2 bit, UTF-8 3 bit*/
				charSpace = new char[charLen];
				/*讀到不回傳-1代表還有資料*/
				while((count = isr0.read(charSpace)) != -1){
	                osw0.write(charSpace, 0, count);
	            }
				System.out.println("轉換工作已完成，檔案路徑為："+fileTo+"\n檔案採用的編碼為："+outputChar);
				
				/*關閉InputStreamReader物件*/
	            isr0.close();
	            /*關閉OutputStreamWriter物件*/
	            osw0.flush();
	            osw0.close();
			}
			catch(UnsupportedEncodingException excep0) {
				excep0.printStackTrace();
			}
			catch(FileNotFoundException excep1) {
				excep1.printStackTrace();
			}
			catch(IOException excep2) {
				excep2.printStackTrace();
			}
	}
}