/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kpfu.bookstore.model;

import java.util.Objects;
import javax.validation.constraints.*;

/**
 *
 * @author arch
 */
public class UserForm {
    
    
    public static final String VALUE_MALE = "male";
    public static final String VALUE_FEMALE = "female";
    
    @NotNull   
    @Pattern(regexp = "^(?:[a-zA-Z0-9_'^&/+-])+(?:\\.(?:[a-zA-Z0-9_'^&/+-])+)" +
      "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)" +
      "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)" +
      "+(?:[a-zA-Z]){2,}\\.?)$",
      message = "Stupid email")
    private String email;
    
    @NotNull
    @Size(min = 8, max = 64)
    private String password;
    
    @NotNull
    @Size(min = 8, max = 64)
    private String repeatPassword;
    
    @NotNull
    @Size(min = 1, max = 128)
    private String name;
    
    @NotNull
    private String country;
    
    @NotNull
    private String sex;
    
    private boolean newsSubscribe;

    public UserForm() {
    }

    public UserForm(String email, String password, String repeatPassword, String name, String country, String sex, boolean newsSubscribe) {
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.name = name;
        this.country = country;
        this.sex = sex;
        this.newsSubscribe = newsSubscribe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isNewsSubscribe() {
        return newsSubscribe;
    }

    public void setNewsSubscribe(boolean newsSubscribe) {
        this.newsSubscribe = newsSubscribe;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.password);
        hash = 89 * hash + Objects.hashCode(this.repeatPassword);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.country);
        hash = 89 * hash + Objects.hashCode(this.sex);
        hash = 89 * hash + (this.newsSubscribe ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserForm other = (UserForm) obj;
        if (this.newsSubscribe != other.newsSubscribe) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.repeatPassword, other.repeatPassword)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        if (!Objects.equals(this.sex, other.sex)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
