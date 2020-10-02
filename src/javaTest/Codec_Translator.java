package javaTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Codec_Translator {
	/*時間格式*/
	static SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS");
	/*實例*/
	static CodecMode codec = CodecMode.getInstance();
	static CodecLen codecLen = CodecLen.getInstance();
	static AppString appString = AppString.getInstance();
	
	/*僅接受"輸入檔案"引數*/
	static void charsetTranslate(File fileFrom){		
		String inputChar = codec.getCodec("1"), outputChar = codec.getCodec("3"), outputFileRoute = "";
		String [] pathSpace;
		int charLen = codecLen.getCodecLen("1");
		File fileTo, fileToTmp;
		
		/*使用相同路徑，檔名補上編碼*/
		pathSpace = fileFrom.getPath().split(".txt");
		for(int i = 0; i < pathSpace.length; i++) {
			outputFileRoute = outputFileRoute + pathSpace[i];
		}
		outputFileRoute =  outputFileRoute + "_" + outputChar;
		fileToTmp = new File(outputFileRoute + ".txt");
		
		/*判讀檔案是否存在，存在則在檔名後補上time stamp*/
		if(fileToTmp.exists() == true) {
			Date timeCurrent = new Date();
			outputFileRoute =  outputFileRoute + "_" + sdf0.format(timeCurrent) + ".txt";
			fileTo = new File(outputFileRoute);
		}
		else {
			fileTo = fileToTmp;
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
				System.out.println(appString.getAppString(1000) + fileTo + 
						appString.getAppString(1001) + outputChar);
	            
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
	
	/*僅接受"輸入檔案"與"是否可直接覆蓋檔案"引數*/
	static void charsetTranslate(File fileFrom, boolean directCovered){		
		String inputChar = codec.getCodec("1"), outputChar = codec.getCodec("3"), outputFileRoute = "";
		String [] pathSpace;
		int charLen = codecLen.getCodecLen("1");
		File fileTo, fileToTmp;
		
		/*使用相同路徑，檔名補上編碼*/
		pathSpace = fileFrom.getPath().split(".txt");
		for(int i = 0; i < pathSpace.length; i++) {
			outputFileRoute = outputFileRoute + pathSpace[i];
		}
		outputFileRoute =  outputFileRoute + "_" + outputChar;
		fileToTmp = new File(outputFileRoute + ".txt");
		
		/*判讀檔案是否存在，如果存在且不允許覆蓋檔案，則在檔名後補上time stamp*/
		if(fileToTmp.exists() == true && directCovered == false) {
			Date timeCurrent = new Date();
			outputFileRoute =  outputFileRoute + "_" + sdf0.format(timeCurrent) + ".txt";
			fileTo = new File(outputFileRoute);
		}
		else {
			fileTo = fileToTmp;
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
				System.out.println(appString.getAppString(1000) + fileTo + 
						appString.getAppString(1001) + outputChar);
	            
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
	
	/*僅接受"輸入檔案"與"轉換模式"引數*/
	static void charsetTranslate(File fileFrom, double transMode){		
		String inputChar, outputChar, outputFileRoute = "";
		String [] pathSpace;
		int charLen, transParas;
		File fileTo, fileToTmp;
		transParas = (int)Math.round(transMode);
		
		/*1.MS950->UTF-8 2.GBK->UTF-8 3.UTF-8->MS950 4.UTF-8->GBK 5.MS950->GBK 6.GBK->MS950*/
		switch(transParas) {
			case 4:
			case 3:
				inputChar = codec.getCodec("3");
				charLen = codecLen.getCodecLen("3");
				break;
			case 6:
			case 2:
				inputChar = codec.getCodec("2");
				charLen = codecLen.getCodecLen("2");
				break;
			case 5:
			case 1:
			default:
				inputChar = codec.getCodec("1");
				charLen = codecLen.getCodecLen("1");
				break;
		}
		switch(transParas) {
			case 5:
			case 4:
				outputChar = codec.getCodec("2");
				break;
			case 6:
			case 3:
				outputChar = codec.getCodec("1");
				break;
			case 2:
			case 1:
			default:
				outputChar = codec.getCodec("3");
				break;
		}
		
		/*使用相同路徑，檔名補上編碼*/
		pathSpace = fileFrom.getPath().split(".txt");
		for(int i = 0; i < pathSpace.length; i++) {
			outputFileRoute = outputFileRoute + pathSpace[i];
		}
		outputFileRoute =  outputFileRoute + "_" + outputChar;
		fileToTmp = new File(outputFileRoute + ".txt");
		
		/*判讀檔案是否存在，存在則在檔名後補上time stamp*/
		if(fileToTmp.exists() == true) {
			Date timeCurrent = new Date();
			outputFileRoute =  outputFileRoute + "_" + sdf0.format(timeCurrent) + ".txt";
			fileTo = new File(outputFileRoute);
		}
		else {
			fileTo = fileToTmp;
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
				System.out.println(appString.getAppString(1000) + fileTo + 
						appString.getAppString(1001) + outputChar);
	            
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
	
	/*僅接受"輸入檔案"、"轉換模式"與"是否可直接覆蓋檔案"引數*/
	static void charsetTranslate(File fileFrom, double transMode, boolean directCovered){		
		String inputChar, outputChar, outputFileRoute = "";
		String [] pathSpace;
		int charLen, transParas;
		File fileTo, fileToTmp;
		transParas = (int)Math.round(transMode);
		
		/*1.MS950->UTF-8 2.GBK->UTF-8 3.UTF-8->MS950 4.UTF-8->GBK 5.MS950->GBK 6.GBK->MS950*/
		switch(transParas) {
			case 4:
			case 3:
				inputChar = codec.getCodec("3");
				charLen = codecLen.getCodecLen("3");
				break;
			case 6:
			case 2:
				inputChar = codec.getCodec("2");
				charLen = codecLen.getCodecLen("2");
				break;
			case 5:
			case 1:
			default:
				inputChar = codec.getCodec("1");
				charLen = codecLen.getCodecLen("1");
				break;
		}
		switch(transParas) {
			case 5:
			case 4:
				outputChar = codec.getCodec("2");
				break;
			case 6:
			case 3:
				outputChar = codec.getCodec("1");
				break;
			case 2:
			case 1:
			default:
				outputChar = codec.getCodec("3");
				break;
		}
		
		/*使用相同路徑，檔名補上編碼*/
		pathSpace = fileFrom.getPath().split(".txt");
		for(int i = 0; i < pathSpace.length; i++) {
			outputFileRoute = outputFileRoute + pathSpace[i];
		}
		outputFileRoute =  outputFileRoute + "_" + outputChar;
		fileToTmp = new File(outputFileRoute + ".txt");
		
		/*判讀檔案是否存在，如果存在且不允許覆蓋檔案，則在檔名後補上time stamp*/
		if(fileToTmp.exists() == true && directCovered == false) {
			Date timeCurrent = new Date();
			outputFileRoute =  outputFileRoute + "_" + sdf0.format(timeCurrent) + ".txt";
			fileTo = new File(outputFileRoute);
		}
		else {
			fileTo = fileToTmp;
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
				System.out.println(appString.getAppString(1000) + fileTo + 
						appString.getAppString(1001) + outputChar);
	            
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
	
	/*僅接受"輸入檔案"與"輸出格式"引數*/
	static void charsetTranslate(File fileFrom,  String codecInfoTo){		
		String inputChar = codec.getCodec("1"), outputChar = codecInfoTo, outputFileRoute = "";
		String [] pathSpace;
		int charLen = codecLen.getCodecLen("1");
		File fileTo, fileToTmp;
		
		/*使用相同路徑，檔名補上編碼*/
		pathSpace = fileFrom.getPath().split(".txt");
		for(int i = 0; i < pathSpace.length; i++) {
			outputFileRoute = outputFileRoute + pathSpace[i];
		}
		outputFileRoute =  outputFileRoute + "_" + outputChar;
		fileToTmp = new File(outputFileRoute + ".txt");
		
		/*判讀檔案是否存在，存在則在檔名後補上time stamp*/
		if(fileToTmp.exists() == true) {
			Date timeCurrent = new Date();
			outputFileRoute =  outputFileRoute + "_" + sdf0.format(timeCurrent) + ".txt";
			fileTo = new File(outputFileRoute);
		}
		else {
			fileTo = fileToTmp;
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
				System.out.println(appString.getAppString(1000) + fileTo + 
						appString.getAppString(1001) + outputChar);
	            
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
	
	/*僅接受"輸入檔案"、"輸出格式"與"是否可直接覆蓋檔案"引數*/
	static void charsetTranslate(File fileFrom,  String codecInfoTo, boolean directCovered){		
		String inputChar = codec.getCodec("1"), outputChar = codecInfoTo, outputFileRoute = "";
		String [] pathSpace;
		int charLen = codecLen.getCodecLen("1");
		File fileTo, fileToTmp;
		
		/*使用相同路徑，檔名補上編碼*/
		pathSpace = fileFrom.getPath().split(".txt");
		for(int i = 0; i < pathSpace.length; i++) {
			outputFileRoute = outputFileRoute + pathSpace[i];
		}
		outputFileRoute =  outputFileRoute + "_" + outputChar;
		fileToTmp = new File(outputFileRoute + ".txt");
		
		/*判讀檔案是否存在，如果存在且不允許覆蓋檔案，則在檔名後補上time stamp*/
		if(fileToTmp.exists() == true && directCovered == false) {
			Date timeCurrent = new Date();
			outputFileRoute =  outputFileRoute + "_" + sdf0.format(timeCurrent) + ".txt";
			fileTo = new File(outputFileRoute);
		}
		else {
			fileTo = fileToTmp;
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
				System.out.println(appString.getAppString(1000) + fileTo + 
						appString.getAppString(1001) + outputChar);
	            
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
	
	/*僅接受"輸入檔案"、"輸出格式"與"輸出格式"引數*/
	static void charsetTranslate(File fileFrom,  String codecInfoFrom, String codecInfoTo){		
		String inputChar = codecInfoFrom, outputChar = codecInfoTo, outputFileRoute = "";
		String [] pathSpace;
		int charLen = codecLen.getCodecLen("1");
		File fileTo, fileToTmp;
		
		/*非預設時*/
		if(codecInfoFrom.equals("") != true && codecInfoTo.equals("") != true) {
			if(codecInfoFrom.equals(codec.getCodec("1")) == true) {
				charLen = codecLen.getCodecLen("1");
			}
			else if(codecInfoFrom.equals(codec.getCodec("2")) == true) {
				charLen = codecLen.getCodecLen("2");
			}
			else if(codecInfoFrom.equals(codec.getCodec("3")) == true) {
				charLen = codecLen.getCodecLen("3");
			}
		}
		
		/*使用相同路徑，檔名補上編碼*/
		pathSpace = fileFrom.getPath().split(".txt");
		for(int i = 0; i < pathSpace.length; i++) {
			outputFileRoute = outputFileRoute + pathSpace[i];
		}
		outputFileRoute =  outputFileRoute + "_" + codecInfoTo;
		fileToTmp = new File(outputFileRoute + ".txt");
		
		/*判讀檔案是否存在，存在則在檔名後補上time stamp*/
		if(fileToTmp.exists() == true) {
			Date timeCurrent = new Date();
			outputFileRoute =  outputFileRoute + "_" + sdf0.format(timeCurrent) + ".txt";
			fileTo = new File(outputFileRoute);
		}
		else {
			fileTo = fileToTmp;
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
				System.out.println(appString.getAppString(1000) + fileTo + 
						appString.getAppString(1001) + outputChar);
	            
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
	
	/*僅接受"輸入檔案"、"輸出格式"、"輸出格式"與"是否可直接覆蓋檔案"引數*/
	static void charsetTranslate(File fileFrom,  String codecInfoFrom, String codecInfoTo, 
			boolean directCovered){		
		String inputChar = codecInfoFrom, outputChar = codecInfoTo, outputFileRoute = "";
		String [] pathSpace;
		int charLen = codecLen.getCodecLen("1");
		File fileTo, fileToTmp;
		
		/*非預設時*/
		if(codecInfoFrom.equals("") != true && codecInfoTo.equals("") != true) {
			if(codecInfoFrom.equals(codec.getCodec("1")) == true) {
				charLen = codecLen.getCodecLen("1");
			}
			else if(codecInfoFrom.equals(codec.getCodec("2")) == true) {
				charLen = codecLen.getCodecLen("2");
			}
			else if(codecInfoFrom.equals(codec.getCodec("3")) == true) {
				charLen = codecLen.getCodecLen("3");
			}
		}
		
		/*使用相同路徑，檔名補上編碼*/
		pathSpace = fileFrom.getPath().split(".txt");
		for(int i = 0; i < pathSpace.length; i++) {
			outputFileRoute = outputFileRoute + pathSpace[i];
		}
		outputFileRoute =  outputFileRoute + "_" + codecInfoTo;
		fileToTmp = new File(outputFileRoute + ".txt");
		
		/*判讀檔案是否存在，如果存在且不允許覆蓋檔案，則在檔名後補上time stamp*/
		if(fileToTmp.exists() == true && directCovered == false) {
			Date timeCurrent = new Date();
			outputFileRoute =  outputFileRoute + "_" + sdf0.format(timeCurrent) + ".txt";
			fileTo = new File(outputFileRoute);
		}
		else {
			fileTo = fileToTmp;
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
				System.out.println(appString.getAppString(1000) + fileTo + 
						appString.getAppString(1001) + outputChar);
	            
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
	
	/*僅接受"輸入檔案"與"輸出檔案"引數*/
	static void charsetTranslate(File fileFrom, File fileTo){		
		String inputChar = codec.getCodec("1"), outputChar = codec.getCodec("3"), 
				outputFileRoute = "";
		int charLen = codecLen.getCodecLen("1");
		File fileToTmp;
		
		/*判讀檔案是否存在，存在則先在檔名後補上編碼格式*/
		if(fileTo.exists() == true) {
			String [] pathSpace;
			pathSpace = fileFrom.getPath().split(".txt");
			for(int i = 0; i < pathSpace.length; i++) {
				outputFileRoute = outputFileRoute + pathSpace[i];
			}
			outputFileRoute =  outputFileRoute + "_" + outputChar;
			fileToTmp = new File(outputFileRoute + ".txt");
			
			/*判讀新修改的檔案是否存在，如果存在且不允許覆蓋檔案，則在檔名後補上time stamp*/
			if(fileToTmp.exists() == true) {
				Date timeCurrent = new Date();
				outputFileRoute =  outputFileRoute + "_" + sdf0.format(timeCurrent) + ".txt";
				fileTo = new File(outputFileRoute);
			}
			else {
				fileTo = fileToTmp;
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
				/*MS950 2 bit, GBK 2 bit, UTF-8 3 bit*/
				charSpace = new char[charLen];
				/*讀到不回傳-1代表還有資料*/
				while((count = isr0.read(charSpace)) != -1){
	                osw0.write(charSpace, 0, count);
	            }
				System.out.println(appString.getAppString(1000) + fileTo + 
						appString.getAppString(1001) + outputChar);
	            
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
	
	/*僅接受"輸入檔案"、"輸出檔案"與"是否可直接覆蓋檔案"引數*/
	static void charsetTranslate(File fileFrom, File fileTo, boolean displayCovered){		
		String inputChar = codec.getCodec("1"), outputChar = codec.getCodec("3"), 
				outputFileRoute = "";
		int charLen = codecLen.getCodecLen("1");
		File fileToTmp;
		
		/*判讀檔案是否存在，如果存在且不允許覆蓋檔案，則先在檔名後補上編碼格式*/
		if(fileTo.exists() == true && displayCovered == false) {
			String [] pathSpace;
			pathSpace = fileFrom.getPath().split(".txt");
			for(int i = 0; i < pathSpace.length; i++) {
				outputFileRoute = outputFileRoute + pathSpace[i];
			}
			outputFileRoute =  outputFileRoute + "_" + outputChar;
			fileToTmp = new File(outputFileRoute + ".txt");
			
			/*判讀新修改的檔案是否存在，如果存在且不允許覆蓋檔案，則在檔名後補上time stamp*/
			if(fileToTmp.exists() == true) {
				Date timeCurrent = new Date();
				outputFileRoute =  outputFileRoute + "_" + sdf0.format(timeCurrent) + ".txt";
				fileTo = new File(outputFileRoute);
			}
			else {
				fileTo = fileToTmp;
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
				/*MS950 2 bit, GBK 2 bit, UTF-8 3 bit*/
				charSpace = new char[charLen];
				/*讀到不回傳-1代表還有資料*/
				while((count = isr0.read(charSpace)) != -1){
	                osw0.write(charSpace, 0, count);
	            }
				System.out.println(appString.getAppString(1000) + fileTo + 
						appString.getAppString(1001) + outputChar);
	            
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
	
	/*僅接受"輸入檔案"、"輸出檔案"與"轉換模式"引數*/
	static void charsetTranslate(File fileFrom, File fileTo, double transMode){		
		String inputChar, outputChar, outputFileRoute = "";
		int charLen, transParas;
		File fileToTmp;
		
		transParas = (int)Math.round(transMode);
		
		/*1.MS950->UTF-8 2.GBK->UTF-8 3.UTF-8->MS950 4.UTF-8->GBK 5.MS950->GBK 6.GBK->MS950*/
		switch(transParas) {
			case 4:
			case 3:
				inputChar = codec.getCodec("3");
				charLen = codecLen.getCodecLen("3");
				break;
			case 6:
			case 2:
				inputChar = codec.getCodec("2");
				charLen = codecLen.getCodecLen("2");
				break;
			case 5:
			case 1:
			default:
				inputChar = codec.getCodec("1");
				charLen = codecLen.getCodecLen("1");
				break;
		}
		switch(transParas) {
			case 5:
			case 4:
				outputChar = codec.getCodec("2");
				break;
			case 6:
			case 3:
				outputChar = codec.getCodec("1");
				break;
			case 2:
			case 1:
			default:
				outputChar = codec.getCodec("3");
				break;
		}
		
		/*判讀檔案是否存在，存在則先在檔名後補上編碼格式*/
		if(fileTo.exists() == true) {
			String [] pathSpace;
			pathSpace = fileFrom.getPath().split(".txt");
			for(int i = 0; i < pathSpace.length; i++) {
				outputFileRoute = outputFileRoute + pathSpace[i];
			}
			outputFileRoute =  outputFileRoute + "_" + outputChar;
			fileToTmp = new File(outputFileRoute + ".txt");
			
			/*判讀新修改的檔案是否存在，如果存在且不允許覆蓋檔案，則在檔名後補上time stamp*/
			if(fileToTmp.exists() == true) {
				Date timeCurrent = new Date();
				outputFileRoute =  outputFileRoute + "_" + sdf0.format(timeCurrent) + ".txt";
				fileTo = new File(outputFileRoute);
			}
			else {
				fileTo = fileToTmp;
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
				/*MS950 2 bit, GBK 2 bit, UTF-8 3 bit*/
				charSpace = new char[charLen];
				/*讀到不回傳-1代表還有資料*/
				while((count = isr0.read(charSpace)) != -1){
	                osw0.write(charSpace, 0, count);
	            }
				System.out.println(appString.getAppString(1000) + fileTo + 
						appString.getAppString(1001) + outputChar);
	            
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
	
	/*僅接受"輸入檔案"、"輸出檔案"、"轉換模式"與"是否可直接覆蓋檔案"引數*/
	static void charsetTranslate(File fileFrom, File fileTo, double transMode, 
			boolean directCovered){		
		String inputChar, outputChar, outputFileRoute = "";
		int charLen, transParas;
		File fileToTmp;
		
		transParas = (int)Math.round(transMode);
		
		/*1.MS950->UTF-8 2.GBK->UTF-8 3.UTF-8->MS950 4.UTF-8->GBK 5.MS950->GBK 6.GBK->MS950*/
		switch(transParas) {
			case 4:
			case 3:
				inputChar = codec.getCodec("3");
				charLen = codecLen.getCodecLen("3");
				break;
			case 6:
			case 2:
				inputChar = codec.getCodec("2");
				charLen = codecLen.getCodecLen("2");
				break;
			case 5:
			case 1:
			default:
				inputChar = codec.getCodec("1");
				charLen = codecLen.getCodecLen("1");
				break;
		}
		switch(transParas) {
			case 5:
			case 4:
				outputChar = codec.getCodec("2");
				break;
			case 6:
			case 3:
				outputChar = codec.getCodec("1");
				break;
			case 2:
			case 1:
			default:
				outputChar = codec.getCodec("3");
				break;
		}
		
		/*判讀檔案是否存在，存在則先在檔名後補上編碼格式*/
		if(fileTo.exists() == true && directCovered == false) {
			String [] pathSpace;
			pathSpace = fileFrom.getPath().split(".txt");
			for(int i = 0; i < pathSpace.length; i++) {
				outputFileRoute = outputFileRoute + pathSpace[i];
			}
			outputFileRoute =  outputFileRoute + "_" + outputChar;
			fileToTmp = new File(outputFileRoute + ".txt");
			
			/*判讀新修改的檔案是否存在，如果存在且不允許覆蓋檔案，則在檔名後補上time stamp*/
			if(fileToTmp.exists() == true) {
				Date timeCurrent = new Date();
				outputFileRoute =  outputFileRoute + "_" + sdf0.format(timeCurrent) + ".txt";
				fileTo = new File(outputFileRoute);
			}
			else {
				fileTo = fileToTmp;
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
				/*MS950 2 bit, GBK 2 bit, UTF-8 3 bit*/
				charSpace = new char[charLen];
				/*讀到不回傳-1代表還有資料*/
				while((count = isr0.read(charSpace)) != -1){
	                osw0.write(charSpace, 0, count);
	            }
				System.out.println(appString.getAppString(1000) + fileTo + 
						appString.getAppString(1001) + outputChar);
	            
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
	
	/*僅接受"輸入檔案"、"輸出檔案"與"輸出格式"引數*/
	static void charsetTranslate(File fileFrom, File fileTo, String codecInfoTo){		
		String inputChar = codec.getCodec("1"), outputChar = codecInfoTo, outputFileRoute = "";
		int charLen = codecLen.getCodecLen("1");
		File fileToTmp;
		
		/*判讀檔案是否存在，存在則先在檔名後補上編碼格式*/
		if(fileTo.exists() == true) {
			String [] pathSpace;
			pathSpace = fileFrom.getPath().split(".txt");
			for(int i = 0; i < pathSpace.length; i++) {
				outputFileRoute = outputFileRoute + pathSpace[i];
			}
			outputFileRoute =  outputFileRoute + "_" + outputChar;
			fileToTmp = new File(outputFileRoute + ".txt");
			
			/*判讀新修改的檔案是否存在，如果存在且不允許覆蓋檔案，則在檔名後補上time stamp*/
			if(fileToTmp.exists() == true) {
				Date timeCurrent = new Date();
				outputFileRoute =  outputFileRoute + "_" + sdf0.format(timeCurrent) + ".txt";
				fileTo = new File(outputFileRoute);
			}
			else {
				fileTo = fileToTmp;
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
				/*MS950 2 bit, GBK 2 bit, UTF-8 3 bit*/
				charSpace = new char[charLen];
				/*讀到不回傳-1代表還有資料*/
				while((count = isr0.read(charSpace)) != -1){
	                osw0.write(charSpace, 0, count);
	            }
				System.out.println(appString.getAppString(1000) + fileTo + 
						appString.getAppString(1001) + outputChar);
				
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
	
	/*僅接受"輸入檔案"、"輸出檔案"、"輸出格式"與"是否可直接覆蓋檔案"引數*/
	static void charsetTranslate(File fileFrom, File fileTo, String codecInfoTo, 
			boolean directCovered){		
		String inputChar = codec.getCodec("1"), outputChar = codecInfoTo, outputFileRoute = "";
		int charLen = codecLen.getCodecLen("1");
		File fileToTmp;
		
		/*判讀檔案是否存在，存在則先在檔名後補上編碼格式*/
		if(fileTo.exists() == true && directCovered == false) {
			String [] pathSpace;
			pathSpace = fileFrom.getPath().split(".txt");
			for(int i = 0; i < pathSpace.length; i++) {
				outputFileRoute = outputFileRoute + pathSpace[i];
			}
			outputFileRoute =  outputFileRoute + "_" + outputChar;
			fileToTmp = new File(outputFileRoute + ".txt");
			
			/*判讀新修改的檔案是否存在，如果存在且不允許覆蓋檔案，則在檔名後補上time stamp*/
			if(fileToTmp.exists() == true) {
				Date timeCurrent = new Date();
				outputFileRoute =  outputFileRoute + "_" + sdf0.format(timeCurrent) + ".txt";
				fileTo = new File(outputFileRoute);
			}
			else {
				fileTo = fileToTmp;
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
				/*MS950 2 bit, GBK 2 bit, UTF-8 3 bit*/
				charSpace = new char[charLen];
				/*讀到不回傳-1代表還有資料*/
				while((count = isr0.read(charSpace)) != -1){
	                osw0.write(charSpace, 0, count);
	            }
				System.out.println(appString.getAppString(1000) + fileTo + 
						appString.getAppString(1001) + outputChar);
				
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
	
	/*僅接受"輸入檔案"、"輸出檔案"、"輸入格式"與"輸出格式"引數*/
	static void charsetTranslate(File fileFrom, File fileTo, String codecInfoFrom, 
			String codecInfoTo){		
		String inputChar = codecInfoFrom, outputChar = codecInfoTo, outputFileRoute = "";
		int charLen = codecLen.getCodecLen("1");
		File fileToTmp;
		
		/*非預設時*/
		if(codecInfoFrom.equals("") != true && codecInfoTo.equals("") != true) {
			if(codecInfoFrom.equals(codec.getCodec("1")) == true) {
				charLen = codecLen.getCodecLen("1");
			}
			else if(codecInfoFrom.equals(codec.getCodec("2")) == true) {
				charLen = codecLen.getCodecLen("2");
			}
			else if(codecInfoFrom.equals(codec.getCodec("3")) == true) {
				charLen = codecLen.getCodecLen("3");
			}
		}
		
		/*判讀檔案是否存在，存在則先在檔名後補上編碼格式*/
		if(fileTo.exists() == true) {
			String [] pathSpace;
			pathSpace = fileFrom.getPath().split(".txt");
			for(int i = 0; i < pathSpace.length; i++) {
				outputFileRoute = outputFileRoute + pathSpace[i];
			}
			outputFileRoute =  outputFileRoute + "_" + outputChar;
			fileToTmp = new File(outputFileRoute + ".txt");
			
			/*判讀新修改的檔案是否存在，如果存在且不允許覆蓋檔案，則在檔名後補上time stamp*/
			if(fileToTmp.exists() == true) {
				Date timeCurrent = new Date();
				outputFileRoute =  outputFileRoute + "_" + sdf0.format(timeCurrent) + ".txt";
				fileTo = new File(outputFileRoute);
			}
			else {
				fileTo = fileToTmp;
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
				/*MS950 2 bit, GBK 2 bit, UTF-8 3 bit*/
				charSpace = new char[charLen];
				/*讀到不回傳-1代表還有資料*/
				while((count = isr0.read(charSpace)) != -1){
	                osw0.write(charSpace, 0, count);
	            }
				System.out.println(appString.getAppString(1000) + fileTo + 
						appString.getAppString(1001) + outputChar);
				
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
	
	/*僅接受"輸入檔案"、"輸出檔案"、"輸入格式"、"輸出格式"與"是否可直接覆蓋檔案"引數*/
	static void charsetTranslate(File fileFrom, File fileTo, String codecInfoFrom, 
			String codecInfoTo, boolean directCovered){		
		String inputChar = codecInfoFrom, outputChar = codecInfoTo, outputFileRoute = "";
		int charLen = codecLen.getCodecLen("1");
		File fileToTmp;
		
		/*非預設時*/
		if(codecInfoFrom.equals("") != true && codecInfoTo.equals("") != true) {
			if(codecInfoFrom.equals(codec.getCodec("1")) == true) {
				charLen = codecLen.getCodecLen("1");
			}
			else if(codecInfoFrom.equals(codec.getCodec("2")) == true) {
				charLen = codecLen.getCodecLen("2");
			}
			else if(codecInfoFrom.equals(codec.getCodec("3")) == true) {
				charLen = codecLen.getCodecLen("3");
			}
		}
		
		/*判讀檔案是否存在，存在則先在檔名後補上編碼格式*/
		if(fileTo.exists() == true && directCovered == false) {
			String [] pathSpace;
			pathSpace = fileFrom.getPath().split(".txt");
			for(int i = 0; i < pathSpace.length; i++) {
				outputFileRoute = outputFileRoute + pathSpace[i];
			}
			outputFileRoute =  outputFileRoute + "_" + outputChar;
			fileToTmp = new File(outputFileRoute + ".txt");
			
			/*判讀新修改的檔案是否存在，如果存在且不允許覆蓋檔案，則在檔名後補上time stamp*/
			if(fileToTmp.exists() == true) {
				Date timeCurrent = new Date();
				outputFileRoute =  outputFileRoute + "_" + sdf0.format(timeCurrent) + ".txt";
				fileTo = new File(outputFileRoute);
			}
			else {
				fileTo = fileToTmp;
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
				/*MS950 2 bit, GBK 2 bit, UTF-8 3 bit*/
				charSpace = new char[charLen];
				/*讀到不回傳-1代表還有資料*/
				while((count = isr0.read(charSpace)) != -1){
	                osw0.write(charSpace, 0, count);
	            }
				System.out.println(appString.getAppString(1000) + fileTo + 
						appString.getAppString(1001) + outputChar);
				
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