package com.example.JMobile.framework.Enums;

import com.example.JMobile.framework.environment.PropertyValues;
import org.apache.commons.lang3.NotImplementedException;


public class MsgFactory {

    private MsgFactory() {
    }

    public static String getMessage(Messages msg) {
        String returnMsg = null;
        switch (PropertyValues.locale) {
            case EN:
                returnMsg = msg.getEN();
                break;

            case RU:
                returnMsg = msg.getRU();
                break;

            default:
                throw new NotImplementedException();

        }
        return returnMsg;
    }

    public static String getMessage(Titles msg) {
        String returnMsg = null;
        switch (PropertyValues.locale) {
            case EN:
                returnMsg = msg.getEN();
                break;

            case RU:
                returnMsg = msg.getRU();
                break;

            default:
                throw new NotImplementedException();

        }
        return returnMsg;
    }
}

