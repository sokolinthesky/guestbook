package com.gusetbook.dao.converters;

import com.gusetbook.beans.GuestBean;
import com.gusetbook.dao.model.GuestModel;

public class GuestToGuestModel {

    public static GuestModel convert(GuestBean guestBean) {

        return new GuestModel(guestBean.getId(), guestBean.getFistName(), guestBean.getSecondName(), guestBean.getPhoneNumber());
    }
}
