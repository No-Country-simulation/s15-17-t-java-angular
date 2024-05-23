package org.example.coworkproject.controller;

import org.example.coworkproject.dto.request.LoginRequestDTO;
import org.example.coworkproject.dto.response.LoginResponseDTO;
import org.example.coworkproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/auth/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO requestDTO) {

        LoginResponseDTO loginResponseDTO = loginService.login(requestDTO);

        return ResponseEntity.ok()
                .header("Authorization", "Bearer" + loginResponseDTO.getToken())
                .body(loginResponseDTO);
    }

}
