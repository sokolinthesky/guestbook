package com.gusetbook.dao;

import com.gusetbook.beans.GuestBean;
import com.gusetbook.dao.model.GuestDao;
import com.gusetbook.dao.converters.GuestModelToGuest;
import com.gusetbook.dao.converters.GuestToGuestModel;
import com.gusetbook.dao.model.GuestModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class GuestDaoImpl implements GuestDao{

    private final SessionFactory factory;

    public GuestDaoImpl() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void addGuest(GuestBean guestBean) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(GuestToGuestModel.convert(guestBean));
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public List<GuestBean> allGuests() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            List<GuestModel> guestModels = session.createQuery("from GuestModel").list();
            List<GuestBean> beans = new ArrayList<GuestBean>();

            for(GuestModel model : guestModels) {
                beans.add(GuestModelToGuest.convert(model));
            }

            return beans;
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void editGuest(GuestBean guestBean) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.saveOrUpdate(GuestToGuestModel.convert(guestBean));
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void removeGuest(GuestBean guestBean) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(GuestToGuestModel.convert(guestBean));
        } finally {
            tx.commit();
            session.close();
        }
    }
}
