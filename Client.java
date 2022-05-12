import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Client 
{
    private static Scanner sc = new Scanner(System.in);
    private static Shop shop = new Shop();
    private static Menu menu = new Menu();
    public static void main(String[] args) 
    {
        showMenu();
    }

    private static void showMenu() 
    {
        while(true) 
        {
            System.out.println("\n1 Show Menu Card");
            System.out.println("2 Place Order");
            System.out.println("3 Cancel Order");
            System.out.println("4 Show Order");
            System.out.println("5 Show Order by a given date");
            int choice = sc.nextInt();
            switch(choice) 
            {
                case 1 : menu.menuCard();
                        break;
                case 2 : placeOrder(); 
                        break;
                case 3 : cancelOrder(); 
                        break;
                case 4 : showOrder(); 
                        break;
                case 5 : showOrderbyDate();
                        break;
                default : System.out.println("Wrong Choice");
            }
        }
    }
    private static void placeOrder() 
    {
        System.out.println("Enter your name");
        String name = new Scanner(System.in).nextLine();
        System.out.println("My I know your country ?");
        String country = sc.next();
        System.out.println("May I know your city ?");
        String city = sc.next();
        System.out.println("May I know your pin code ?");
        int pin = sc.nextInt();
        System.out.println("May I know your lane/locality ?");
        String addrLine = new Scanner(System.in).nextLine();
        Customer customer = new Customer();
        Address addr = new Address();
        addr.setCountry(country);
        addr.setCity(city);
        addr.setPin(pin);
        addr.setAddrLine(addrLine);
        customer.setAddr(addr);
        customer.setName(name);
        //Take all inputs from user
        //Create pizzas
        System.out.println("How many Pizzas");
        int no1 = sc.nextInt();

        Pizza[] pizzas = new Pizza[no1];//blank array of size 'no'
        for(int i=0; i < no1; i++) 
        {
                Pizza p = new Pizza();
                pizzas[i] = p;
                System.out.println("What Type of Pizza you want ?");
                int type = chooseCategories();
                p.setType(type);
                System.out.println("What size ?");
                String size = chooseSize();
                p.setSize(size);
                Topping[] toppings = chooseToppings();
                p.setToppings(toppings);
                int basePrice = getPrice(size);
                p.setPrice(basePrice);

        }
        //create 

        int orderId = shop.placeOrder(pizzas, customer);
        System.out.println("Thank you for placeing order Id is "+orderId);
    }
    private static int getPrice(String size) 
    {
        switch(size) 
        {
            case "SMALL" : return PriceList.SMALL_PIZZA_PRICE; 
            case "MEDIUM" : return PriceList.MEDIUM_PIZZA_PRICE; 
            case "LARGE" : return PriceList.LARGE_PIZZA_PRICE; 
            default : return 0;
        }
    }
    private static Topping[] chooseToppings() 
    {
        System.out.println("How Many Toppings ?");
        int noOfToppings = sc.nextInt();
        Topping[] toppings = new Topping[noOfToppings];
        for(int i=0; i< noOfToppings; i++) 
        {
                Topping topping = new Topping();
                topping.setUnitPrice(PriceList.TOPPINGS_BASE_PRICE);
                System.out.println("Which Toppings you want ?");
                System.out.println("\nOlives\nExtra Cheese\nOnion\nTomatoes\nPineapples");
                String name = new Scanner(System.in).nextLine();
                topping.setName(name);
                toppings[i] = topping;
        }
        return toppings;
    }
    private static String chooseSize() 
    {
        while(true) 
        {
            System.out.println("1 LARGE");
            System.out.println("2 MEDIUM");
            System.out.println("3 SMALL");
            int choice = sc.nextInt();
            switch(choice) 
            {
                case 1 : return "LARGE";
                case 2 : return "MEDIUM";
                case 3 : return "SMALL";
                default : System.out.println("Wrong choice");
            }
        }
    }
    private static int chooseCategories() {
        while(true) 
        {
            System.out.println("1 VEG");
            System.out.println("2 NON VEG");
            int choice = sc.nextInt();
            switch(choice) 
            {
                case 1 : return choice;
                case 2 : return choice;
                default : System.out.println("Wrong choice");
            }
        }
    }
    private static void showOrder() 
    {
        System.out.println("Enter Order Id ");
        int id = sc.nextInt();
        String orderDetails = shop.showOrder(id);
        System.out.println(orderDetails);

    }
    private static void cancelOrder() 
    {
        System.out.println("Enter Order Id ");
        int id = sc.nextInt();
        System.out.println(shop.cancelOrder(id));
    }
    private static void showOrderbyDate()
    {
        Date Date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String date = formatter.format(Date);
        System.out.println(shop.showOrderbyDate(date));
    }
}