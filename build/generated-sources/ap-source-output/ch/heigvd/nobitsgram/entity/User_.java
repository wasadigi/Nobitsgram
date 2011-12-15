package ch.heigvd.nobitsgram.entity;

import ch.heigvd.nobitsgram.entity.Topic;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-12-15T10:27:42")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> username_instagram;
    public static volatile SingularAttribute<User, String> acces_token;
    public static volatile SingularAttribute<User, String> lastname;
    public static volatile SingularAttribute<User, String> firstname;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Long> id_Instagram;
    public static volatile SingularAttribute<User, String> country;
    public static volatile SingularAttribute<User, Long> id;
    public static volatile ListAttribute<User, Topic> topics;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, Double> longitude;
    public static volatile SingularAttribute<User, Double> latitude;

}