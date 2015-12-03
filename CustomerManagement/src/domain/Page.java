package domain;

import java.util.List;

//用来封装分页数据
public class Page {
	
	private List<Customer> list;
	private int totalPage; //记录总页数
	private int totalRecord; //记录总记录数，要从数据库那边获取到
	private int pageSize = 5; //设置每页显示5条信息
	private int pageNum; //表示用户想看的页
	private int startIndex; //代表用户想看的页的数据从数据库的哪个地方开始取
	
	private int startPage; //记住jsp页面显示的起始页码
	private int endPage; //记住jsp页面显示的结束页码
	
	private String url; // 记录用于处理分页的servlet
	
	public Page(int totalRecord, int pageNum){
		this.totalRecord = totalRecord;
		this.pageNum = pageNum;
		
		//计算总页数
		if(this.totalRecord % this.pageSize == 0){
			this.totalPage = this.totalRecord / this.pageSize;
		} else {
			this.totalPage = this.totalRecord / this.pageSize + 1;
		}
		
		//计算用户想看的页的数据从数据库哪个地方开始取
		this.startIndex = (this.pageNum - 1) * this.pageSize;
		
		//根据用户想看的页，计算jsp显示的起始页码和结束页码。这里程序写成显示出5个页码
		if(this.totalPage <= 6){
			this.startPage = 1;
			this.endPage = this.totalPage;
		} else {
			this.startPage = this.pageNum - 2;
			this.endPage = this.pageNum + 3;
			
			if(this.startPage < 1){
				this.startPage = 1;
				this.endPage = 6;
			}
			
			if(this.endPage > this.totalPage){
				this.endPage = this.totalPage;
				this.startPage = this.totalPage - 5;
			}
		}	
	}

	public List<Customer> getList() {
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
