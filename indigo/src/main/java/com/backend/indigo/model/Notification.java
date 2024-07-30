package com.backend.indigo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "notifications")
public class Notification {
    @Id
    private String id;
    private String flightId;
    private String message;
    private LocalDateTime timestamp;
    private String method;
    private String recipient;

}
