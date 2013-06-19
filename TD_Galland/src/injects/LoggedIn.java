package injects;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggedIn {}
