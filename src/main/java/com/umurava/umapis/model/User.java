package com.umurava.umapis.model;

import com.umurava.umapis.enums.Gender;
import com.umurava.umapis.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private int phone;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public User () {}
    public User (String name, String email, int phone, String password, Role role, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phone = phone;
    }

    public void setName (String name) { this.name = name; }
    public void setEmail (String email) { this.email = email; }
    public void setPassword (String password) { this.password = password; }
    public void setPhone (int phone) { this.phone = phone; }
    public void setRole (Role role) { this.role = role; }
    public void setGender (Gender gender) { this.gender = gender; }

    public String getName () { return this.name; }
    public String getEmail () { return this.email; }
    public String getPassword () { return this.password; }
    public int getPhone () { return  this.phone; }
    public Gender getGender () { return this.gender; }
    public Role getRole () { return this.role; }

}
