package injects;

import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import java.lang.annotation.Retention;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Messages {}
