package mu.vlad.junior.stream_API.hw_4.models;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Program {

//    private static Session getSession() {
//        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .configure()
//                .build();
//        SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
//        return factory.openSession();
//    }

    public static void main(String[] args) {

        Courses course = new Courses("Java-developer", 12);
        System.out.println(createCourse(course));
        System.out.println(getCourse(1));
        System.out.println(updateCourse(1, 24));
        System.out.println(deleteCourse(1));

    }

    private static Courses createCourse(Courses newCourse) {

        Session session = getSession();

        session.beginTransaction();

        session.save(newCourse);

        session.getTransaction().commit();

        return newCourse;
    }

    private static Courses getCourse(int id) {

        Session session = getSession();

        session.beginTransaction();

        Courses courses = session.get(Courses.class, id);

        session.getTransaction().commit();

        return courses;
    }

    private static Courses updateCourse(int id, int duration) {

        Courses updatedCourses = getCourse(id);

        Session session = getSession();

        session.beginTransaction();

        updatedCourses.setDuration(duration);

        session.update(updatedCourses);

        session.getTransaction().commit();

        return updatedCourses;

    }

    private static Boolean deleteCourse(int id) {
        Courses course = getCourse(id);

        Session session = getSession();

        session.beginTransaction();

        session.delete(course);

        session.getTransaction().commit();

        return true;
    }

    private static Session getSession() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Courses.class)
                .buildSessionFactory();
        return factory.openSession();
    }
}

