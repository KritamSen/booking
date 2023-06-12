package com.booking.service.impl;

import com.booking.entities.User;
import com.booking.payload.UserDTO;
import com.booking.repository.UserRepository;
import com.booking.service.UserService;
import com.booking.util.PdfExporter;
import com.booking.util.UserServiceUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public Page<UserDTO> getUsers(Pageable pageable) {
        Page<User> usersPage = userRepository.findAll(pageable);
        List<UserDTO> userDTOs = usersPage.stream().map(this::userToDto).collect(Collectors.toList());
        return new PageImpl<>(userDTOs, pageable, usersPage.getTotalElements());
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with id " + userId + " not found"));
        userRepository.delete(user);
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with id " + userId + " not found"));

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setUpdatedAt(new Date());

        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            user.setPasswordHash(passwordEncoder.encode(userDTO.getPassword()));
        }

        MultipartFile profileImage = userDTO.getProfileImage();
        if (profileImage != null && !profileImage.isEmpty()) {
            String fileName = saveProfileImage(profileImage);
            user.setProfilePicture(fileName);
        }

        User updatedUser = userRepository.save(user);
        return userToDto(updatedUser);
    }


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final String uploadDirectory = "src/main/resources/static/user_profile_image/";

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = dtoToUser(userDTO);
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());


        user.setPasswordHash(passwordEncoder.encode(userDTO.getPassword()));

        MultipartFile profileImage = userDTO.getProfileImage();
        if (profileImage != null && !profileImage.isEmpty()) {
            String fileName = saveProfileImage(profileImage);
            user.setProfilePicture(fileName);
        }

        User save = userRepository.save(user);
        return userToDto(save);
    }

    private String saveProfileImage(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            String originalFileName = file.getOriginalFilename();
            String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String fileName = System.currentTimeMillis() + "_" + (int) (Math.random() * 1000) + extension;
            Path path = Paths.get(uploadDirectory + fileName);
            Files.write(path, bytes);
            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save profile image", e);
        }


    }

    private User dtoToUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPasswordHash(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());


        return user;
    }

    private UserDTO userToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPasswordHash());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setProfilePicture(user.getProfilePicture());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setUpdatedAt(user.getUpdatedAt());
        return userDTO;
    }



    @Override
    public InputStreamResource getUsersAsExcel() {
        List<User> users = userRepository.findAll();
        ByteArrayInputStream in = UserServiceUtils.usersToExcel(users);
        return new InputStreamResource(in);
    }

    @Override
    public InputStreamResource getUsersAsPdf(){
        List<UserDTO> userDTOS= userRepository.findAll().stream().map(this::userToDto).collect(Collectors.toList());
        ByteArrayInputStream pdfInputStream= PdfExporter.exportUsersToPdf(userDTOS);
        return new InputStreamResource(pdfInputStream);
    }

    @Override
    public InputStreamResource getUsersAsCsv() {
        List<User> users = userRepository.findAll();
        String csv = UserServiceUtils.usersToCsv(users);
        InputStream inputStream = new ByteArrayInputStream(csv.getBytes(StandardCharsets.UTF_8));
        return new InputStreamResource(inputStream);
    }



}
















//    private final UserRepository userRepository;
//    private final Map<String, Path> paths;
//
//   private final String uploadDirectory= "src/main/resources/static/user_profile_image/";
//
//    @Autowired
//    public UserServiceImpl(UserRepository userRepository, Map<String, Path> paths) {
//        this.userRepository = userRepository;
//        this.paths = paths;
//    }
//
//    @Override
//    public UserDTO createUser(UserDTO userDTO) {
//        User user = new User();
//        user.setFirstName(userDTO.getFirstName());
//        user.setLastName(userDTO.getLastName());
//        user.setEmail(userDTO.getEmail());
//        user.setPasswordHash(userDTO.getPassword());
//        user.setPhoneNumber(userDTO.getPhoneNumber());
//        user.setProfilePicture(userDTO.getProfilePicture());
//        user.setCreatedAt(userDTO.getCreatedAt());
//        user.setUpdatedAt(userDTO.getUpdatedAt());
//
//        MultipartFile file = userDTO.getProfileImage();
//
//        if (file != null && !file.isEmpty()) {
//            String fileName = user.getEmail() + "_" + file.getOriginalFilename();
//            Path uploadDir = paths.get("D:/intelij id/bus ticket booking app/booking/user.profile.image");
//
//            try {
//                if (!Files.exists(uploadDir)) {
//                    Files.createDirectories(uploadDir);
//                }
//                Path targetPath = uploadDir.resolve(fileName);
//                Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
//                user.setProfilePicture(targetPath.toString());
//            } catch (IOException e) {
//                throw new RuntimeException("failed to store this file", e);
//            }
//        }
//
//        User savedUser = userRepository.save(user);
//        UserDTO newUserDTO = new UserDTO();
//        newUserDTO.setId(savedUser.getId());
//        newUserDTO.setFirstName(savedUser.getFirstName());
//        newUserDTO.setLastName(savedUser.getLastName());
//        newUserDTO.setEmail(savedUser.getEmail());
//        newUserDTO.setPassword(null);
//        newUserDTO.setPhoneNumber(savedUser.getPhoneNumber());
//        newUserDTO.setProfilePicture(savedUser.getProfilePicture());
//        newUserDTO.setCreatedAt(savedUser.getCreatedAt());
//        newUserDTO.setUpdatedAt(savedUser.getUpdatedAt());
//
//        return newUserDTO;
