import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;


public class HiberTrans {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

      Transaction transaction = session.beginTransaction();
       Courses course = session.get(Courses.class, 1);
         /*
        course.setName("Умелая продажа всего");
        course.setId(47);
        course.setTeacherId(2);
        course.setType(CourseType.MARKETING);
        session.save(course);*/

        System.out.println(course.getTeacher().getName());
        course.getStudentList().forEach(student-> System.out.println(student.getName()));


        transaction.commit();
        sessionFactory.close();

    }
}
