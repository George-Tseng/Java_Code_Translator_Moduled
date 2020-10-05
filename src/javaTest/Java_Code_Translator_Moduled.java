package javaTest;

import java.io.File;
import java.util.Scanner;

public class Java_Code_Translator_Moduled {
	public static void main(String[] args) {
		/*建立Scanner物件*/
		Scanner inputScan = new Scanner(System.in);
		/*暫存參數->tmpParas、convertMode、 codecModeParas
		 *匯入/出之檔案路徑->inputFileRoute、outputFileRoute
		 *匯入/出之檔案編碼->codecInfoFrom、codecInfoTo*/
		String tmpParas, convertMode, codecString,
			inputFileRoute, outputFileRoute = "", codecInfoFrom = "", codecInfoTo = "";
		/*匯入的檔案*/
		File inputFile;
		/*轉換模式*/
		double transMode = 0.0;
		/*開關用boolean*/
		boolean keepRun1 = false, keepRun2 = false, keepRun3 = false, 
				keepRun4 = false, keepRun5 = false, keepRun6 = false,
				keepRun7 = false, keepRun8 = false, keepRun9 = true,
				keepRun10 = false, keepRun11 = false, keepRun0 = false, 
				keepRun12 = false, keepRun = false, keepRun13 = false;
		/*決定使用的Method用參數*/
		int methodParas;
		/*實例*/;
		AppString appString = AppString.getInstance();
		CodecMode codec = CodecMode.getInstance();
		
		/*程式開始*/
		main_loop:
		while(true) {
			System.out.println(appString.getAppString(1002));
			tmpParas = inputScan.nextLine();
			/*顯示說明*/
			displayInfo(tmpParas, appString);
			
			/*決定使用導引模式或專家模式*/
			do {
				System.out.println(appString.getAppString(1018));
				tmpParas = inputScan.nextLine();
				
				/*退出*/
				if(tmpParas.toUpperCase().equals(Paras.optionStr[3]) || 
						tmpParas.toUpperCase().equals(Paras.optionStr[4]) || 
						tmpParas.equals(Paras.optionStr[5])) {
					keepRun12 = false;
					keepRun0 = false;
					continue main_loop;
				}
				/*專家模式*/
				else if(tmpParas.toUpperCase().equals(Paras.optionStr[2])) {
					System.out.println(appString.getAppString(1020));
					keepRun12 = true;
					keepRun0 = false;
				}
				/*導引模式*/
				else if(tmpParas.equals(Paras.optionStr[0]) || 
						tmpParas.toUpperCase().equals(Paras.optionStr[1])){
					System.out.println(appString.getAppString(1021));
					keepRun12 = false;
					keepRun0 = false;
				}
				/*無效輸入*/
				else {
					System.out.println(appString.getAppString(1011));
					keepRun0 = true;
				}
			}while(keepRun0);
			
			/*專家模式*/
			if(keepRun12) {
				do {
					System.out.println(appString.getAppString(1022));
					tmpParas = inputScan.nextLine();
					
					/*參數用陣列*/
					String [] fullParas;
					fullParas = tmpParas.split(Paras.optionStr[15]);
					
					/*退出*/
					if(tmpParas.toUpperCase().equals(Paras.optionStr[3]) || 
							tmpParas.toUpperCase().equals(Paras.optionStr[4]) || 
							tmpParas.equals(Paras.optionStr[5])) {
						keepRun13 = false;
						continue main_loop;
					}
					/*參數給的過少/過多*/
					else if(fullParas.length < 1 || fullParas.length >5 || tmpParas.equals(Paras.optionStr[0])) {
						keepRun13 = true;
						System.out.println(appString.getAppString(1024));
					}
					/*1個參數*/
					else if(fullParas.length == 1) {
						/*檢查檔案是否存在*/
						inputFile = new File(fullParas[0]);
						
						/*存在*/
						if(inputFile.exists() == true) {
							keepRun13 = false;
							Codec_Translator.charsetTranslate(inputFile);
						}
						/*不存在*/
						else {
							keepRun13 = true;
							System.out.println(appString.getAppString(1009));
						}
					}
					/*2個參數*/
					else if(fullParas.length == 2) {
						/*檢查檔案是否存在*/
						inputFile = new File(fullParas[0]);
						
						/*存在*/
						if(inputFile.exists()) {
							keepRun13 = false;
							System.out.println(appString.getAppString(1008));
							
							/*確認第2個參數是否為布林值*/
							if(fullParas[1].toUpperCase().equals(Paras.optionStr[6])) {
								Codec_Translator.charsetTranslate(inputFile, true);
							}
							else if(fullParas[1].toUpperCase().equals(Paras.optionStr[7])) {
								Codec_Translator.charsetTranslate(inputFile, false);
							}
							/*確認第2個參數是否為1.0~6.0*/
							else if(fullParas[1].toUpperCase().equals(Paras.optionStr[8])) {
								Codec_Translator.charsetTranslate(inputFile, 1.0);
							}
							else if(fullParas[1].toUpperCase().equals(Paras.optionStr[9])) {
								Codec_Translator.charsetTranslate(inputFile, 2.0);
							}
							else if(fullParas[1].toUpperCase().equals(Paras.optionStr[10])) {
								Codec_Translator.charsetTranslate(inputFile, 3.0);
							}
							else if(fullParas[1].toUpperCase().equals(Paras.optionStr[11])) {
								Codec_Translator.charsetTranslate(inputFile, 4.0);
							}
							else if(fullParas[1].toUpperCase().equals(Paras.optionStr[12])) {
								Codec_Translator.charsetTranslate(inputFile, 5.0);
							}
							else if(fullParas[1].toUpperCase().equals(Paras.optionStr[13])) {
								Codec_Translator.charsetTranslate(inputFile, 6.0);
							}
							/*確認第2個參數是否為編碼*/
							else if(fullParas[1].toUpperCase().equals(codec.getCodec("1"))){
								Codec_Translator.charsetTranslate(inputFile, codec.getCodec("1"));
							}
							else if(fullParas[1].toUpperCase().equals(codec.getCodec("2"))){
								Codec_Translator.charsetTranslate(inputFile, codec.getCodec("2"));
							}
							else if(fullParas[1].toUpperCase().equals(codec.getCodec("3"))){
								Codec_Translator.charsetTranslate(inputFile, codec.getCodec("3"));
							}
							/*輸出路徑*/
							else {
								File outputFile = new File(fullParas[1]);
								Codec_Translator.charsetTranslate(inputFile, outputFile);
							}
						}
						/*不存在*/
						else {
							keepRun13 = true;
							System.out.println(appString.getAppString(1009));
						}
					}
					/*3個參數*/
					else if(fullParas.length == 3) {
						/*檢查檔案是否存在*/
						inputFile = new File(fullParas[0]);
						
						/*存在*/
						if(inputFile.exists()) {
							/*第2個參數是否為1.0~6.0*/
							if(fullParas[1].toUpperCase().equals(Paras.optionStr[8])) {
								/*確認第3個參數是否為布林值*/
								if(fullParas[2].toUpperCase().equals(Paras.optionStr[6])) {
									Codec_Translator.charsetTranslate(inputFile, 1.0, true);
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[7])) {
									Codec_Translator.charsetTranslate(inputFile, 1.0, false);
								}
								/*無效輸入*/
								else {
									keepRun13 = true;
									System.out.println(appString.getAppString(1009));
								}
							}
							else if(fullParas[1].toUpperCase().equals(Paras.optionStr[9])) {
								/*確認第3個參數是否為布林值*/
								if(fullParas[2].toUpperCase().equals(Paras.optionStr[6])) {
									Codec_Translator.charsetTranslate(inputFile, 2.0, true);
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[7])) {
									Codec_Translator.charsetTranslate(inputFile, 2.0, false);
								}
								/*無效輸入*/
								else {
									keepRun13 = true;
									System.out.println(appString.getAppString(1009));
								}
							}
							else if(fullParas[1].toUpperCase().equals(Paras.optionStr[10])) {
								/*確認第3個參數是否為布林值*/
								if(fullParas[2].toUpperCase().equals(Paras.optionStr[6])) {
									Codec_Translator.charsetTranslate(inputFile, 3.0, true);
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[7])) {
									Codec_Translator.charsetTranslate(inputFile, 3.0, false);
								}
								/*無效輸入*/
								else {
									keepRun13 = true;
									System.out.println(appString.getAppString(1009));
								}
							}
							else if(fullParas[1].toUpperCase().equals(Paras.optionStr[11])) {
								/*確認第3個參數是否為布林值*/
								if(fullParas[2].toUpperCase().equals(Paras.optionStr[6])) {
									Codec_Translator.charsetTranslate(inputFile, 4.0, true);
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[7])) {
									Codec_Translator.charsetTranslate(inputFile, 4.0, false);
								}
								/*無效輸入*/
								else {
									keepRun13 = true;
									System.out.println(appString.getAppString(1009));
								}
							}
							else if(fullParas[1].toUpperCase().equals(Paras.optionStr[12])) {
								/*確認第3個參數是否為布林值*/
								if(fullParas[2].toUpperCase().equals(Paras.optionStr[6])) {
									Codec_Translator.charsetTranslate(inputFile, 5.0, true);
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[7])) {
									Codec_Translator.charsetTranslate(inputFile, 5.0, false);
								}
								/*無效輸入*/
								else {
									keepRun13 = true;
									System.out.println(appString.getAppString(1009));
								}
							}
							else if(fullParas[1].toUpperCase().equals(Paras.optionStr[13])) {
								/*確認第3個參數是否為布林值*/
								if(fullParas[2].toUpperCase().equals(Paras.optionStr[6])) {
									Codec_Translator.charsetTranslate(inputFile, 6.0, true);
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[7])) {
									Codec_Translator.charsetTranslate(inputFile, 6.0, false);
								}
								/*無效輸入*/
								else {
									keepRun13 = true;
									System.out.println(appString.getAppString(1009));
								}
							}
							/*確認第2個參數是否為編碼*/
							else if(fullParas[1].toUpperCase().equals(codec.getCodec("1"))){
								/*確認第3個參數是否為布林值*/
								if(fullParas[2].toUpperCase().equals(Paras.optionStr[6])) {
									Codec_Translator.charsetTranslate(inputFile, codec.getCodec("1"), true);
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[7])) {
									Codec_Translator.charsetTranslate(inputFile, codec.getCodec("1"), false);
								}
								/*確認第3個參數是否為編碼*/
								else if(fullParas[2].toUpperCase().equals(codec.getCodec("2"))){
									Codec_Translator.charsetTranslate(inputFile, codec.getCodec("1"), codec.getCodec("2"));
								}
								else if(fullParas[2].toUpperCase().equals(codec.getCodec("3"))){
									Codec_Translator.charsetTranslate(inputFile, codec.getCodec("1"), codec.getCodec("3"));
								}
								/*無效輸入*/
								else {
									keepRun13 = true;
									System.out.println(appString.getAppString(1009));
								}
							}
							else if(fullParas[1].toUpperCase().equals(codec.getCodec("2"))){
								/*確認第3個參數是否為布林值*/
								if(fullParas[2].toUpperCase().equals(Paras.optionStr[6])) {
									Codec_Translator.charsetTranslate(inputFile, codec.getCodec("2"), true);
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[7])) {
									Codec_Translator.charsetTranslate(inputFile, codec.getCodec("2"), false);
								}
								/*確認第3個參數是否為編碼*/
								else if(fullParas[2].toUpperCase().equals(codec.getCodec("1"))){
									Codec_Translator.charsetTranslate(inputFile, codec.getCodec("2"), codec.getCodec("1"));
								}
								else if(fullParas[2].toUpperCase().equals(codec.getCodec("3"))){
									Codec_Translator.charsetTranslate(inputFile, codec.getCodec("2"), codec.getCodec("3"));
								}
								/*無效輸入*/
								else {
									keepRun13 = true;
									System.out.println(appString.getAppString(1009));
								}
							}
							else if(fullParas[1].toUpperCase().equals(codec.getCodec("3"))){
								/*確認第3個參數是否為布林值*/
								if(fullParas[2].toUpperCase().equals(Paras.optionStr[6])) {
									Codec_Translator.charsetTranslate(inputFile, codec.getCodec("3"), true);
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[7])) {
									Codec_Translator.charsetTranslate(inputFile, codec.getCodec("3"), false);
								}
								/*確認第3個參數是否為編碼*/
								else if(fullParas[2].toUpperCase().equals(codec.getCodec("1"))){
									Codec_Translator.charsetTranslate(inputFile, codec.getCodec("3"), codec.getCodec("1"));
								}
								else if(fullParas[2].toUpperCase().equals(codec.getCodec("2"))){
									Codec_Translator.charsetTranslate(inputFile, codec.getCodec("3"), codec.getCodec("2"));
								}
								/*無效輸入*/
								else {
									keepRun13 = true;
									System.out.println(appString.getAppString(1009));
								}
							}
							else {
								File outputFile = new File(fullParas[1]);
								
								/*確認第3個參數是否為布林值*/
								if(fullParas[2].toUpperCase().equals(Paras.optionStr[6])) {
									Codec_Translator.charsetTranslate(inputFile, outputFile, true);
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[7])) {
									Codec_Translator.charsetTranslate(inputFile, outputFile, false);
								}
								/*確認第3個參數是否為編碼*/
								if(fullParas[2].toUpperCase().equals(codec.getCodec("1"))){
									Codec_Translator.charsetTranslate(inputFile, outputFile, codec.getCodec("1"));
								}
								else if(fullParas[2].toUpperCase().equals(codec.getCodec("2"))){
									Codec_Translator.charsetTranslate(inputFile, outputFile, codec.getCodec("2"));
								}
								else if(fullParas[2].toUpperCase().equals(codec.getCodec("3"))){
									Codec_Translator.charsetTranslate(inputFile, outputFile, codec.getCodec("3"));
								}
								/*確認第3個參數是否為1.0~6.0*/
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[8])) {
									Codec_Translator.charsetTranslate(inputFile, outputFile, 1.0);
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[9])) {
									Codec_Translator.charsetTranslate(inputFile, outputFile, 2.0);
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[10])) {
									Codec_Translator.charsetTranslate(inputFile, outputFile, 3.0);
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[11])) {
									Codec_Translator.charsetTranslate(inputFile, outputFile, 4.0);
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[12])) {
									Codec_Translator.charsetTranslate(inputFile, outputFile, 5.0);
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[13])) {
									Codec_Translator.charsetTranslate(inputFile, outputFile, 6.0);
								}
								/*無效輸入*/
								else {
									keepRun13 = true;
									System.out.println(appString.getAppString(1009));
								}
							}
						}
						/*不存在*/
						else {
							keepRun13 = true;
							System.out.println(appString.getAppString(1009));
						}
					}
					/*4個參數*/
					else if(fullParas.length == 4) {
						/*檢查檔案是否存在*/
						inputFile = new File(fullParas[0]);
						
						/*存在*/
						if(inputFile.exists()) {
							/*確認第2個參數是否為編碼*/
							if(fullParas[1].toUpperCase().equals(codec.getCodec("1"))){
								/*確認第3個參數是否為編碼*/
								if(fullParas[2].toUpperCase().equals(codec.getCodec("2"))) {
									/*確認第4個參數是否為布林值*/
									if(fullParas[3].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, codec.getCodec("1"), codec.getCodec("2"), true);
									}
									else if(fullParas[3].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, codec.getCodec("1"), codec.getCodec("2"), false);
									}
									/*無效輸入*/
									else {
										keepRun13 = true;
										System.out.println(appString.getAppString(1009));
									}
								}
								else if(fullParas[2].toUpperCase().equals(codec.getCodec("3"))) {
									/*確認第4個參數是否為布林值*/
									if(fullParas[3].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, codec.getCodec("1"), codec.getCodec("3"), true);
									}
									else if(fullParas[3].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, codec.getCodec("1"), codec.getCodec("3"), false);
									}
									/*無效輸入*/
									else {
										keepRun13 = true;
										System.out.println(appString.getAppString(1009));
									}
								}
								/*無效輸入*/
								else {
									keepRun13 = true;
									System.out.println(appString.getAppString(1009));
								}
								
							}
							else if(fullParas[1].toUpperCase().equals(codec.getCodec("2"))){
								/*確認第3個參數是否為編碼*/
								if(fullParas[2].toUpperCase().equals(codec.getCodec("1"))) {
									/*確認第4個參數是否為布林值*/
									if(fullParas[3].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, codec.getCodec("2"), codec.getCodec("1"), true);
									}
									else if(fullParas[3].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, codec.getCodec("2"), codec.getCodec("1"), false);
									}
									/*無效輸入*/
									else {
										keepRun13 = true;
										System.out.println(appString.getAppString(1009));
									}
								}
								else if(fullParas[2].toUpperCase().equals(codec.getCodec("3"))) {
									/*確認第4個參數是否為布林值*/
									if(fullParas[3].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, codec.getCodec("2"), codec.getCodec("3"), true);
									}
									else if(fullParas[3].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, codec.getCodec("2"), codec.getCodec("3"), false);
									}
									/*無效輸入*/
									else {
										keepRun13 = true;
										System.out.println(appString.getAppString(1009));
									}
								}
								/*無效輸入*/
								else {
									keepRun13 = true;
									System.out.println(appString.getAppString(1009));
								}
							}
							else if(fullParas[1].toUpperCase().equals(codec.getCodec("3"))){
								/*確認第3個參數是否為編碼*/
								if(fullParas[2].toUpperCase().equals(codec.getCodec("1"))) {
									/*確認第4個參數是否為布林值*/
									if(fullParas[3].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, codec.getCodec("3"), codec.getCodec("1"), true);
									}
									else if(fullParas[3].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, codec.getCodec("3"), codec.getCodec("1"), false);
									}
									/*無效輸入*/
									else {
										keepRun13 = true;
										System.out.println(appString.getAppString(1009));
									}
								}
								else if(fullParas[2].toUpperCase().equals(codec.getCodec("2"))) {
									/*確認第4個參數是否為布林值*/
									if(fullParas[3].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, codec.getCodec("3"), codec.getCodec("1"), true);
									}
									else if(fullParas[3].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, codec.getCodec("3"), codec.getCodec("1"), false);
									}
									/*無效輸入*/
									else {
										keepRun13 = true;
										System.out.println(appString.getAppString(1009));
									}
								}
								/*無效輸入*/
								else {
									keepRun13 = true;
									System.out.println(appString.getAppString(1009));
								}
							}
							else {
								File outputFile = new File(fullParas[1]);
								
								/*確認第3個參數是否為編碼*/
								if(fullParas[2].toUpperCase().equals(codec.getCodec("1"))) {
									/*確認第4個參數是否為布林*/
									if(fullParas[3].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, codec.getCodec("1"), true);
									}
									else if(fullParas[3].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, codec.getCodec("1"), false);
									}
									/*確認第4個參數是否為編碼*/
									else if(fullParas[1].toUpperCase().equals(codec.getCodec("2"))){
										Codec_Translator.charsetTranslate(inputFile, outputFile, codec.getCodec("1"), codec.getCodec("2"));
									}
									else if(fullParas[1].toUpperCase().equals(codec.getCodec("3"))){
										Codec_Translator.charsetTranslate(inputFile, outputFile, codec.getCodec("1"), codec.getCodec("3"));
									}
									/*無效輸入*/
									else {
										keepRun13 = true;
										System.out.println(appString.getAppString(1009));
									}
								}
								else if(fullParas[2].toUpperCase().equals(codec.getCodec("2"))) {
									/*確認第4個參數是否為布林*/
									if(fullParas[3].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, codec.getCodec("2"), true);
									}
									else if(fullParas[3].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, codec.getCodec("2"), false);
									}
									/*確認第4個參數是否為編碼*/
									else if(fullParas[1].toUpperCase().equals(codec.getCodec("1"))){
										Codec_Translator.charsetTranslate(inputFile, outputFile, codec.getCodec("2"), codec.getCodec("1"));
									}
									else if(fullParas[1].toUpperCase().equals(codec.getCodec("3"))){
										Codec_Translator.charsetTranslate(inputFile, outputFile, codec.getCodec("2"), codec.getCodec("3"));
									}
									/*無效輸入*/
									else {
										keepRun13 = true;
										System.out.println(appString.getAppString(1009));
									}
								}
								else if(fullParas[2].toUpperCase().equals(codec.getCodec("3"))) {
									/*確認第4個參數是否為布林*/
									if(fullParas[3].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, codec.getCodec("3"), true);
									}
									else if(fullParas[3].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, codec.getCodec("3"), false);
									}
									/*確認第4個參數是否為編碼*/
									else if(fullParas[1].toUpperCase().equals(codec.getCodec("1"))){
										Codec_Translator.charsetTranslate(inputFile, outputFile, codec.getCodec("3"), codec.getCodec("1"));
									}
									else if(fullParas[1].toUpperCase().equals(codec.getCodec("2"))){
										Codec_Translator.charsetTranslate(inputFile, outputFile, codec.getCodec("3"), codec.getCodec("2"));
									}
									/*無效輸入*/
									else {
										keepRun13 = true;
										System.out.println(appString.getAppString(1009));
									}
								}
								/*確認第3個參數是否為1.0~6.0*/
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[8])) {
									/*確認第4個參數是否為布林*/
									if(fullParas[3].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, 1.0, true);
									}
									else if(fullParas[3].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, 1.0, false);
									}
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[9])) {
									/*確認第4個參數是否為布林*/
									if(fullParas[3].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, 2.0, true);
									}
									else if(fullParas[3].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, 2.0, false);
									}
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[10])) {
									/*確認第4個參數是否為布林*/
									if(fullParas[3].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, 3.0, true);
									}
									else if(fullParas[3].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, 3.0, false);
									}
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[11])) {
									/*確認第4個參數是否為布林*/
									if(fullParas[3].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, 4.0, true);
									}
									else if(fullParas[3].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, 4.0, false);
									}
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[12])) {
									/*確認第4個參數是否為布林*/
									if(fullParas[3].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, 5.0, true);
									}
									else if(fullParas[3].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, 5.0, false);
									}
								}
								else if(fullParas[2].toUpperCase().equals(Paras.optionStr[13])) {
									/*確認第4個參數是否為布林*/
									if(fullParas[3].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, 6.0, true);
									}
									else if(fullParas[3].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, 6.0, false);
									}
								}
								/*無效輸入*/
								else {
									keepRun13 = true;
									System.out.println(appString.getAppString(1009));
								}
							}
						}
						/*不存在*/
						else {
							keepRun13 = true;
							System.out.println(appString.getAppString(1009));
						}
					}
					/*5個參數*/
					else if(fullParas.length == 5) {
						/*檢查檔案是否存在*/
						inputFile = new File(fullParas[0]);
						File outputFile = new File(fullParas[1]);
						
						/*存在*/
						if(inputFile.exists()) {
							/*檢查第3個參數是否為編碼*/
							if(fullParas[2].toUpperCase().equals(codec.getCodec("1"))) {
								/*檢查第4個參數是否為編碼*/
								if(fullParas[3].toUpperCase().equals(codec.getCodec("2")) || 
										(fullParas[3].toUpperCase().equals(codec.getCodec("3")))) {
									/*檢查第5個參數是否為布林*/
									if(fullParas[4].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, fullParas[2], fullParas[3], true);
									}
									else if(fullParas[1].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, fullParas[2], fullParas[3], false);
									}
									/*無效輸入*/
									else {
										keepRun13 = true;
										System.out.println(appString.getAppString(1009));
									}
								}
								/*無效輸入*/
								else {
									keepRun13 = true;
									System.out.println(appString.getAppString(1009));
								}
							}
							else if(fullParas[2].toUpperCase().equals(codec.getCodec("2"))) {
								/*檢查第4個參數是否為編碼*/
								if(fullParas[3].toUpperCase().equals(codec.getCodec("1")) || 
										(fullParas[3].toUpperCase().equals(codec.getCodec("3")))) {
									/*檢查第5個參數是否為布林*/
									if(fullParas[4].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, fullParas[2], fullParas[3], true);
									}
									else if(fullParas[1].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, fullParas[2], fullParas[3], false);
									}
									/*無效輸入*/
									else {
										keepRun13 = true;
										System.out.println(appString.getAppString(1009));
									}
								}
								/*無效輸入*/
								else {
									keepRun13 = true;
									System.out.println(appString.getAppString(1009));
								}
							}
							else if(fullParas[2].toUpperCase().equals(codec.getCodec("3"))) {
								/*檢查第4個參數是否為編碼*/
								if(fullParas[3].toUpperCase().equals(codec.getCodec("1")) || 
										(fullParas[3].toUpperCase().equals(codec.getCodec("2")))) {
									/*檢查第5個參數是否為布林*/
									if(fullParas[4].toUpperCase().equals(Paras.optionStr[6])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, fullParas[2], fullParas[3], true);
									}
									else if(fullParas[1].toUpperCase().equals(Paras.optionStr[7])) {
										Codec_Translator.charsetTranslate(inputFile, outputFile, fullParas[2], fullParas[3], false);
									}
									/*無效輸入*/
									else {
										keepRun13 = true;
										System.out.println(appString.getAppString(1009));
									}
								}
								/*無效輸入*/
								else {
									keepRun13 = true;
									System.out.println(appString.getAppString(1009));
								}
							}
							/*無效輸入*/
							else {
								keepRun13 = true;
								System.out.println(appString.getAppString(1009));
							}
						}
						/*不存在*/
						else {
							keepRun13 = true;
							System.out.println(appString.getAppString(1009));
						}
					}
				}while(keepRun13);
			}
			
			/*導引模式*/
			else {
				/*收集要匯入的檔案路徑*/
				do{
					 do{
						System.out.println(appString.getAppString(1006));
						inputFileRoute = inputScan.nextLine();
					
						/*無輸入*/
						if(inputFileRoute.equals(Paras.optionStr[0])) {
							keepRun1 = true;
							System.out.println(appString.getAppString(1007));
						}
						/*其他輸入*/
						else {
							keepRun1 = false;
						}
					}while(keepRun1);
					
					/*退出*/
				    if(inputFileRoute.toUpperCase().equals(Paras.optionStr[3]) || 
				    		inputFileRoute.toUpperCase().equals(Paras.optionStr[4]) || 
				    		inputFileRoute.equals(Paras.optionStr[5])) {
						keepRun2 = false;
						continue main_loop;
					}
					/*檢查檔案是否存在*/
					inputFile = new File(inputFileRoute);
					if(inputFile.exists()) {
						keepRun2 = false;
						System.out.println(appString.getAppString(1008));
					}
					else {
						System.out.println(appString.getAppString(1009));
						keepRun1 = true;
						keepRun2 = true;
					}
				}while(keepRun2);
				/*僅有inputFile參數下*/
				methodParas = 1000;
				
				/*決定是否要手動輸入檔案輸出路徑*/
				do {
					System.out.println(appString.getAppString(1010));
					tmpParas = inputScan.nextLine();
					
					/*退出*/
				    if(tmpParas.toUpperCase().equals(Paras.optionStr[3]) || 
				    		tmpParas.toUpperCase().equals(Paras.optionStr[4]) || 
				    		tmpParas.equals(Paras.optionStr[5])) {
						keepRun3 = false;
						continue main_loop;
					}
				    /*是*/
				    else if(tmpParas.toUpperCase().equals(Paras.optionStr[1])) {
						keepRun3 = false;
						keepRun4 = true;
						/*也會使用outputFile參數下*/
						methodParas += 100;
					}
					/*預設/否*/
					else if(tmpParas.equals(Paras.optionStr[0]) || 
							tmpParas.toUpperCase().equals(Paras.optionStr[2])) {
						keepRun3 = false;
						keepRun4 = false;
					}
					/*無效輸入*/
					else {
						keepRun3 = true;
						keepRun4 = false;
						System.out.println(appString.getAppString(1011));
					}
				}while(keepRun3);
				
				/*收集要匯出的檔案路徑*/
				if(keepRun4) {
					do {
						System.out.println(appString.getAppString(1012));
						outputFileRoute = inputScan.nextLine();
						
						/*退出*/
					    if(outputFileRoute.toUpperCase().equals(Paras.optionStr[3]) || 
					    		outputFileRoute.toUpperCase().equals(Paras.optionStr[4]) || 
					    		outputFileRoute.equals(Paras.optionStr[5])) {
							keepRun5 = false;
							continue main_loop;
						}
						/*無輸入*/
					    else if(outputFileRoute.equals(Paras.optionStr[0])) {
							keepRun5 = true;
							System.out.println(appString.getAppString(1007));
						}
						/*正規輸入*/
						else {
							keepRun5 = false;
						}
					}while(keepRun5);			
				}
				
				/*決定輸出的檔案如已經存在時，是否允許覆蓋？*/
				do {
					System.out.println(appString.getAppString(1013));
					tmpParas = inputScan.nextLine();
					
					/*退出*/
				    if(tmpParas.toUpperCase().equals(Paras.optionStr[3]) || 
				    		tmpParas.toUpperCase().equals(Paras.optionStr[4]) || 
				    		tmpParas.equals(Paras.optionStr[5])) {
						keepRun6 = false;
						continue main_loop;
					}
				    /*否*/
				    else if(tmpParas.toUpperCase().equals(Paras.optionStr[2])) {
						keepRun6 = false;
						/*也會使用directCovered參數下*/
						methodParas ++;
					}
				    /*是*/
					else if(tmpParas.toUpperCase().equals(Paras.optionStr[1])) {
						keepRun6 = false;
						/*也會使用directCovered參數下*/
						methodParas += 2;
					}
				    /*留空*/
					else if(tmpParas.equals(Paras.optionStr[0])) {
						keepRun6 = false;
					}
				    /*無效輸入*/
					else {
						keepRun6 = true;
						System.out.println(appString.getAppString(1011));
					}
				}while(keepRun6);
				
				/*是否使用轉換模式參數*/
				do {
					System.out.println(appString.getAppString(1014));
					tmpParas = inputScan.nextLine();
					
					/*退出*/
				    if(tmpParas.toUpperCase().equals(Paras.optionStr[3]) || 
				    		tmpParas.toUpperCase().equals(Paras.optionStr[4]) || 
				    		tmpParas.equals(Paras.optionStr[5])) {
						keepRun6 = false;
						continue main_loop;
					}
				    /*是*/
					if(tmpParas.toUpperCase().equals(Paras.optionStr[1])) {
						keepRun7 = false;
						keepRun8 = true;
						keepRun9 = false;
						/*也會使用transMode參數下*/
						methodParas += 10;
					}
					/*預設/否*/
					else if(tmpParas.equals(Paras.optionStr[0]) || 
							tmpParas.toUpperCase().equals(Paras.optionStr[1])) {
						keepRun7 = false;
						keepRun8 = false;
						keepRun9 = true;
					}
					/*無效輸入*/
					else {
						keepRun7 = true;
						System.out.println(appString.getAppString(1011));
					}
				}while(keepRun7);
					
				/*決定轉換模式*/
				while(keepRun8) {
					System.out.println(appString.getAppString(1015));
					convertMode = inputScan.nextLine();
					
					/*退出*/
				    if(convertMode.toUpperCase().equals(Paras.optionStr[3]) || 
				    		convertMode.toUpperCase().equals(Paras.optionStr[4]) || 
				    		convertMode.equals(Paras.optionStr[5])) {
						keepRun7 = false;
						continue main_loop;
					}
				    /*有效輸入*/
				    else if(convertMode.equals("1.0") || convertMode.equals("")) {
						keepRun8 = false;
						transMode = 1.0;
					}
					else if(convertMode.equals("2.0")) {
						keepRun8 = false;
						transMode = 2.0;
					}
					else if(convertMode.equals("3.0")) {
						keepRun8 = false;
						transMode = 3.0;
					}
					else if(convertMode.equals("4.0")) {
						keepRun8 = false;
						transMode = 4.0;
					}
					else if(convertMode.equals("5.0")) {
						keepRun8 = false;
						transMode = 5.0;
					}
					else if(convertMode.equals("6.0")) {
						keepRun8 = false;
						transMode = 6.0;
					}
				    /*無效輸入*/
					else {
						keepRun8 = true;
						System.out.println(appString.getAppString(1011));
					}
				}
				
				/*是否輸入輸入/輸出編碼*/
				do {
					if(keepRun9) {
						System.out.println(appString.getAppString(1016));
						tmpParas = inputScan.nextLine();
						
						/*退出*/
					    if(tmpParas.toUpperCase().equals(Paras.optionStr[3]) || 
					    		tmpParas.toUpperCase().equals(Paras.optionStr[4]) || 
					    		tmpParas.equals(Paras.optionStr[5])) {
							keepRun10 = false;
							keepRun11 = false;
							continue main_loop;
						}
					    /*是*/
						if(tmpParas.toUpperCase().equals(Paras.optionStr[1])) {
							keepRun10 = false;
							keepRun11 = true;
						}
						/*預設/否*/
						else if(tmpParas.equals(Paras.optionStr[0]) || 
								tmpParas.toUpperCase().equals(Paras.optionStr[2])) {
							keepRun10 = false;
							keepRun11 = false;
						}
						/*無效輸入*/
						else {
							keepRun10 = true;
							System.out.println(appString.getAppString(1011));
						}
					}
				}while(keepRun10);
				
				/*收集輸入/輸出編碼：*/
				while(keepRun11) {
					System.out.println(appString.getAppString(1017));
					codecString = inputScan.nextLine();
					
					/*退出*/
				    if(codecString.toUpperCase().equals(Paras.optionStr[3]) || 
				    		codecString.toUpperCase().equals(Paras.optionStr[4]) || 
				    		codecString.equals(Paras.optionStr[5])) {
						keepRun11 = false;
						continue main_loop;
					}
				    /*輸入留空->輸出編碼採預設*/
				    else if(codecString.equals(Paras.optionStr[0])) {
						codecInfoTo = codec.getCodec("3");
						/*也會使用codecInfoTo參數下*/
						methodParas += 20;
						keepRun11 = false;
					}
					/*輸入,->輸入+輸出編碼採預設*/
					else if(codecString.equals(Paras.optionStr[15])) {
						codecInfoFrom = codec.getCodec("1");
						codecInfoTo = codec.getCodec("3");
						/*也會使用codecInfoFrom、codecInfoTo參數下*/
						methodParas += 30;
						keepRun11 = false;
					}
					else {
						/*參數用陣列*/
						String [] convertParas;
						convertParas = codecString.split(Paras.optionStr[15]);
						if(convertParas.length == 1) {
							if(convertParas[0].equals("1")) {
								codecInfoTo = codec.getCodec("1");
								/*也會使用codecInfoTo參數下*/
								methodParas += 20;
								keepRun11 = false;
							}
							else if(convertParas[0].equals("2")) {
								codecInfoTo = codec.getCodec("2");
								/*也會使用codecInfoTo參數下*/
								methodParas += 20;
								keepRun11 = false;
							}
							else if(convertParas[0].equals("3")) {
								codecInfoTo = codec.getCodec("3");
								/*也會使用codecInfoTo參數下*/
								methodParas += 20;
								keepRun11 = false;
							}
							else {
								keepRun11 = true;
							}
						}
						else if(convertParas.length == 2) {
							int countTmp = 0;
							/*支援的組合*/
							if(convertParas[0].equals("1")) {
								codecInfoFrom = codec.getCodec("1");
								countTmp++;
								if(convertParas[1].equals("2")) {
									codecInfoTo = codec.getCodec("2");
									countTmp++;
								}
								else if(convertParas[1].equals("3")) {
									codecInfoTo = codec.getCodec("3");
									countTmp++;
								}
							}
							else if(convertParas[0].equals("2")) {	
								codecInfoFrom = codec.getCodec("2");
								countTmp++;
								if(convertParas[1].equals("1")) {
									codecInfoTo = codec.getCodec("1");
									countTmp++;
								}
								else if(convertParas[1].equals("3")) {
									codecInfoTo = codec.getCodec("3");
									countTmp++;
								}
							}
							else if(convertParas[0].equals("3")) {
								codecInfoFrom = codec.getCodec("3");
								countTmp++;
								if(convertParas[1].equals("1")) {
									codecInfoTo = codec.getCodec("1");
									countTmp++;
								}
								else if(convertParas[1].equals("2")) {
									codecInfoTo = codec.getCodec("2");
									countTmp++;
								}
							}
							if(countTmp == 2) {
								/*也會使用codecInfoFrom、codecInfoTo參數下*/
								methodParas += 30;
								keepRun11 = false;
							}
							else {
								keepRun11 = true;
								System.out.println(appString.getAppString(1011));
							}
						}
						else {
							keepRun11 = true;
							System.out.println(appString.getAppString(1011));
						}
					}
				}
				
				File outputFile = new File(outputFileRoute);
				/*最後執行階段*/
				switch(methodParas) {
					case 1000:
						Codec_Translator.charsetTranslate(inputFile);
						break;
					case 1001:
						Codec_Translator.charsetTranslate(inputFile, false);
						break;
					case 1002:
						Codec_Translator.charsetTranslate(inputFile, true);
						break;
					case 1100:
						Codec_Translator.charsetTranslate(inputFile, outputFile);
						break;
					case 1101:
						Codec_Translator.charsetTranslate(inputFile, outputFile, false);
						break;
					case 1102:
						Codec_Translator.charsetTranslate(inputFile, outputFile, true);
						break;
					case 1010:
						Codec_Translator.charsetTranslate(inputFile, transMode);
						break;
					case 1011:
						Codec_Translator.charsetTranslate(inputFile, transMode, false);
						break;
					case 1012:
						Codec_Translator.charsetTranslate(inputFile, transMode, true);
						break;
					case 1110:
						Codec_Translator.charsetTranslate(inputFile, outputFile, transMode);
						break;
					case 1111:
						Codec_Translator.charsetTranslate(inputFile, outputFile, transMode, false);
						break;
					case 1112:
						Codec_Translator.charsetTranslate(inputFile, outputFile, transMode, true);
						break;
					case 1020:
						Codec_Translator.charsetTranslate(inputFile, codecInfoTo);
						break;
					case 1021:
						Codec_Translator.charsetTranslate(inputFile, codecInfoTo, false);
						break;
					case 1022:
						Codec_Translator.charsetTranslate(inputFile, codecInfoTo, true);
						break;
					case 1120:
						Codec_Translator.charsetTranslate(inputFile, outputFile, codecInfoTo);
						break;
					case 1121:
						Codec_Translator.charsetTranslate(inputFile, outputFile, codecInfoTo, false);
						break;
					case 1122:
						Codec_Translator.charsetTranslate(inputFile, outputFile, codecInfoTo, true);
						break;
					case 1030:
						Codec_Translator.charsetTranslate(inputFile, codecInfoFrom, codecInfoTo);
						break;
					case 1031:
						Codec_Translator.charsetTranslate(inputFile, codecInfoFrom, codecInfoTo, false);
						break;
					case 1032:
						Codec_Translator.charsetTranslate(inputFile, codecInfoFrom, codecInfoTo, true);
						break;
					case 1130:
						Codec_Translator.charsetTranslate(inputFile, outputFile, codecInfoFrom, codecInfoTo);
						break;
					case 1131:
						Codec_Translator.charsetTranslate(inputFile, outputFile, codecInfoFrom, codecInfoTo, false);
						break;
					case 1132:
						Codec_Translator.charsetTranslate(inputFile, outputFile, codecInfoFrom, codecInfoTo, true);
						break;
				}
			}
			/*決定是否持續執行*/
			do {
				System.out.println(appString.getAppString(1019));
				tmpParas = inputScan.nextLine();
				
				/*繼續執行*/
				if(tmpParas.toUpperCase().equals(Paras.optionStr[1])) {
					keepRun = true;
					break;
				}
				/*停止/預設*/
				else if(tmpParas.equals(Paras.optionStr[0]) || 
						tmpParas.toUpperCase().equals(Paras.optionStr[2])) {
					keepRun = false;
					break;
				}/*無效輸入*/
				else {
					keepRun = false;
				}
			}while(true);
			if(!keepRun) {
				System.out.println(appString.getAppString(1023));
				break;
			}
			else {
				continue;
			}
		}
		/*關閉Scanner物件*/
		inputScan.close();
	}
	
	private static void displayInfo(String displayParas, AppString appString){
		boolean displayInfo;
		
		if(displayParas.equals(Paras.optionStr[0]) || 
				displayParas.toUpperCase().equals(Paras.optionStr[1])) {
			displayInfo = true;
		}
		else if(displayParas.toUpperCase().equals(Paras.optionStr[2]) == true) {
			System.out.println(appString.getAppString(1003));
			displayInfo = false;
		}
		else{
			displayInfo = false;
			System.out.println(appString.getAppString(1004));
		}
		
		if(displayInfo == true) {
			System.out.println(appString.getAppString(1005));
		}
	}
}