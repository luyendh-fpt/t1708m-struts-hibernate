package com.t1708m.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Student {

    @Id
    private String rollNumber;
    private String name;
    private String email;
    private long createdAtMLS;
    private long updatedAtMLS;
    private long deletedAtMLS;
    private int status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Account account;

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public long getDeletedAtMLS() {
        return deletedAtMLS;
    }

    public void setDeletedAtMLS(long deletedAtMLS) {
        this.deletedAtMLS = deletedAtMLS;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public static final class Builder {
        private String rollNumber;
        private String name;
        private String email;
        private long createdAtMLS;
        private long updatedAtMLS;
        private long deletedAtMLS;
        private int status;

        private Builder() {
            this.createdAtMLS = Calendar.getInstance().getTimeInMillis();
            this.updatedAtMLS = Calendar.getInstance().getTimeInMillis();
        }

        public static Builder aStudent() {
            return new Builder();
        }

        public Builder withRollNumber(String rollNumber) {
            this.rollNumber = rollNumber;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withCreatedAtMLS(long createdAtMLS) {
            this.createdAtMLS = createdAtMLS;
            return this;
        }

        public Builder withUpdatedAtMLS(long updatedAtMLS) {
            this.updatedAtMLS = updatedAtMLS;
            return this;
        }

        public Builder withDeletedAtMLS(long deletedAtMLS) {
            this.deletedAtMLS = deletedAtMLS;
            return this;
        }

        public Builder withStatus(int status) {
            this.status = status;
            return this;
        }

        public Student build() {
            Student student = new Student();
            student.setRollNumber(rollNumber);
            student.setName(name);
            student.setEmail(email);
            student.setCreatedAtMLS(createdAtMLS);
            student.setUpdatedAtMLS(updatedAtMLS);
            student.setDeletedAtMLS(deletedAtMLS);
            student.setStatus(status);
            return student;
        }
    }
}
