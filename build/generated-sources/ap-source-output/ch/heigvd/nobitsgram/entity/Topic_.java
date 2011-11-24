package ch.heigvd.nobitsgram.entity;

import ch.heigvd.nobitsgram.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-11-24T17:04:21")
@StaticMetamodel(Topic.class)
public class Topic_ { 

    public static volatile SingularAttribute<Topic, Long> id;
    public static volatile SingularAttribute<Topic, String> name;
    public static volatile ListAttribute<Topic, User> userList;

}