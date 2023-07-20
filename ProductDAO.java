package groceryManagement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDAO {
	Configuration con=new Configuration().configure().addAnnotatedClass(Product.class);
	public SessionFactory sf=con.buildSessionFactory();

    public void saveProduct(Product product) {
        Transaction transaction = null;
        	Session session = sf.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        
    }

    public void updateProduct(Product product) {
        Transaction transaction = null;
        Session session = sf.openSession();
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
       
    }

    public void deleteProduct(Product product) {
        Transaction transaction = null;
        Session session =sf.openSession();
            transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();
    }

}
