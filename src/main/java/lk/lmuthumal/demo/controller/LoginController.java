package lk.lmuthumal.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/login")
public class LoginController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity login(){
        return new ResponseEntity(HttpStatus.OK);
    }
}
