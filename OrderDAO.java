package groceryManagement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class OrderDAO {
	Configuration con=new Configuration().configure().addAnnotatedClass(Order.class);
	Configuration con1=new Configuration().configure().addAnnotatedClass(OrderItem.class);
	public SessionFactory sf=con.buildSessionFactory();
	
    public void saveOrder(Order order) {
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
            session.save(order);
            t.commit();
   
    }

    public void updateOrder(Order order) {
       
        Session session =sf.openSession();
        Transaction t = session.beginTransaction();
            session.update(order);
            t.commit();
           }

    public void deleteOrder(Order order) {
     
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
            session.delete(order);
            t.commit();
           }
}
