package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.StudentsDao;
import service.impl.StudentsDaoImpl;
import entity.Students;

public class test {
       public static void main(String[] args) {
    	   List list2=new ArrayList();
   		Map<String, Object> map=new HashMap<String, Object>();
   		map.put("sid", 1);
   		map.put("sname", "张三");
   		map.put("gender", "男");
   		map.put("birthday", "2012-1-1");
   		map.put("address", "地球");
   		map.put("status", "删除");
   		Map<String,Object> json=new HashMap<String, Object>();
   		list2.add(map);
   		json.put("rows", list2);
   		json.put("total", list2.size());
   		JSONArray o=JSONArray.fromObject(json);
   		String jsonString=o.toString();
   		System.out.println(jsonString);
	}
}
