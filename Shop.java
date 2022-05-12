

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.*;

public class Shop {
    private static int id;
    Scanner sc = new Scanner(System.in);
    private static List<Order> orders = new ArrayList();
    public int placeOrder(Pizza[] pizzas,Customer customer){
        int billAmount =0;
        for(Pizza p: pizzas) {
                billAmount += p.getPrice();
        }
        //Create Order Object 
        Order order = new Order();
        order.setId(++id);
        order.setPizzas(pizzas);
        order.setCustomer(customer);
        order.setDateTime(new Date());
        order.setDate();
        order.setBillAmount(billAmount);
        orders.add(order);
        return order.getId();
    }
    public String cancelOrder(int id) 
    {
        Order order = searchOrder(id);
        if(order!=null) 
        {
            System.out.println(order.toString());
            System.out.println("Please confirm you want to cancel above order then Press y else n");
            String ch = sc.nextLine();
            if("y".equals(ch)||"Y".equals(ch))
            {
                orders.remove(order);
                return "Order Cancel Successfully!";
            } 
            else
                return "Order not cancel!";
        }
        else 
        {
            return "No ORDER FOUND TO CANCEL ";
        }
    }
    public String showOrder(int orderId)
    {
        Order order = searchOrder(orderId);
        if(order!=null) 
        {
                return order.toString();
        }
        else 
        {
            return "No ORDER FOUND ";
        }
    }
    private Order searchOrder(int orderId) 
    {
        for(Order order: orders) {
            int id = order.getId();
            if(orderId==id) {
                return order;
            }
        }
        return null;
    }
    public String showOrderbyDate(String Date)
    {
        int flag=0;
        for(Order order: orders) {
            String date1 = order.getDate();
            if(Date.equals(date1)) {
                System.out.println(order.toString());
                flag=1;
            }
        }
        if(flag==1)
            return "Todays all Orders";
        else
            return "There is no order today";
    }
}
