package com.zgk.jdk.thread3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * 常见线程安全的类与非线程安全的类，及非线程安全的类怎么转换成线程安全的类
 * 
 */
public class ThreadSync2 {

	public static void main(String[] args) {
		
		//ArrayList 是非线程安全的类
		List list = new ArrayList();
		
		list.add("111");
		
		//Vector是线程安全的类
		Vector v = new Vector();
		v.add("aaa");
		
		//转换成线程安全的类
		List syncList = Collections.synchronizedList(list);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("1", "a");
		
		
		 
	}
}
