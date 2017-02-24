package starter;

import entity.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Tester {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public static void main(String[] args) {
        Tester t = new Tester();
        t.findAllStudents();
        t.findAllStudentsByFirstName();
        t.findAllStudentsByLastName();
    }

    public void findAllStudents() {
        EntityManager em = getManager();
        try {
            em.getTransaction().begin();

            Query q1 = em.createNamedQuery("Student.findAll");
            List<Student> sList = q1.getResultList();
            for (Student student : sList) {
                System.out.println(student);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void findAllStudentsByFirstName() {
        EntityManager em = getManager();
        try {
            em.getTransaction().begin();

            Query q1 = em.createNamedQuery("Student.findByFirstname");
            q1.setParameter("firstname", "jan");
            List<Student> sList = q1.getResultList();
            for (Student student : sList) {
                System.out.println(student);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void findAllStudentsByLastName() {
        EntityManager em = getManager();
        try {
            em.getTransaction().begin();

            Query q1 = em.createNamedQuery("Student.findByLastname");
            q1.setParameter("lastname", "olsen");
            List<Student> sList = q1.getResultList();
            for (Student student : sList) {
                System.out.println(student);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
//
//    public void findTotalStudyPointsForStudent() {
//        EntityManager em = getManager();
//        try {
//            em.getTransaction().begin();
//
//            Query q1 = em.createQuery("SELECT ABS(s.score) FROM Studypoint s WHERE s.id = :id GROUP BY s.score");
//            q1.setParameter("id", "1");
//            List<Studypoint> sList = q1.getResultList();
//            for (Studypoint sp : sList) {
//                System.out.println(sp);
//            }
//
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//        } finally {
//            em.close();
//        }
//    }

    private EntityManager getManager() {
        return emf.createEntityManager();
    }
}
