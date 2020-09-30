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
	static void charsetTranslate(File fileFrom, File fileTo, String codecInfoFrom, String codecInfoTo){		
		String[] codecParaIn, codecParaOut;
		String inputChar = "MS950", outputChar = "UTF-8";
		int charLen = 2;
		
		if(codecInfoFrom.equals("") != true && codecInfoTo.equals("") != true) {
			codecParaIn = codecInfoFrom.split(",");
			/*拆解字串成參數*/
			for(int i = 0; i < codecParaIn.length; i++ ) {
				if(i == 0) {
					inputChar = codecParaIn[0];
				}
				else {
					charLen = Integer.parseInt(codecParaIn[1]);
				}
			}
			codecParaOut = codecInfoTo.split(",");
			/*拆解字串成參數*/
			for(int i = 0; i < codecParaOut.length; i++ ) {
				if(i == 0) {
					outputChar = codecParaOut[0];
				}
			}	
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
				/*MS950 2 bit, GBK 2 bit, UTF-8 3 bit, UTF-8 4 bit*/
				charSpace = new char[charLen];
				/*讀到不回傳-1代表還有資料*/
				while((count = isr0.read(charSpace)) != -1){
	                osw0.write(charSpace, 0, count);
	            }
	            
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