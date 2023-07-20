package groceryManagement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
    	
    	Configuration con=new Configuration().configure().addAnnotatedClass(Order.class);
    	Configuration con1=new Configuration().configure().addAnnotatedClass(OrderItem.class);
    	 SessionFactory sf=con.buildSessionFactory();
    	 Session s=sf.openSession();
    	 Transaction t=s.beginTransaction();
    	 
        // Adding products to the database
        ProductDAO productDAO = new ProductDAO();

        Product product1 = new Product();
        product1.setProductName("Apple");
        product1.setQuantity(100);
        productDAO.saveProduct(product1);

        Product product2 = new Product();
        product2.setProductName("Banana");
        product2.setQuantity(50);
        productDAO.saveProduct(product2);

        // Adding orders to the database
        OrderDAO orderDAO = new OrderDAO();

        Order order1 = new Order();
        orderDAO.saveOrder(order1);

        Order order2 = new Order();
        orderDAO.saveOrder(order2);

        // Adding items to orders
        OrderDAO otd = new OrderDAO();

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setOrder(order1);
        orderItem1.setProduct(product1);
        orderItem1.setQuantity(3);
       otd.saveOrder(order1);
       
       
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setOrder(order1);
        orderItem2.setProduct(product2);
        orderItem2.setQuantity(2);
      otd.saveOrder(order2);
      
      t.commit();
      s.save(orderItem2);
      s.save(orderItem1);
      s.close();
        }
}
