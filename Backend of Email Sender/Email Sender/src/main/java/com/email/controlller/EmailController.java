package com.email.controlller;

import com.email.api.EmailRequest;
import com.email.helper.CustomResponse;
import com.email.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/email")
public class EmailController
    {
        @Value("${file.upload-dir}")
        private String uploadDir;


        @Autowired
        private EmailService emailService;


        @PostMapping("/send")
        public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request)
            {
                emailService.sendEmailWithHtml(request.getTo(), request.getSubject(), request.getMessage());
                return ResponseEntity.ok(CustomResponse.builder()
                                                       .message("Email send successfully !!")
                                                       .status(HttpStatus.OK)
                                                       .success(true)
                                                       .build());

            }
        @PostMapping("/send-with-file")
        public ResponseEntity<CustomResponse> sendWithFile ( @RequestPart EmailRequest request,@RequestPart
                MultipartFile file
                )
                throws IOException

            {
                //specify the location to save the file
                String uploadDir = this.uploadDir;
                File uploadFile = new File(uploadDir + file.getOriginalFilename());

                //Ensure that directory is exist
                uploadFile.getParentFile().mkdirs();

                //Save the file to the disk
                file.transferTo(uploadFile);

                emailService.sendEmailWithFile(request.getTo(),request.getSubject(),request.getMessage(),uploadFile.getAbsoluteFile());

                // Ensure file is deleted after usage
                uploadFile.delete();

                return ResponseEntity.ok(CustomResponse.builder()
                                                       .message("Email send successfully !!")
                                                       .status(HttpStatus.OK)
                                                       .success(true)
                                                       .build());

        }
    }
