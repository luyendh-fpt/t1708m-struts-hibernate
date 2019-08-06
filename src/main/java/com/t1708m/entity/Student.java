package com.t1708m.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;

@Entity
public class Student {

    @Id
    private String rollNumber;
    private String name;
    private String email;
    private long createdAt;
    private long updatedAt;
    private int status;

    public String getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static final class Builder {
        private String rollNumber;
        private String name;
        private String email;
        private long createdAt;
        private long updatedAt;
        private int status;

        private Builder() {
            this.createdAt = Calendar.getInstance().getTimeInMillis();
            this.updatedAt = Calendar.getInstance().getTimeInMillis();
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

        public Builder withCreatedAt(long createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder withUpdatedAt(long updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder withStatus(int status) {
            this.status = status;
            return this;
        }

        public Student build() {
            Student student = new Student();
            student.rollNumber = this.rollNumber;
            student.createdAt = this.createdAt;
            student.name = this.name;
            student.email = this.email;
            student.updatedAt = this.updatedAt;
            student.status = this.status;
            return student;
        }
    }
}
