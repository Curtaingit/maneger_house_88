package com.example.manager_house_88.controller;


import com.aliyuncs.exceptions.ClientException;
import com.example.manager_house_88.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/verify")
@CrossOrigin(origins = {}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})

public class VerificationController {

    @Autowired
    private VerificationService verificationService;

    @PostMapping("/getcode")
    public Object getCode(String number, Principal principal) {
        try {
            verificationService.getCode(number, principal.getName());
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return number;
    }

    @PostMapping("/sendcode")
    public Object sendCode(String code, String number, Principal principal) {
        verificationService.sendCode(code,  principal.getName(),number);
        return "认证成功";
    }

}
