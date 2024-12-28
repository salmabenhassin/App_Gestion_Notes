package com.example.demo.entities;

//Importing required classes
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Annotations
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDonnes{
	
	// Class data members
    private String recipient;
    private String msgBody;
    private String subject;
}