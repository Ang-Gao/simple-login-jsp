package com.annotation_demo;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz){
        String fruitName = null;
        String fruitColor = null;
        String fruitProviderName = null;
        //Class clazz;
        Field[] fields = clazz.getDeclaredFields();

        for(Field field: fields){
            //System.out.println(field.toString());
            //isAnnotationPresent给field用，直接给class用就是false
            if (field.isAnnotationPresent((FruitName.class))){
                FruitName fruitName1 =  field.getAnnotation(FruitName.class);
                fruitName = fruitName1.name();
                System.out.println(fruitName);
            }
            if (field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor1 = field.getAnnotation(FruitColor.class);
                fruitColor = fruitColor1.fruitColor().toString();
                System.out.println(fruitColor);
            }
            if (field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                fruitProviderName = fruitProvider.name();
                System.out.println(fruitProviderName);
            }

        }

    }
}
