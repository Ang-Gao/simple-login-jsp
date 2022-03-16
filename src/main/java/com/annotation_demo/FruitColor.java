package com.annotation_demo;

import java.awt.*;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FruitColor {
    public enum Color{BLUE,RED,GREEN}
    Color fruitColor() default Color.GREEN;
}
