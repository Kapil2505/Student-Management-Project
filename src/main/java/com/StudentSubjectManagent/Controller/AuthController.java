package com.StudentSubjectManagent.Controller;

import com.StudentSubjectManagent.Entity.Role;
import com.StudentSubjectManagent.Entity.User;
import com.StudentSubjectManagent.PayLoads.LoginDto;
import com.StudentSubjectManagent.PayLoads.SignUpDto;
import com.StudentSubjectManagent.Repository.RoleRepository;
import com.StudentSubjectManagent.Repository.UserRepository;
import com.StudentSubjectManagent.Security.JWTAuthResponse;
import com.StudentSubjectManagent.Security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/authApi")
public class AuthController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthenticationManager authenticationManager;


    // http://localhost:8080/authApi/SignUp/Admin
    @PostMapping("/SignUp")
    public ResponseEntity<?> signUpAdmin(@RequestBody SignUpDto signupDto)
    {
        if(userRepo.existsByEmail(signupDto.getEmail()))
        {
            return new ResponseEntity<>("email exist already !"+signupDto.getEmail(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(userRepo.existsByEmail(signupDto.getUsername()))
        {
            return new ResponseEntity<>("UserName exist already !"+signupDto.getUsername(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        User user = new User();
        user.setName(signupDto.getName());
        user.setUsername(signupDto.getUsername());
        user.setEmail(signupDto.getEmail());
        user.setPassword(passwordEncoder.encode(signupDto.getPassword()));

        String roleName = signupDto.getRoleName();
        String roleCheck;
        if(roleName.equals("ROLE_ADMIN"))
        {
            roleCheck="Admin";
        }
        else {
            roleCheck = "Student";
        }

        Role role = roleRepository.findByName(roleName).get();
        user.setRoles(Collections.singleton(role));
        userRepo.save(user);
        return new ResponseEntity<>(roleCheck+" Registered !",HttpStatus.CREATED);
    }


    // http://localhost:8080/authApi/SignIn
    @PostMapping("/SignIn")
    public ResponseEntity<JWTAuthResponse>authenticateUser(@RequestBody LoginDto loginDto)
    {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = tokenProvider.generateToken(authenticate);
        return ResponseEntity.ok(new JWTAuthResponse(token));
    }

}

