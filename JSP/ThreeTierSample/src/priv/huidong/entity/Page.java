package priv.huidong.entity;

import java.util.List;

public class Page {

	//当前页】
	private int currentPage;
	//页面大小
	private int PageSize;
	//总数居
	private int totalCount;
	//总页数
	private int totalPage;
	//当前页的数据集合
	private List<Student> student;
	public Page() {}
	public Page(int currentPage, int pageSize, int totalCount, int totalPage, List<Student> student) {
		//super();
		this.currentPage = currentPage;
		this.PageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.student = student;
	}
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return PageSize;
	}
	public void setPageSize(int pageSize) {
		this.PageSize = pageSize;
		this.totalPage=this.totalCount%this.PageSize==0?this.totalCount/this.PageSize:this.totalCount/this.PageSize+1;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
}
