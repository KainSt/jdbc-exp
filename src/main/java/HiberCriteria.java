import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class HiberCriteria {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Courses> query = builder.createQuery(Courses.class);
        Root<Courses> root = query.from(Courses.class);
        query.select(root).where(builder.greaterThan(root.get("price"),100000)).orderBy(builder.desc(root.get("price")));
        List<Courses> listCourses = session.createQuery(query).setMaxResults(5).getResultList();
        for (Courses c: listCourses ) {
            System.out.println(c.getName() + " - "  + c.getTeacher().getName() + " - " + c.getPrice() );
        }




        sessionFactory.close();

    }
}
