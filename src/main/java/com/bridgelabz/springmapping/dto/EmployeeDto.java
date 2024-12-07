package com.bridgelabz.springmapping.dto;

import com.bridgelabz.springmapping.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    @NotNull(message="fname cannot be null")
    private String fName;
    @NotNull(message="lname cannot be null")
    private String lName;
    @Max(value=50 ,message="age not more than 50")
    private int age;
    @Email(message="email not null")
    private String email;
    @NotNull( message="list cannot be null")
    private List<String> departments;
    private List<Address> addresses;




  /*  //["a","b","c"] -> valid
    // null , [] , {} invalid
    @NotEmpty(message = "Name should not be empty")
//    @NotEmpty(message = "Name should not be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$", message = "Pattern mismatch Min 3 characters eg= Sam")
    private String fName;
        // name = "ABC", "123"
        // name=""
        // name = "ABC" , name= ""  age=0 -> valid
        // name = null -> invalid
        @NotNull
        private String lName;

    @Email
    private String emailId;
        @NotBlank
        private String address;
        //    @NotBlank
        private List<Address> addresses;
        private List<String> departments;

        @Min(value = 18,message = "Age must be 18+")
        @Max(value = 50, message = "Age limit less then 50")
        private int age;

    //YYYY-MM-DD format for localdate
    @Past(message = "BirthDate must be a past date")
    private LocalDate birthDate;

    @Future(message = "Event date must be a future date")
    private LocalDate eventDate;

    @PastOrPresent(message = "Registration date must be past or present date")
    private LocalDate registrationDate;

    @FutureOrPresent
    private LocalDate bookingDate;
    private String email;
    private String body;
    private String subject;
   */
}
