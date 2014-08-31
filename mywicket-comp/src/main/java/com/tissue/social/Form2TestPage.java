package com.tissue.social;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class Form2TestPage extends MyTemplateWithMarkupInheritance {
    private static final long serialVersionUID = 1L;

    private List<Person> persons;
    private DropDownChoice<Person> dropDown;

    public Form2TestPage() {
        Form<Person> form = new Form<Person>("testForm") {
            private static final long serialVersionUID = 1L;
            
            @Override
            public void onSubmit() {
                Person p = (Person)dropDown.getModelObject();
                System.out.println(p.getName());
            }

        };
        add(form);

        persons = new ArrayList<Person>();

        Person p = new Person();
        p.setId(1);
        p.setName("guo");
        p.setEmail("guo@gmail.com");
        persons.add(p);

        p = new Person();
        p.setId(2);
        p.setName("liu");
        p.setEmail("liu@gmail.com");
        persons.add(p);
 
        IModel<Person> selected = new Model<Person>();
        selected.setObject(p);

        ChoiceRenderer<Person> renderer = new ChoiceRenderer<Person>("name", "id");
        dropDown = new DropDownChoice<Person>("persons", selected, persons, renderer);
        form.add(dropDown);

    }

    @Override
    public void onInitialize() {
        super.onInitialize();
    }

    public static class Person implements Serializable {
        private static final long serialVersionUID = 1L;
        private Integer id;
        private String name;
        private String email;

        /**
         * @return the id
         */
        public Integer getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(Integer id) {
            this.id = id;
        }

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

}
