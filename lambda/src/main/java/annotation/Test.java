package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by xianchun.hu on 4/17/2018.
 */
public class Test {
   public static void main(String[] args){
       Student annotation = Person.class.getAnnotation(Student.class);
       System.out.println(annotation.value());

       Field[] declaredFields = Person.class.getDeclaredFields();
       for (Field declaredField : declaredFields) {
           System.out.println(declaredField.getType() + ":" + declaredField.getName());
           Annotation[] declaredAnnotations = declaredField.getDeclaredAnnotations();
           for (Annotation declaredAnnotation : declaredAnnotations) {
               if(declaredAnnotation instanceof Student){
                   Student declaredAnnotation1 = (Student) declaredAnnotation;
                   String value = declaredAnnotation1.value();
                   System.out.println(value);
               }
               if(declaredAnnotation instanceof Teacher){
                   Teacher declaredAnnotation1 = (Teacher) declaredAnnotation;
                   String value = declaredAnnotation1.value();
                   System.out.println(value);
               }
           }
           if(declaredField.isAnnotationPresent(Student.class)){
               Student annotation1 = declaredField.getAnnotation(Student.class);
               String value = annotation1.value();
               System.out.println(value);
           }
           if(declaredField.isAnnotationPresent(Teacher.class)){
               Teacher annotation1 = declaredField.getAnnotation(Teacher.class);
               String value = annotation1.value();
               System.out.println(value);
           }
       }

       System.out.println(20/3);
   }
}
