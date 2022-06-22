package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class StudentDAOImpl implements StudentDAO {
    Logger logger = Logger.getLogger(StudentDAOImpl.class);

    @Override
    public List<Student> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Student> students = session.createQuery("from Student ").list();
            session.getTransaction().commit();
            return students;
        } catch (HibernateException e) {
            if (tx == null)
                tx.rollback();
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Student getOneById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query<Student> query = session.createQuery("from Student where id=:s_id");
            query.setParameter("s_id", id);
            Student s = query.getSingleResult();
            tx.commit();
            return s;
        } catch (HibernateException e) {
            if (tx == null)
                tx.rollback();
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean save(Student s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(s);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            if (tx == null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }


    @Override
    public boolean delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Student student = session.load(Student.class, id);
            session.delete(student);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            if (tx == null)
                tx.rollback();
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
        return false;
    }


    @Override
    public List<Student> getAllStudentByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query<Student> query = session.createQuery(" from Student where lower(fullName) like :s_name");
            query.setParameter("s_name", "%" + name + "%");
            List<Student> students = query.getResultList();
            return students;
        } catch (HibernateException e) {
            if (tx == null)
                tx.rollback();
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;

    }

    @Override
    public List<Student> getAllStudentByDate(int start, int end) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query<Student> query = session.createQuery(" from Student where to_number(to_char(birthday,'dd')) between :start and :end");
            query.setParameter("start", start);
            query.setParameter("end", end);
            List<Student> students = query.getResultList();
            return students;
        } catch (HibernateException e) {
            if (tx == null)
                tx.rollback();
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;

    }

    @Override
    public List<Student> getAllByGender(String gender) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query<Student> query = session.createQuery(" from Student where lower(gender)= :s_gender");
            query.setParameter("s_gender", gender);
            List<Student> students = query.getResultList();
            return students;
        } catch (HibernateException e) {
            if (tx == null)
                tx.rollback();
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;

    }

    @Override
    public List<Student> getAllByClassName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query<Student> query = session.createQuery(" from Student where lower(className)= :s_cname");
            query.setParameter("s_cname", name);
            List<Student> students = query.getResultList();
            return students;
        } catch (HibernateException e) {
            if (tx == null)
                tx.rollback();
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Student> getAllByMajor(String major) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query<Student> query = session.createQuery(" from Student where lower(major)= :s_major");
            query.setParameter("s_major", major);
            List<Student> students = query.getResultList();
            return students;
        } catch (HibernateException e) {
            if (tx == null)
                tx.rollback();
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Student> getAllByMark(float markBegin, float markEnd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query<Student> query = session.createQuery(" from Student where averageMark between :markBegin and :markEnd");
            query.setParameter("markBegin", markBegin);
            query.setParameter("markEnd", markEnd);
            List<Student> students = query.getResultList();
            return students;
        } catch (HibernateException e) {
            if (tx == null)
                tx.rollback();
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Student> getAllByBirthday() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Student> students = session.createQuery(" from Student where to_char(current_date ,'ddMM')=to_char(birthday,'ddMM')").list();
            session.getTransaction().commit();
            return students;
        } catch (HibernateException e) {
            if (tx == null)
                tx.rollback();
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;
    }
}
