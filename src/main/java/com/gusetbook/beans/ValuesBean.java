package com.gusetbook.beans;

import com.gusetbook.dao.model.GuestDao;
import com.gusetbook.dao.GuestDaoImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ValuesBean implements Serializable {

    private List<GuestBean> guestBeanList = new ArrayList<GuestBean>();
    public GuestDao guestDao = new GuestDaoImpl();
    private String editGuestId;

    public List<GuestBean> getGuestBeanList() {
        guestBeanList = guestDao.allGuests();

        return this.guestBeanList;
    }

    public String addGuest(GuestBean guest) {
        guestDao.addGuest(guest);

        return "faces/index?faces-redirect=true";
    }

    public String deleteGuest(GuestBean guestBean) {
        guestDao.removeGuest(guestBean);

        return "faces/index?faces-redirect=true";
    }

    public String saveAction() {

        //get all existing value but set "editable" to false
        for (GuestBean guestBean : this.guestBeanList){
            guestBean.setEditable(false);
        }

        guestDao.editGuest(this.guestBeanList.get(Integer.parseInt(editGuestId)));

        //return to current page
        return null;

    }

    public String editAction(GuestBean guestBean) {
        editGuestId = guestBean.getId();

        guestBean.setEditable(true);
        return null;
    }
}
