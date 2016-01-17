package controllers;

import models.Contact;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.list;
import views.html.newContact;
import views.html.show;

import java.util.List;

import static play.data.Form.form;

public class Web extends Controller {

    public Result list() {
        List<Contact> contacts = Contact.find.all();
        return ok(list.render(contacts));
    }

    public Result show(Long id) {
        Contact contact = Contact.find.byId(id);
        if (contact == null) {
            return notFound("No contacts in DB for id: " + id);
        } else {
            return ok(show.render(contact));
        }
    }

    public Result newContact() {
        Form<Contact> contactForm = form(Contact.class);
        return ok(newContact.render(contactForm));
    }

    public Result createContact() {
        Form<Contact> contactForm = form(Contact.class).bindFromRequest();
        Contact contact = contactForm.get();
        contact.save();
        return redirect(routes.Web.list());
    }


}
