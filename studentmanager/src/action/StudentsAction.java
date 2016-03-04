package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import entity.Students;
import service.StudentsDao;
import service.impl.StudentsDaoImpl;

public class StudentsAction extends SuperAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSONObject resultobj;
	
	public JSONObject getResultobj() {
		return resultobj;
	}
	public void setResultobj(JSONObject resultobj) {
		this.resultobj = resultobj;
	}
	public String query() throws IOException{
		StudentsDao dao=new StudentsDaoImpl();
		List<Students> list=dao.queryAllStudents();
		if(list!=null&&list.size()>0){
			HttpSession session =req.getSession();
			session.setAttribute("students_list", list);
		}
		return "query_success";
	}
    //删除
	public String delete(){
		StudentsDao dao=new StudentsDaoImpl();
		String id=req.getParameter("sid");
		dao.deleteStudent(id);
		return "delete_success";
	}
	//修改
	public String modify(){
		StudentsDao dao=new StudentsDaoImpl();
		String sid=req.getParameter("sid");
		Students s=dao.queryStudentById(sid);
		HttpSession session =req.getSession();
		session.setAttribute("modify_students", s);
		System.out.println(s);
		return "modify_success";
		
	}
	public String add() throws ParseException{
		Students s=new Students();
		s.setSname(req.getParameter("sname"));
		s.setGender(req.getParameter("gender"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		s.setBirthday(sdf.parse((req.getParameter("birthday"))));
		s.setAddress(req.getParameter("address"));
		StudentsDao dao=new StudentsDaoImpl();
		dao.addStudent(s);
		return "add_success";
		
	}
	public String save() throws ParseException{
		Students s=new Students();
		s.setSid(req.getParameter("sid"));
		s.setSname(req.getParameter("sname"));
		s.setGender(req.getParameter("gender"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(req.getParameter("birthday")));
		s.setAddress(req.getParameter("address"));
		System.out.println(s);
		StudentsDao dao=new StudentsDaoImpl();
		dao.updateStudents(s);
		return "update_success";
	}
	public String getJson() throws IOException{
		StudentsDao dao=new StudentsDaoImpl();
		List<Students> list=dao.queryAllStudents();
		
//		List list2=new ArrayList();
//		Map<String, Object> map=new HashMap<String, Object>();
//		map.put("sid", 1);
//		map.put("sname", "张三");
//		map.put("gender", "男");
//		map.put("birthday", "2012-1-1");
//		map.put("address", "地球");
//		map.put("status", "删除");
//		Map<String,Object> json=new HashMap<Str ing, Object>();
//		list2.add(map);
//		json.put("rows", list2);
//		json.put("total", list2.size());
//		resultobj=JSONObject.fromObject(list);
		resultobj=new JSONObject();
		resultobj.put("total", list.size());
		resultobj.put("rows", list);
		return "Json";
	}
}
