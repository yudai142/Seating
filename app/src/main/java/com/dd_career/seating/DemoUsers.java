package com.dd_career.seating;

import android.content.Context;
import android.content.res.XmlResourceParser;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class DemoUsers extends Users {
    public DemoUsers(Context context) throws IOException, XmlPullParserException {
        try (XmlResourceParser parser = context.getResources().getXml(R.xml.demo_users)) {
            while (parser.getEventType() != XmlResourceParser.END_DOCUMENT) {
                if ((parser.getEventType() == XmlResourceParser.START_TAG) && (parser.getName().equals(User.ELEMENT))) {
                    User user = new User();
                    user.loadXml(parser);
                    set(user);
                }

                parser.next();
            }
        }
    }
}
