package br.com.blz.testjava.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.MessageFormat;
import java.util.ResourceBundle;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageExceptionFormatter {

    private static final String ERROR_PROPERTIES = "messages_en";

    public static String getErrorMessage(String code, String message) {
        ResourceBundle bundle = ResourceBundle.getBundle(ERROR_PROPERTIES);
        return MessageFormat.format(bundle.getString(code), message);
    }
}
