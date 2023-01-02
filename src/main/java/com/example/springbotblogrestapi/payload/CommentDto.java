package com.example.springbotblogrestapi.payload;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {
    private long id;
    @Email
    @NotEmpty(message = "Email should not be null or empty")
    private String email;

    @NotEmpty
    @Size(min = 10, message = "Content body must be minimum 10 characters")
    private String body;

    @NotEmpty(message = "Name should not be null or empty")
    private String name;


}
