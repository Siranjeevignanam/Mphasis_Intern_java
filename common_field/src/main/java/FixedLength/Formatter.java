package FixedLength;

import java.lang.reflect.RecordComponent;

public class Formatter {
    public static String formatRecord(Record record) {
        StringBuilder sb = new StringBuilder();
        Class<?> rcClass = record.getClass();

        RecordComponent[] components = rcClass.getRecordComponents();

        for (int i = 0; i < components.length; i++) {
            RecordComponent rc = components[i];
            Object value;
            try {
                value = rc.getAccessor().invoke(record);
            } catch (Exception e) {
                value = "";
            }
            int len = 20;  // default length if annotation missing

            FixedLength fl = rc.getAnnotation(FixedLength.class);
            if (fl != null) {
                len = fl.value();
            }

            String strVal;
            if (value == null) {
                strVal = "";
            } else if (value instanceof Double) {
                // format double with 2 decimals
                strVal = String.format("%.2f", (Double) value);
            } else {
                strVal = value.toString();
            }

            // Pad or truncate to fixed length
            if (strVal.length() > len) {
                strVal = strVal.substring(0, len);
            } else {
                strVal = String.format("%-" + len + "s", strVal);
            }

            sb.append(strVal);
        }
        return sb.toString();
    }
}
