package com.ms.Email.models.entities;

import com.ms.Email.enums.EmailStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_EMAILS")
public class EmailModel {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private UUID emailId;

    private UUID userId;
    private String emailFrom;
    private String to;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String body;
    private LocalDateTime sendDateEmail;
    private EmailStatus emailStatus;

    public EmailModel(UUID emailId, UUID userId,String emailFrom, String to, String subject, String body, LocalDateTime sendDateEmail, EmailStatus emailStatus) {
        this.emailId = emailId;
        this.userId = userId;
        this.emailFrom = emailFrom;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.sendDateEmail = sendDateEmail;
        this.emailStatus = emailStatus;
    }

    public EmailModel() {}

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public UUID getEmailId() {
        return emailId;
    }

    public void setEmailId(UUID emailId) {
        this.emailId = emailId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getSendDateEmail() {
        return sendDateEmail;
    }

    public void setSendDateEmail(LocalDateTime sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    public EmailStatus getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(EmailStatus emailStatus) {
        this.emailStatus = emailStatus;
    }
}
