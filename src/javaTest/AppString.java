package javaTest;

import java.util.HashMap;
import java.util.Map;

public class AppString {
	/*用Map存資料*/
	Map<Integer, String> dataMap;
	/*實例*/
	private static AppString instance;
	
	public static AppString getInstance() {
		/*如果實例不存在才新建*/
		if (instance == null) {
			instance = new AppString();
		}
		return instance;
	}
	
	/*建構子*/
	private AppString() {
		dataMap = new HashMap<>();
		/*塞入參數資料-Code_Translator.java*/
		dataMap.put(1000, "轉換工作已完成，檔案路徑為：");
		dataMap.put(1001, "\n檔案採用的編碼為：");
		/*塞入參數資料-Java_Code_Translator_Moduled.java*/
		dataMap.put(1002, "在開始操作前，請先確認檔案所使用的編碼...\n"
				+ "如不確定檔案編碼，建議在接下來的流程中不要選擇任何涉及到檔案覆蓋的選項，以免原始檔案受到非使用者的預期影響\n"
				+"\n請問是否要查看說明？(y/n，預設為「是」(y))");
		dataMap.put(1003, "略過本流程...\n");
		dataMap.put(1004, "無效的輸入參數，將直接略過本流程...\n");
		dataMap.put(1005, "以下為使用說明：\n\n1.本工具僅針對編碼進行調整，不涉及內容本身的轉換\n" 
				+ "2.本工具最少需要輸入一項參數(匯入檔案的路徑)作為參數\n"
				+ "3.預設匯入端編碼假設為「MS950」、匯出端編碼預設為「UTF-8」\n"
				+ "4.在匯出檔案時當匯出對象已存在時，預設會以下一點所提到的規則進行命名\n"
				+ "5.自動匯出檔案的檔名之預設格式為原有檔名+編碼格式，如果使用預設格式命名之檔案已存在，會再加入當前時間在檔名最後方\n"
				+ "6.如需指定覆蓋檔案，本工具有提供選項可強制覆蓋\n"
				+ "7.其餘的(匯入檔案的路徑、是否可覆蓋檔案這2項以外)可用參數有：匯出的檔案路徑、匯入的編碼格式、匯出的編碼格式、編碼的轉換模式\n"
				+ "，根據互動式操作會決定最後使用到那些參數(依據使用情境，不見得會用到全部參數)\n"
				+ "8.本工具中單純輸入字母的參數同時支援大小寫，ex.「Y」與「y」在本工具中均被視為相同的\n"
				+ "9.目前僅支援.txt檔案\n"
				+ "10.字串的內容請見「AppString.java」、核心轉換功能請見「Codec_Translator.java」\n"
				+ "11.轉換模式為：\n"
				+ "「1.0」代表「MS950」轉為「UTF-8」\n"
				+ "「2.0」代表「GBK」轉為「UTF-8」\n"
				+ "「3.0」代表「UTF-8」轉為「MS950」\n"
				+ "「4.0」代表「UTF-8」轉為「GBK」\n"
				+ "「5.0」代表「MS950」轉為「GKB」\n"
				+ "「6.0」代表「GBK」轉為「MS950」\n");
		dataMap.put(1006, "現在，可以開始進行操作...\n請先輸入欲匯入的檔案完整路徑：");
		dataMap.put(1007, "沒有輸入任何資訊！請重新輸入！");
		dataMap.put(1008, "匯入檔案路徑正確...");
		dataMap.put(1009, "指定路徑上的檔案不存在！請重新輸入！");
		dataMap.put(1010, "\n是否要指定輸出的檔案路徑？(y/n，預設為「否」(n))");
		dataMap.put(1011, "無效的輸入參數，請重新輸入！\n");
		dataMap.put(1012, "請輸入欲匯出的檔案完整路徑：");
		dataMap.put(1013, "\n請設定當輸出檔案已存在時，是否直接進行覆蓋？(y/n，預設為「否」(n))");
		dataMap.put(1014, "\n請選擇是否要使用轉換模式來進行編碼轉換？(y/n，預設為「否」(n))");
		dataMap.put(1015, "\n請輸入欲使用的轉換模式：(1.0~6.0，預設為「1.0」)");
		dataMap.put(1016, "\n請選擇是否要透過手動輸入編碼名稱來進行編碼轉換？(y/n，預設為「否」(n))");
		dataMap.put(1017, "\n請輸入欲使用的檔案編碼格式：\n1.「MS950」\n2.「GBK」\n3.「UTF-8」\n\n"
				+ "參數間彼此請以「,」隔開，如僅輸入一組將當作輸出格式使用，預設為「(1,3)」");
	}
	
	/*Map中Value的getter*/
	public String getAppString(int key) {
		return dataMap.get(key);
	}
}
