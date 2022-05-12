

import java.util.Arrays;

public class Pizza {
	private int type;
	private String size;
	private Topping[] toppings;
	private int price;
	public int getPrice() {
            int totalToppingPrice=0;
            for(Topping topping : toppings) {
                    totalToppingPrice += topping.getUnitPrice();
            }
            return price+totalToppingPrice;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Pizza() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pizza(int type, String size, Topping[] toppings) {
		super();
		this.type = type;
		this.size = size;
		this.toppings = toppings;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Topping[] getToppings() {
		return toppings;
	}
	public void setToppings(Topping[] toppings) {
		this.toppings = toppings;
	}
	@Override
	public String toString() {
		//if(pizza.type==1)
		return "\n   Pizza type:-" + type + "\n   Pizza size=" + size + "\n   Pizza Toppings=" + Arrays.toString(toppings) + "\n ";
	}
//	@Override
//	public String toString() {
//		return "Pizza [type=" + type + ", size=" + size + ", toppings=" + Arrays.toString(toppings) + ", price=" + price
//				+ "]";
//	}

}
