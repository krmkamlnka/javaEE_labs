package org.example.javaee_springboot_lab3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;


import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    // first task
    @PostMapping("/books")
    public ResponseEntity<Map<String, String>>
    addBook(@RequestBody Map<String, String> bookData) {
        bookData.put("status", "received");
        return ResponseEntity.ok(bookData);
    }

    // second task
    @PutMapping("/user/{id}")
    public ResponseEntity<Map<String, Object>>
    updateUser(@PathVariable("id") int userId, @RequestBody Map<String, Object> userData) {
        userData.put("id", userId);
        return ResponseEntity.ok(userData);
    }

    // third task
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        return ResponseEntity.ok("deleted");
    }

    // fours task

    // fives task
    @GetMapping("/exception")
    public ResponseEntity<String> exception() {
        throw new RuntimeException("intentional exception");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

    }


}
