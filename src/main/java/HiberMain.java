import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class HiberMain {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();




        List<Courses> rows =  session.createSQLQuery("select * from courses where students_count >= 0")
                .addEntity(Courses.class)
                .list();

        for (Courses row:rows) {
            System.out.println(row.getName() + " - " +row.getStudentsCount() + " студентов на курсе.");

        }


        System.out.println();
        sessionFactory.close();
    }
}
