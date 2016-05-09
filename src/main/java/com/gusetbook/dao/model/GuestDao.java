package com.gusetbook.dao.model;

import com.gusetbook.beans.GuestBean;

import java.util.List;

public interface GuestDao {
     public void addGuest(GuestBean guestBean);
     public List<GuestBean> allGuests();
     public void editGuest(GuestBean guestBean);
     public void removeGuest(GuestBean guestBean);
}
