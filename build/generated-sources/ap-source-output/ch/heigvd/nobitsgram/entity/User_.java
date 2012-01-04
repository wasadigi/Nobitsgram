package ch.heigvd.nobitsgram.entity;

import ch.heigvd.nobitsgram.entity.Topic;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-01-04T19:43:03")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> username_instagram;
    public static volatile SingularAttribute<User, Integer> countMonthSearch;
    public static volatile SingularAttribute<User, String> street;
    public static volatile SingularAttribute<User, String> lastname;
    public static volatile SingularAttribute<User, String> id_Instagram;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> city;
    public static volatile SingularAttribute<User, Long> id;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, Calendar> lastDateConnection;
    public static volatile SingularAttribute<User, Calendar> lastDateSearch;
    public static volatile SingularAttribute<User, Integer> countMonthConnection;
    public static volatile SingularAttribute<User, String> zipCode;
    public static volatile SingularAttribute<User, String> streetNumber;
    public static volatile SingularAttribute<User, Double> longitude;
    public static volatile SingularAttribute<User, Calendar> createDate;
    public static volatile SingularAttribute<User, Boolean> zoomOut;
    public static volatile SingularAttribute<User, String> profile_picture;
    public static volatile SingularAttribute<User, String> acces_token;
    public static volatile SingularAttribute<User, String> firstname;
    public static volatile SingularAttribute<User, Boolean> isConnect;
    public static volatile SingularAttribute<User, Boolean> isBlocked;
    public static volatile SingularAttribute<User, String> country;
    public static volatile ListAttribute<User, Topic> topics;
    public static volatile SingularAttribute<User, Long> countSearch;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, Double> latitude;
    public static volatile SingularAttribute<User, Long> countConnection;

}