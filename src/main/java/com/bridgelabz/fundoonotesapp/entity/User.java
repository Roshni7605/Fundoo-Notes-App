package com.bridgelabz.fundoonotesapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private String phoneNo;
    private String dob;
    private String profilePic;

}
