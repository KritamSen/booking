package com.booking.controller;

import com.booking.payload.UserDTO;
import com.booking.repository.UserRepository;
import com.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private  final UserService userService;

    @Autowired
    private UserRepository userRepository;



    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam(value = "profileImage", required = false)MultipartFile profileImage


            )

    {
       UserDTO userDTO= new UserDTO();
       userDTO.setFirstName(firstName);
       userDTO.setLastName(lastName);
       userDTO.setEmail(email);
       userDTO.setPassword(password);
       userDTO.setPhoneNumber(phoneNumber);
       userDTO.setProfileImage(profileImage);

       UserDTO createdUser =userService.createUser(userDTO);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> getUsers(@PageableDefault(size = 10,sort ="id") Pageable pageable) {
        Page<UserDTO> usersPage = userService.getUsers(pageable);
        return new ResponseEntity<>(usersPage, HttpStatus.OK);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User is deleted", HttpStatus.OK);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        UserDTO updatedUserDTO = userService.updateUser(userId, userDTO);
        return new ResponseEntity<>(updatedUserDTO,HttpStatus.OK);
    }

  @GetMapping(value = "/download/excel", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public ResponseEntity<InputStreamResource> downloadExcel(){
        InputStreamResource file= userService.getUsersAsExcel();
        String fileName="users_"+ System.currentTimeMillis()+".xlsx";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+fileName)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(file);
  }

    @GetMapping(value = "/users/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> downloadUsersPdf() {
        InputStreamResource pdf = userService.getUsersAsPdf();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=users.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }

    @GetMapping("/users/csv")
    public ResponseEntity<InputStreamResource> getUsersAsCsv() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=users.csv");
        InputStreamResource resource = userService.getUsersAsCsv();
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(resource);
    }

}
    //Generate API Code for this Service Layer to generate PDF file with User data from Database



//csp ,exel ,pdf

