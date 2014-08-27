package com.tissue.social;

import org.apache.wicket.MetaDataEntry;
import org.apache.wicket.MetaDataKey;
import org.apache.wicket.model.ChainingModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.junit.Test;

public class MetadataKeyTest {

    class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
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
         * @return the age
         */
        public int getAge() {
            return age;
        }

        /**
         * @param age the age to set
         */
        public void setAge(int age) {
            this.age = age;
        }

    }

    @Test
    public void test2() {
        Person p = new Person("guo", 20);
        CompoundPropertyModel<Person> cm = new CompoundPropertyModel<Person>(p);
        IModel<String> model = cm.bind("name");
        System.out.println(model.getObject());

        IModel<Integer> model2 = cm.bind("age");
        System.out.println(model2.getObject());
    }
     /**
    @Test
    public void test1() {
        MetaDataKey<String> k1 = new MetaDataKey<String>() {
            private static final long serialVersionUID = 1L;
        };

        MetaDataKey<String> k2 = new MetaDataKey<String>() {
            private static final long serialVersionUID = 1L;
        };

        MetaDataEntry<?>[] entries = k1.set(null, "a");
        print(entries);

        entries = k2.set(entries, "b");
        print(entries);

    }

    private void print(MetaDataEntry<?>[] entries) {
        System.out.println(">>>" + entries.length + "<<<<");

        for(MetaDataEntry<?> entry : entries) {
            System.out.println("+++" + entry);
        }
    }
    */

}
