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
				keepRun10 = false, keepRun11 = false;
		/*決定使用的Method用參數*/
		int methodParas;
		/*實例*/;
		AppString appString = AppString.getInstance();
		CodecMode codec = CodecMode.getInstance();
		
		System.out.println(appString.getAppString(1002));
		tmpParas = inputScan.nextLine();
		/*顯示說明*/
		displayInfo(tmpParas, appString);
		
		/*收集要匯入的檔案路徑*/
		do{
			 do{
				System.out.println(appString.getAppString(1006));
				inputFileRoute = inputScan.nextLine();
			
				/*無輸入*/
				if(inputFileRoute.equals("")) {
					keepRun1 = true;
					System.out.println(appString.getAppString(1007));
				}
				else {
					keepRun1 = false;
				}
			}while(keepRun1);
			
			/*檢查檔案是否存在*/
			inputFile = new File(inputFileRoute);
			if(inputFile.exists() == true) {
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
			
			if(tmpParas.equals("y") == true || tmpParas.equals("Y") == true) {
				keepRun3 = false;
				keepRun4 = true;
				/*也會使用outputFile參數下*/
				methodParas += 100;
			}
			else if(tmpParas.equals("") == true || tmpParas.equals("n") == true || 
					tmpParas.equals("N") == true) {
				keepRun3 = false;
				keepRun4 = false;
			}
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
				
				/*無輸入*/
				if(outputFileRoute.equals("")) {
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
			
			if(tmpParas.equals("n") == true || tmpParas.equals("N") == true) {
				keepRun6 = false;
				/*也會使用directCovered參數下*/
				methodParas ++;
			}
			else if(tmpParas.equals("y") == true || tmpParas.equals("Y") == true) {
				keepRun6 = false;
				/*也會使用directCovered參數下*/
				methodParas += 2;
			}
			else if(tmpParas.equals("") == true) {
				keepRun6 = false;
			}
			else {
				keepRun6 = true;
				System.out.println(appString.getAppString(1011));
			}
		}while(keepRun6);
		
		/*是否使用轉換模式參數*/
		do {
			System.out.println(appString.getAppString(1014));
			tmpParas = inputScan.nextLine();
			
			if(tmpParas.equals("y") == true || tmpParas.equals("Y") == true) {
				keepRun7 = false;
				keepRun8 = true;
				keepRun9 = false;
				/*也會使用transMode參數下*/
				methodParas += 10;
			}
			else if(tmpParas.equals("") == true || tmpParas.equals("n") == true || 
					tmpParas.equals("N") == true) {
				keepRun7 = false;
				keepRun8 = false;
				keepRun9 = true;
			}
			else {
				keepRun7 = true;
				System.out.println(appString.getAppString(1011));
			}
		}while(keepRun7);
			
		/*決定轉換模式*/
		while(keepRun8 == true) {
			System.out.println(appString.getAppString(1015));
			convertMode = inputScan.nextLine();
			
			if(convertMode.equals("1.0") == true || convertMode.equals("") == true) {
				keepRun8 = false;
				transMode = 1.0;
			}
			else if(convertMode.equals("2.0") == true) {
				keepRun8 = false;
				transMode = 2.0;
			}
			else if(convertMode.equals("3.0") == true) {
				keepRun8 = false;
				transMode = 3.0;
			}
			else if(convertMode.equals("4.0") == true) {
				keepRun8 = false;
				transMode = 4.0;
			}
			else if(convertMode.equals("5.0") == true) {
				keepRun8 = false;
				transMode = 5.0;
			}
			else if(convertMode.equals("6.0") == true) {
				keepRun8 = false;
				transMode = 6.0;
			}
			else {
				keepRun8 = true;
				System.out.println(appString.getAppString(1011));
			}
		}
		
		/*是否輸入輸入/輸出編碼*/
		do {
			if(keepRun9 == true) {
				System.out.println(appString.getAppString(1016));
				tmpParas = inputScan.nextLine();
					
				if(tmpParas.equals("y") == true || tmpParas.equals("Y") == true) {
					keepRun10 = false;
					keepRun11 = true;
				}
				else if(tmpParas.equals("") == true || tmpParas.equals("n") == true || 
						tmpParas.equals("N") == true) {
					keepRun10 = false;
					keepRun11 = false;
				}
				else {
					keepRun10 = true;
					System.out.println(appString.getAppString(1011));
				}
			}
		}while(keepRun10);
		
		/*收集輸入/輸出編碼：*/
		while(keepRun11 == true) {
			System.out.println(appString.getAppString(1017));
			codecString = inputScan.nextLine();
			
			if(codecString.equals("") == true) {
				codecInfoTo = codec.getCodec("3");
				/*也會使用codecInfoTo參數下*/
				methodParas += 20;
				keepRun11 = false;
			}
			else if(codecString.equals(",") == true) {
				codecInfoFrom = codec.getCodec("1");
				codecInfoTo = codec.getCodec("3");
				/*也會使用codecInfoFrom、codecInfoTo參數下*/
				methodParas += 30;
				keepRun11 = false;
			}
			else {
				/*參數用陣列*/
				String [] convertParas, modeParas;
				convertParas = codecString.split(",");
				/*用String.endsWith("String")來排除(1,)這種會觸發NullPointerException的輸入字串*/
				if(convertParas.length == 1 && codecString.endsWith(",") == false) {
					modeParas = new String[1];
					if(modeParas[0].equals("1") == true) {
						codecInfoTo = codec.getCodec("1");
						/*也會使用codecInfoTo參數下*/
						methodParas += 20;
						keepRun11 = false;
					}
					else if(modeParas[0].equals("2") == true) {
						codecInfoTo = codec.getCodec("2");
						/*也會使用codecInfoTo參數下*/
						methodParas += 20;
						keepRun11 = false;
					}
					else if(modeParas[0].equals("3") == true) {
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
					modeParas = new String[2];
					int countTmp = 0;
					/*支援的組合*/
					if(modeParas[0].equals("1") == true) {
						codecInfoFrom = codec.getCodec("1");
						countTmp++;
						if(modeParas[0].equals("2") == true) {
							codecInfoTo = codec.getCodec("2");
							countTmp++;
						}
						else if(modeParas[0].equals("3") == true) {
							codecInfoTo = codec.getCodec("3");
							countTmp++;
						}
					}
					else if(modeParas[0].equals("2") == true) {	
						codecInfoFrom = codec.getCodec("2");
						countTmp++;
						if(modeParas[0].equals("1") == true) {
							codecInfoTo = codec.getCodec("1");
							countTmp++;
						}
						else if(modeParas[0].equals("3") == true) {
							codecInfoTo = codec.getCodec("3");
							countTmp++;
						}
					}
					else if(modeParas[0].equals("3") == true) {
						codecInfoFrom = codec.getCodec("3");
						countTmp++;
						if(modeParas[0].equals("1") == true) {
							codecInfoTo = codec.getCodec("1");
							countTmp++;
						}
						else if(modeParas[0].equals("2") == true) {
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
		
		/*關閉Scanner物件*/
		inputScan.close();
	}
	
	private static void displayInfo(String displayParas, AppString appString){
		boolean displayInfo;
		
		if(displayParas.equals("") == true || displayParas.equals("Y") == true || 
				displayParas.equals("y") == true) {
			displayInfo = true;
		}
		else if(displayParas.equals("N") == true || displayParas.equals("n") == true) {
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