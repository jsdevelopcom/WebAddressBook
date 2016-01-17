package models;
import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contact extends Model {

    @Id
    @GeneratedValue
    public Long id;

    public String name;

    public String phone;

    public String email;

    public static Finder<Long, Contact> find = new Finder<>(Contact.class);

}
