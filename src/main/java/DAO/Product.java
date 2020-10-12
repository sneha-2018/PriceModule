package DAO;

import java.util.Date;

public class Product {
	private  Date date;
	private  Cycle cycle;

	public Product() {
	}

	public Product(Date date, Cycle cycle) {
		this.date = date;
		this.cycle = cycle;
	}

	public Date getDate() {
		return date;
	}

	public Cycle getCycle() {
		return cycle;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}
	
	
}
