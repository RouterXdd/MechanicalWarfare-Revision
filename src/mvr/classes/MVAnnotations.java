package mvr.classes;

import java.lang.annotation.*;

//Anuke is lazy ass
public class MVAnnotations {
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Load{
        String value();
        int length() default 1;
        int[] lengths() default {};
        String fallback() default "error";
    }
}
