package com.ricebook.main;

import java.util.HashSet;
import java.util.Set;
import com.ricebook.resource.UserResource;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Created by liuyb on 16/12/26.
 */
@ApplicationPath("/")
public class MyApplication extends Application{
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        // register root resource
        classes.add(UserResource.class);
        return classes;
    }
}
