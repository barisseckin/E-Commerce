package com.eCommerceProject.api;

import com.eCommerceProject.request.PushAllUserEmailRequest;
import com.eCommerceProject.request.PushEmailRequest;
import com.eCommerceProject.service.SendEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/email/")
@CrossOrigin
@RequiredArgsConstructor
public class EmailController {

    private final SendEmailService sendEmailService;

    @PostMapping("pushEmail")
    public ResponseEntity<?> pushEmail(@Valid @RequestBody PushEmailRequest pushEmailRequest) {
        sendEmailService.sendEmails(pushEmailRequest.getEMail(), pushEmailRequest.getBody(), pushEmailRequest.getTitle());
        return ResponseEntity.ok("success");
    }

    @PostMapping("pushEmailToAllUser")
    public ResponseEntity<?> pushAllUser(@Valid @RequestBody PushAllUserEmailRequest pushAllUserEmailRequest) {
        sendEmailService.sendEmailAllUser(pushAllUserEmailRequest.getBody(), pushAllUserEmailRequest.getTitle());
        return ResponseEntity.ok("success");
    }
}
