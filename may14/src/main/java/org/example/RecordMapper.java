package org.example;
import org.bson.Document;
import java.lang.reflect.Constructor;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;

public class RecordMapper {
    public static <T extends Record> T map(Document doc, Class<T> recordClass) {
        try {
            RecordComponent[] components = recordClass.getRecordComponents();
            Object[] values = new Object[components.length];

            for (int i = 0; i < components.length; i++) {
                String name = components[i].getName();
                Class<?> type = components[i].getType();
                Object value = doc.get(name);

                if (value != null && !type.isAssignableFrom(value.getClass())) {
                    if (type == double.class || type == Double.class) {
                        value = ((Number) value).doubleValue();
                    } else if (type == int.class || type == Integer.class) {
                        value = ((Number) value).intValue();
                    } else if (type == long.class || type == Long.class) {
                        value = ((Number) value).longValue();
                    }
                }

                values[i] = value;
            }

            Constructor<T> constructor = recordClass.getDeclaredConstructor(
                    Arrays.stream(components).map(RecordComponent::getType).toArray(Class[]::new)
            );
            return constructor.newInstance(values);

        } catch (Exception e) {
            throw new RuntimeException("Failed to map Document to Record: " + e.getMessage(), e);
        }
    }
}
