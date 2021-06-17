package com.zs.erh.service.imple;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.zs.erh.bean.*;
import com.zs.erh.dao.*;
import com.zs.erh.security.jwt.JwtUtils;
import com.zs.erh.security.payload.request.LoginRequest;
import com.zs.erh.security.payload.request.SignupRequest;
import com.zs.erh.security.payload.response.JwtResponse;
import com.zs.erh.security.payload.response.MessageResponse;
import com.zs.erh.security.services.UserDetailsImpl;
import com.zs.erh.service.facade.AgenceService;
import com.zs.erh.service.facade.CollaborateurService;
import com.zs.erh.service.util.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/maneo-rh/auth")
public class AuthServiceImple {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDao userRepository;

    @Autowired
    AdminDao adminDao;

    @Autowired
    ChefAgenceDao chefAgenceDao;

    @Autowired
    CollaborateurDao collaborateurDao;

    @Autowired
    RoleDao roleRepository;

    @Autowired
    AgenceService agenceService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getCode(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles,userDetails.getNom(),userDetails.getPrenom()));
    }

    @PostMapping("/admin-signup")
    public ResponseEntity<?> adminRegister(@Valid @RequestBody SignupRequest signUpRequest) {
        System.out.println();
        if (userRepository.existsByLogin(signUpRequest.getLogin())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        Admin user = new Admin();
            user.setId(null);
            user.setLogin(signUpRequest.getLogin());
            user.setEmail(signUpRequest.getEmail());
            user.setPhone(signUpRequest.getPhone());
            user.setNom(signUpRequest.getNom());
            user.setPrenom(signUpRequest.getPrenom());
            user.setMustChangePassword(true);
            user.setLogin(signUpRequest.getLogin());
            user.setPassword(encoder.encode(signUpRequest.getPassword()));

        Set<Role> roles = new HashSet<>();

            Role userRole = roleRepository.findByName(Roles.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
            user.setRoles(roles);
            adminDao.save(user);
            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }


    @PostMapping("/chef-agence-signup")
    public ResponseEntity<?> chefAgenceRegister(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByLogin(signUpRequest.getLogin())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        ChefAgence user = new ChefAgence();
        user.setLogin(signUpRequest.getLogin());
        user.setEmail(signUpRequest.getEmail());
        user.setPhone(signUpRequest.getPhone());
        user.setNom(signUpRequest.getNom());
        user.setPrenom(signUpRequest.getPrenom());
        user.setMustChangePassword(true);
        user.setLogin(signUpRequest.getLogin());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));

        Set<Role> roles = new HashSet<>();

            Role userRole = roleRepository.findByName(Roles.ROLE_CHEF_AGENCE)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
            chefAgenceDao.save(user);
        return ResponseEntity.ok(new MessageResponse("Chef agence registered successfully!"));
    }

    @PostMapping("/collaborateur-signup")
    public ResponseEntity<?> CollaborateurRegister(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByLogin(signUpRequest.getLogin())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        Collaborateur user = new Collaborateur();
        user.setLogin(signUpRequest.getLogin());
        user.setEmail(signUpRequest.getEmail());
        user.setPhone(signUpRequest.getPhone());
        user.setNom(signUpRequest.getNom());
        user.setPrenom(signUpRequest.getPrenom());
        user.setMustChangePassword(true);
        user.setLogin(signUpRequest.getLogin());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));


        Set<Role> roles = new HashSet<>();
        System.out.println(signUpRequest.getAgenceCode());
        Agence agence = agenceService.findByCode(signUpRequest.getAgenceCode());

        Role userRole = roleRepository.findByName(Roles.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        user.setRoles(roles);

        if (agence == null){
            return ResponseEntity.ok(new MessageResponse("User not registered successfully!"));
        }else {
            user.setAgence(agence);
            collaborateurDao.save(user);
            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        }
    }
}