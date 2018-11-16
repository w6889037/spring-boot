package annotation;

import java.lang.annotation.*;

/**
 * Created by xianchun.hu on 4/17/2018.
 */
@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Teacher {

    String value() default "";
}
