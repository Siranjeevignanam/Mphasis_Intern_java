package org.example;

import java.lang.reflect.RecordComponent;

public class FixedWidthFormatter {
    public static String formatRecord(Object record) {
        StringBuilder sb = new StringBuilder();
        Class<?> clazz = record.getClass();

        for (RecordComponent component : clazz.getRecordComponents()) {
            try {
                FixedWidth width = component.getAnnotation(FixedWidth.class);
                if (width != null) {
                    int size = width.size();
                    Object value = component.getAccessor().invoke(record);
                    String strVal = value == null ? "" : value.toString();

                    if (value instanceof Number) {
                        sb.append(padLeft(strVal, size));
                    } else {
                        sb.append(padRight(strVal, size));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    private static String padRight(String str, int size) {
        return str.length() >= size ? str.substring(0, size) : String.format("%-" + size + "s", str);
    }

    private static String padLeft(String str, int size) {
        return str.length() >= size ? str.substring(0, size) : String.format("%" + size + "s", str);
    }
}
