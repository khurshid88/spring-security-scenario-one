package com.springsecurity.scenarioone.controller;

import com.springsecurity.scenarioone.model.LoginDto;
import com.springsecurity.scenarioone.config.JwtTokenUtils;
import com.springsecurity.scenarioone.model.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
class AuthController {
    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public CustomResponse login(@RequestBody LoginDto loginDto) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
            authenticationManager.authenticate(authenticationToken);
            String username = (String) authenticationToken.getPrincipal();
            String jwtToken = jwtTokenUtils.generate(username);
            return CustomResponse.successMsg(jwtToken);
        } catch (BadCredentialsException e) {
            String message = "Check your username or password";
            return CustomResponse.errorMsg(message);
            //throw new CustomApiException(message, ErrorCodes.CUSTOMIZED_ERROR_CODE);
        }
    }

    @GetMapping("/me")
    public CustomResponse me() {
        return CustomResponse.successMsg("My information");
    }
}
