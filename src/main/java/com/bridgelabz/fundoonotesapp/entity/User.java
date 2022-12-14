package com.bridgelabz.fundoonotesapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "UserData")
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
