package org.example.javaee_springboot_lab3;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;


@RestController
@RequestMapping("/api")
public class ApiController {


    HashMap<Integer, UserData> users = new HashMap<>();

    // create user
    @PostMapping("/user/create")
    public ResponseEntity<UserData> createUser(@Valid @RequestBody UserData userData) {
        users.put(userData.getId(), userData);
        return new ResponseEntity<>(userData, HttpStatus.CREATED);
    }

    // delete user by id
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<UserData> deleteUser(@PathVariable Integer id) {
        users.remove(id);
        return new ResponseEntity<>(users.get(id), HttpStatus.OK);
    }



    // get user by id
    @GetMapping("/user/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        UserData user = users.get(id);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    //get all users
    @GetMapping("/user/get")
    public ResponseEntity<?> getUser() {

        return new ResponseEntity<>(users.values(), HttpStatus.OK);

    }


    //update user
    @PutMapping("/user/update/{id}")
    public ResponseEntity<UserData> updateUser(@PathVariable int id, @RequestBody UserData userData) {
        users.get(id).setName(userData.getName());
        users.get(id).setAge(userData.getAge());
        return new ResponseEntity<>(users.get(id), HttpStatus.OK);
    }

    // fives task - exception
    @GetMapping("/exception")
    public ResponseEntity<String> exception() {
        throw new RuntimeException("intentional exception");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

    }


}
