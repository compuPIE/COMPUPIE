package daoBean;
import java.util.ArrayList;
import java.util.List;

public class Severity {

	private int id;
	
	private String S_Category;
	
	private List<Severity> items = new ArrayList<Severity>();
	
	public int getId(){
		return id;
	}
	
	public String getCategory(){
		return S_Category;
	}
	
	public List<Severity> getItems() {
		return items;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String setCategory(String S_Category){
		return this.S_Category = S_Category;
	}
	
	public void setItems(List<Severity> items){
		this.items = items;
	}
	
}
