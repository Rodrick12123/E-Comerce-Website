package com.example.CogentCapstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class AccountController {
    @Autowired
    private UserService userService;
    
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.save(user);
    }
    
//    @GetMapping("/current-user")
//    public ResponseEntity<?> getCurrentUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        User user = userService.findByUsername(username);
//        return ResponseEntity.ok(user);
//    }
    
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.login(user.getUsername(), user.getPassword()));
    }
    
    @PutMapping("users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(user);
    }
    
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }
    
    @GetMapping("/users")
    public List<User> loadUsers() {
        return userService.loadUsers();
    }
    
    
    @GetMapping("/user")
    public ResponseEntity<?> getUser(@RequestBody Authentication authentication) {
        return ResponseEntity.ok(authentication.getPrincipal());
    }
    @GetMapping("/user/{id}")
    public Optional<User> loadUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }
    
    @GetMapping("/getUser/{name}")
    public Long getCurrentUserId(@PathVariable("name") String name) {
//    	Authentication auth = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();
//    	String userDetails = (String) auth.getName();
//    	
//    	User user = userService.findByUsername(userDetails);
//        if (user != null) {
//        	
//        	return ResponseEntity.ok(user.getId());
//        }else {
//        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
    	
    	return userService.findByUsername(name).getId();
    	
//    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null && auth.isAuthenticated() ) {
//            String username = auth.getName();
//            User user = userService.findByUsername(username);
//            if (user != null) {
//                return ResponseEntity.ok(user.getId());
//            }
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "Logged out";
    }
}
