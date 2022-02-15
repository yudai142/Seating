package com.dd_career.seating;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;

import java.util.ArrayList;
import java.util.List;

public class UserRecord {
    private static final int DEFAULT_VALUE = 0;
    private static final String ID_ATTRIBUTE_NAME = "id";
    private static final String NAME_ATTRIBUTE_NAME = "name";
    private static final String NAMESPACE = "http://schemas.android.com/apk/res-auto";
    private static final String ELEMENT_NAME = "user";

    private int id;
    private String name;

    public UserRecord() {
    }

    public static UserRecord[] getDemoRecords(Resources resources) throws Exception {
        List<UserRecord> users = new ArrayList<>();
        XmlResourceParser parser = resources.getXml(R.xml.demo_users);
        int eventType = parser.next();

        while (eventType != XmlResourceParser.END_DOCUMENT) {
            if (eventType == XmlResourceParser.START_TAG) {
                if (parser.getName().equals(ELEMENT_NAME)) {
                    UserRecord user = new UserRecord();
                    user.id = parser.getAttributeResourceValue(NAMESPACE, ID_ATTRIBUTE_NAME, DEFAULT_VALUE);
                    user.name = parser.getAttributeValue(NAMESPACE, NAME_ATTRIBUTE_NAME);
                    users.add(user);
                }
            }

            eventType = parser.next();
        }

        UserRecord[] results = new UserRecord[users.size()];
        users.toArray(results);
        return results;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
