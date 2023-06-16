package org.mipt.maytime.laborday.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that test class use other packages
 *
 * @author Vronskii Alexander
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MaytimeTestSources {
    /**
     * Additional sources
     * @return array of additional sources
     */
    String[] include();
}
