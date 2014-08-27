package com.tissue.social;

import java.io.Serializable;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.apache.wicket.validation.validator.StringValidator;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class FormTestPage extends MyTemplateWithMarkupInheritance {
    private static final long serialVersionUID = 1L;

    public FormTestPage() {
    }

    @Override
    public void onInitialize() {
        super.onInitialize();
        setupForm();
    }

    private void setupForm() {

        Person person = new Person();
        MyForm form = new MyForm("testForm", person);
        add(form);

    }

    public static class Person implements Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private String email;

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the email
         */
        public String getEmail() {
            return email;
        }

        /**
         * @param email the email to set
         */
        public void setEmail(String email) {
            this.email = email;
        }

    }

    public static class MyForm extends Form<IModel<Person>> {
        private static final long serialVersionUID = 1L;

        private TextField<String> name = null;
        private TextField<String> email = null;
        private Person person;

        public MyForm(String id, Person person) {
            super(id);
            this.person = person;
            setDefaultModel(new CompoundPropertyModel<Person>(person));

            add(new FeedbackPanel("feedbackpanel"));

            name = new TextField<String>("name");
            name.add(StringValidator.minimumLength(10));
            add(name);

            email = new TextField<String>("email");
            email.add(EmailAddressValidator.getInstance());
            add(email);
        }

        @Override
        public void onSubmit() {
            /**
            System.out.println(name.getModelObject());
            System.out.println(email.getModelObject());
            */
            System.out.println(person.getName());
            System.out.println(person.getEmail());
        }
    }

}
