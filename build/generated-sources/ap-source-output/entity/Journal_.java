package entity;

import entity.Book;
import entity.Person;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-01T15:15:54")
@StaticMetamodel(Journal.class)
public class Journal_ { 

    public static volatile SingularAttribute<Journal, Date> date;
    public static volatile SingularAttribute<Journal, Person> student;
    public static volatile SingularAttribute<Journal, Book> subject;
    public static volatile SingularAttribute<Journal, Integer> mark;

}