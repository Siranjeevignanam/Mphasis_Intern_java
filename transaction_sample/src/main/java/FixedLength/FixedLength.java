package FixedLength;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.RECORD_COMPONENT)  // annotation target on record components
public @interface FixedLength {
    int value();
}
