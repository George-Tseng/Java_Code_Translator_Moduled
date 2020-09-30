package javaTest;

import java.io.File;
import java.util.Scanner;

public class Java_Code_Translator_Moduled {
	public static void main(String[] args) {
		/*建立Scanner物件*/
		Scanner inputScan = new Scanner(System.in);
		/*匯入、匯出的檔案*/
		File inputFile, outputFile;
		/*inputFileRoute、outputFileRoute->匯入、匯出的檔案路徑，modeCover->是否覆蓋檔案，modeConvert->轉換用參數*/
		String inputFileRoute, outputFileRoute, modeCover, modeConvert;
		/*參數用陣列*/
		String [] convertParas, modeParas = new String [2];
		/*實例*/
		CodecMode codec = CodecMode.getInstance();
		
		System.out.println("在開始操作前，請先確認檔案所使用的編碼\n如不確定檔案編碼，建議在接下來的流程中不要選擇任何涉及到檔案覆蓋的選項\n");
		/*開關用boolean*/
		boolean keepRun1 = false, keepRun2 = false, keepRun3 = false, keepRun4 = false, keepRun5 = false;
		
		/*Part 1 收集要匯入的檔案路徑*/
		 do{
			 do{
				System.out.println("請先輸入欲匯入的檔案完整路徑：");
				inputFileRoute = inputScan.nextLine();
			
				/*無輸入*/
				if(inputFileRoute.equals("")) {
					keepRun1 = true;
					System.out.println("發生錯誤！請重新輸入！");
				}
				else {
					keepRun1 = false;
				}
			}while(keepRun1);
			
			/*Part 2 檢查檔案是否存在*/
			inputFile = new File(inputFileRoute);
			if(inputFile.exists() == true) {
				keepRun2 = false;
				System.out.println("匯入檔案路徑正確...");
			}
			else {
				System.out.println("指定路徑上的檔案不存在！請重新輸入！");
				keepRun1 = true;
				keepRun2 = true;
			}
		}while(keepRun2);
		
		/*Part 3 收集要匯出的檔案路徑*/
		do {
			do {
				System.out.println("請再輸入欲匯出的檔案完整路徑：");
				outputFileRoute = inputScan.nextLine();
			
				/*無輸入*/
				if(outputFileRoute.equals("")) {
					keepRun3 = true;
					System.out.println("發生錯誤！請重新輸入！");
				}
				else {
					keepRun3 = false;
				}
			}while(keepRun3);
			
			/*Part 4 檢查檔案是否存在*/
			outputFile = new File(outputFileRoute);
			
			/*匯出的路徑上已有檔案存在*/
			if(outputFile.exists() == true) {
				System.out.println("指定路徑上的特定檔案已存在！請問是否要直接覆蓋(Y/N)？預設為否(N)");
				modeCover = inputScan.nextLine();
				if(modeCover.equals("") == true || modeCover.equals("N") == true || modeCover.equals("n") == true) {
					keepRun4 = true;
					System.out.println("使用者選擇不進行檔案覆蓋...\n，請重新選擇匯出的檔案路徑與名稱...");
				}
				else if(modeCover.equals("Y") == true || modeCover.equals("y") == true){
					keepRun4 = false;
					System.out.println("匯出的檔案將會取代原有檔案...");
				}
				else {
					keepRun4 = true;
					System.out.println("無效的輸入參數！請重新輸入");
				}
			}
			/*可直接匯出*/
			else {
				keepRun4 = false;
				System.out.println("匯出檔案路徑有效...");
			}
			
		}while(keepRun4);
		
		/*Part 5 決定轉換模式*/
		do {
			System.out.println("請選擇輸入下列整數以選擇轉換模式：\n"
					+ "1為「MS950」、2為「GBK」、3為「UTF-8」\n"
					+ "第一個為匯入的編碼模式、第二個為匯出的編碼模式，彼此間請以「,」隔開\n"
					+ "(預設模式為「MS950」轉換至「UTF-8」，即「1,3」)：");
			modeConvert = inputScan.nextLine();
			
			if(modeConvert.equals("") == true) {
				keepRun5 = false;
				modeParas[0] = "MS950";
				modeParas[1] = "UTF-8";
			}
			else {
				convertParas = modeConvert.split(",");
				/*參數給的不足或過多*/
				if(convertParas.length != 2) {
					keepRun5 = true;
					System.out.println("無效的輸入參數！請重新輸入");
				}
				/*參數數量充足*/
				else {
					/*不支援的組合*/
					if(convertParas[0].equals(convertParas[1]) == true) {
						keepRun5 = true;
					}
					/*支援的組合*/
					else {
						keepRun5 = false;
						modeParas[0] = codec.getCodec(convertParas[0]);
						modeParas[1] = codec.getCodec(convertParas[1]);
					}
				}
			}
		}while(keepRun5);
		
		/*Part 6 開始轉換*/
		try {
			Codec_Translator.charsetTranslate(inputFile, outputFile, modeParas[0], modeParas[1]);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 
		/*關閉Scanner物件*/
		inputScan.close();
	}
}