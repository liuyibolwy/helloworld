package com.ricebook.resource;

import com.ricebook.model.User;
import com.ricebook.model.UserCache;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by liuyb on 16/12/26.
 */
@Path("/user")
public class UserResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> queryAll(){
        UserCache userCache=new UserCache();
        userCache.init();
        List<User> res=userCache.queryUser();
        System.out.println(res);
        return res;
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User query(@PathParam("id") String id){
        UserCache userCache=new UserCache();
        userCache.init();
        User user=userCache.queryUser(id);
        return user;
    }
    @GET

    @Produces(MediaType.APPLICATION_JSON)
    public User query(@MatrixParam("username") String username,@MatrixParam("password") String password){
        UserCache userCache=new UserCache();
        userCache.init();
        return userCache.queryUser(username,password);
    }
}
