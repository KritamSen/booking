package com.booking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;
    private String profilePicture;
    private Date createdAt;
    private Date updatedAt;
    private MultipartFile profileImage;


}
