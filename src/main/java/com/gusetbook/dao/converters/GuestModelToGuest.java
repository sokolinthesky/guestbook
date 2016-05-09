package com.gusetbook.dao.converters;

import com.gusetbook.beans.GuestBean;
import com.gusetbook.dao.model.GuestModel;

public class GuestModelToGuest {

    public static GuestBean convert(GuestModel model) {
        return new GuestBean(model.getId(), model.getFistName(), model.getSecondName(), model.getPhoneNumber());
    }
}
