package daoBean;

import java.util.ArrayList;
import java.util.List;

public class MentalStatus_Category {
	
	private int id;
	
	private String category;
	
	private List<MentalStatus_Problems> items = new ArrayList<MentalStatus_Problems>();

	public int getId() {
		return id;
	} 

	public String getCategory() {
		return category;
	}
	
	public List<MentalStatus_Problems> getItems() {
		return items;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public void setItems(List<MentalStatus_Problems> items) {
		this.items = items;
	}
}

