package daoBean;

import java.util.ArrayList;
import java.util.List;

public class Duration {
	
	private int id;
	
	private String D_Category;
	
	private List<Duration> items = new ArrayList<Duration>();
	
	public int getId(){
		return id;
	}
	
	public String getCategory(){
		return D_Category;
	}
	
	public List<Duration> getItems() {
		return items;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String setCategory(String D_Category){
		return this.D_Category = D_Category;
	}
	
	public void setItems(List<Duration> items){
		this.items = items;
	}
	
}
