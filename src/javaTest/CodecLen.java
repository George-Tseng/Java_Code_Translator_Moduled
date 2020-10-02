package javaTest;

import java.util.HashMap;
import java.util.Map;

public class CodecLen {
	/*用Map存資料*/
	Map<String, Integer> dataMap;
	/*實例*/
	private static CodecLen instance;
	
	public static CodecLen getInstance() {
		/*如果實例不存在才新建*/
		if (instance == null) {
			instance = new CodecLen();
		}
		return instance;
	}
	
	/*建構子*/
	private CodecLen() {
		dataMap = new HashMap<>();
		/*塞入參數資料*/
		dataMap.put("1", 2);
		dataMap.put("2", 2);
		dataMap.put("3", 3);
	}
	
	/*Map中Value的getter*/
	public int getCodecLen(String key) {
		return dataMap.get(key);
	}
}
