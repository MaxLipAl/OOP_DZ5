// User.java
package model;

public abstract class User {
    protected final Integer age;
    protected final String name;

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
