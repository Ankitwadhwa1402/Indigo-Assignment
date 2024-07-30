package com.backend.indigo.controller;


import com.backend.indigo.model.Notification;
import com.backend.indigo.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subscribe")
public class NotificationController {
    @Autowired
    private NotificationRepository notificationRepository;

    @PostMapping
    public Notification subscribe(@RequestBody Notification notification) {
        return notificationRepository.save(notification);
    }
}
