package com.lhyla.p23databinding;

import java.io.Serializable;

/**
 * Created by RENT on 2017-06-06.
 */

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String age;
    private boolean additionalMaterials;

    public User(String firstName, String lastName, boolean additionalMaterials,String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.additionalMaterials = additionalMaterials;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public String getAge() {
        return age;
    }

    public boolean getAdditionalMaterials() {
        return additionalMaterials;
    }
}
