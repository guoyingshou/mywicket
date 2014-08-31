package com.tissue.social;

import java.io.Serializable;

import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.CheckBoxSelector;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;

import com.tissue.social.web.templates.MyTemplateWithMarkupInheritance;

public class Form3TestPage extends MyTemplateWithMarkupInheritance {
    private static final long serialVersionUID = 1L;

    private CheckBox chk1;
    private CheckBox chk2;
    private CheckBox chk3;

    public Form3TestPage() {
        Form<Void> form = new Form<Void>("testForm") {
            private static final long serialVersionUID = 1L;
            
            @Override
            public void onSubmit() {
                System.out.println(chk1.getDefaultModelObject());
                System.out.println(chk2.getDefaultModelObject());
                System.out.println(chk3.getDefaultModelObject());
            }

        };

        chk1 = new CheckBox("chk1", new Model<Boolean>(false));
        form.add(chk1);

        chk2 = new CheckBox("chk2", new Model<Boolean>(false));
        form.add(chk2);

        chk3 = new CheckBox("chk3", new Model<Boolean>(false));
        form.add(chk3);

        add(form);

        CheckBoxSelector selector = new CheckBoxSelector("select", chk1, chk2, chk3);
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
