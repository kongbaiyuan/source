package service;

import java.util.List;

import dao.BookDao;
import dao.DbHelper;
import model.Book;
import utils.ReturnInfo;

public class BookService {
	BookDao dao=new BookDao();
	//为了方便.做了一个returninfo类
	//page可能传,也可能不传,所以用integer类型
	public ReturnInfo select(String where,Integer page,Integer max) {
		boolean canpage=page!=null;//判断是否换页
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.select(where));
		  return info;
	}
	//一种优化,加上limit 1 不用从头到尾查了
	public Book selectByid(int id) {
		return  (Book) dao.select(" where book.id="+id," limit 1").get(0);
	}
	
	public int insert(Book b) {
		return dao.insert(b);
	}
	public int update(Book b) {
		return dao.update(b);
	}
	public int delete(Book b) {
		return dao.delete(b);
	}
}
