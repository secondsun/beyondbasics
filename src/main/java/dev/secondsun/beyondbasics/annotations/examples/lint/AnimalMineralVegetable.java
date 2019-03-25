package dev.secondsun.beyondbasics.annotations.examples.lint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
/**
 * Tells if a method returns an animal mineral or vegetable
 */
public @interface AnimalMineralVegetable {
    /**
     * The name of the properties file with animal mineral and vegetable
     */
    String value();
}
