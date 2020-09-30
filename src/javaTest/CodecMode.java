package javaTest;

import java.util.HashMap;
import java.util.Map;

public class CodecMode {
	/*用Map存資料*/
	Map<String, String> dataMap;
	/*實例*/
	private static CodecMode instance;

	public static CodecMode getInstance() {
		/*如果實例不存在才新建*/
		if (instance == null) {
			instance = new CodecMode();
		}
		return instance;
	}

	/*建構子*/
	private CodecMode() {
		dataMap = new HashMap<>();
		/*塞入參數資料*/
		dataMap.put("1", "MS950");
		dataMap.put("2", "GBK");
		dataMap.put("3", "UTF-8");
	}
	
	/*Map中Value的getter*/
	public String getCodec(String key) {
		return dataMap.get(key);
	}
}