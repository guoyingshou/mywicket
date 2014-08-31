package com.tissue.social;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.form.CheckBoxMultipleChoice;
import org.apache.wicket.markup.html.form.CheckboxMultipleChoiceSelector;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.util.ListModel;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class Form4TestPage extends MyTemplateWithMarkupInheritance {
    private static final long serialVersionUID = 1L;

    private CheckBoxMultipleChoice<String> choices;

    public Form4TestPage() {
        Form<Void> form = new Form<Void>("testForm") {
            private static final long serialVersionUID = 1L;
            
            @Override
            public void onSubmit() {
                System.out.println(choices.getDefaultModelObject());
            }

        };
        add(form);

        List<String> fruits = Arrays.asList("apple", "strawberry", "watermelon");
        choices = new CheckBoxMultipleChoice<String>("checkGroup", new ListModel<String>(new ArrayList<String>()), fruits);
        form.add(choices);

        CheckboxMultipleChoiceSelector selector = new CheckboxMultipleChoiceSelector("select-all", choices);
        form.add(selector);
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
