package com.umurava.umapis.dto;

public class UserInformDto {
    private String name;
    private String email;
    private String password;
    private int phone;

    public String getName () { return this.name; }
    public String getPassword () { return this.password; }
    public String getEmail () { return  this.email; }
    public int getPhone () { return this.phone; }
}
