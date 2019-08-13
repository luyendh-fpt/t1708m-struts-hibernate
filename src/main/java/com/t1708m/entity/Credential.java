package com.t1708m.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.UUID;

@Entity
public class Credential {
    @Id
    private String accessToken;
    private long createdAtMLS;
    private long updatedAtMLS;
    private long expiredAtMLS;
    private long status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Account account;

    public Credential() {
        this.accessToken = UUID.randomUUID().toString();
        this.createdAtMLS = Calendar.getInstance().getTimeInMillis();
        this.updatedAtMLS = Calendar.getInstance().getTimeInMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 3);
        this.expiredAtMLS = calendar.getTimeInMillis();
        this.status = 1;
    }

    public long getExpiredAtMLS() {
        return expiredAtMLS;
    }

    public void setExpiredAtMLS(long expiredAtMLS) {
        this.expiredAtMLS = expiredAtMLS;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getCreatedAtMLS() {
        return createdAtMLS;
    }

    public void setCreatedAtMLS(long createdAtMLS) {
        this.createdAtMLS = createdAtMLS;
    }

    public long getUpdatedAtMLS() {
        return updatedAtMLS;
    }

    public void setUpdatedAtMLS(long updatedAtMLS) {
        this.updatedAtMLS = updatedAtMLS;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
