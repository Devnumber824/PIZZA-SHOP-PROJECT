import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Order 
{
    private Customer customer;
    private int id;
    private Pizza[] pizzas;
    private Date dateTime;
    private int billAmount;
    private String date;

    
    public int getId() {
            return id;
    }
    public void setId(int id) {
            this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate() {
        Date Date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        date = formatter.format(Date);
    }
    public Customer getCustomer() {
            return customer;
    }
    public void setCustomer(Customer customer) {
            this.customer = customer;
    }
    public Pizza[] getPizzas() {
            return pizzas;
    }
    public void setPizzas(Pizza[] pizzas) {
            this.pizzas = pizzas;
    }
    public Date getDateTime() {
            return dateTime;
    }
    public void setDateTime(Date dateTime) {
            this.dateTime = dateTime;
    }
    public int getBillAmount() {
            return billAmount;
    }
    public void setBillAmount(int billAmount) {
            this.billAmount = billAmount;
    }
    @Override
    public String toString() {
            return "---------Order Details--------- \nid:-" + id +" " + customer + "\nDate & Time:-"
                            + dateTime + "\n" + Arrays.toString(pizzas) +"\nTotal BillAmount:-" + billAmount +"\n--------------------------------";
    }

}
