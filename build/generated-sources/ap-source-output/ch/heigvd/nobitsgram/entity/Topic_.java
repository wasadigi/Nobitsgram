package ch.heigvd.nobitsgram.entity;

import ch.heigvd.nobitsgram.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-12-17T04:34:59")
@StaticMetamodel(Topic.class)
public class Topic_ { 

    public static volatile SingularAttribute<Topic, Long> id;
    public static volatile ListAttribute<Topic, User> users;
    public static volatile SingularAttribute<Topic, String> name;

}