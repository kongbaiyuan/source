package controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.ReturnInfo;
import model.Book;
import model.Type;
import service.Book_Service;
import service.Type_Service;

@Controller
@RequestMapping("Book")
public class BookController {
	@Autowired
	Book_Service tservice;
	@Autowired
	Type_Service service;

	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}


	@RequestMapping("sss")
	public  @ResponseBody String aaa(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest req )throws Exception {
	String oname=file.getOriginalFilename();
	String ex=oname.substring(oname.lastIndexOf("."),oname.length());
	String nname = UUID.randomUUID()+ex;

	String path=req.getSession().getServletContext().getRealPath("/");
	path=new File(path).getParentFile().getPath()+"/upload";
	System.out.println(path);
	file.transferTo(new File(path,nname));
	return "/upload/"+nname;
	
	}
	
	
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,ModelMap m,Integer page,Integer limit) {
		// 查询时reload向后台传TXT参数
		
		if (txt != null && txt.length() > 0)
			txt = " where book.name like '%" + txt + "%'";
		else
			txt = "";
		// 上级类定义了page和limit,这两个值是前端转过来的
		
		return tservice.select(txt, page, limit);
	}
	
//	 @RequestMapping("add")
//	 public String add(ModelMap m) {
//	tservice.in
//	 return "Book/edit";
//	 }
	
	 @RequestMapping("edit")
	 public @ResponseBody Book edit(int id,ModelMap m) {
	
	 return tservice.selectById(id);
	 }
	
	 @RequestMapping("insert")
	 public @ResponseBody String insert(Book b,ModelMap m) {
	 tservice.insert(b);
	 return "{\"status\":1}";
	 }
	@RequestMapping("getSexs")
	 public @ResponseBody String[] getSexs(ModelMap m) {
			return Book.sexs;
		}
	@RequestMapping("getTypes")
	 public @ResponseBody List<Type> getTypes(ModelMap m) {
			return service.selectfor();
		}
		
	 @RequestMapping("update")
	 public @ResponseBody String update(Book b,ModelMap m) {
	 tservice.update(b);
	 
	 return "{\"status\":1}";
	 }
	 @RequestMapping("delete")
	 public @ResponseBody String delete(int id,ModelMap m) {
	 tservice.delete(id);
	 return "{\"status\":1}";
	 }

}
