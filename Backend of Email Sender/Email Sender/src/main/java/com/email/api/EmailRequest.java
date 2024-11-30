package com.email.api;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailRequest
    {

        private String to;
        private String subject;
        private String message;
    }
