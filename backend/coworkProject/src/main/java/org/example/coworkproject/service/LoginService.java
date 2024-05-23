package org.example.coworkproject.service;

import org.example.coworkproject.dto.request.LoginRequestDTO;
import org.example.coworkproject.dto.response.LoginResponseDTO;

public interface LoginService {

    public LoginResponseDTO login(LoginRequestDTO requestDTO);

}
