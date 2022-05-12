
public class Customer {
	private String name;
	private Address addr;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "\nCustomer name:-" + name +" "+ addr ;
	}
	public Customer(String name, Address addr) {
		super();
		this.name = name;
		this.addr = addr;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	

}
