package com.fullstack.employeemanager.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.UUID;

@JsonDeserialize(builder = EmployeeDto.EmployeeBuilder.class)
public class EmployeeDto {
    private final UUID id;
    private final String name;
    private final String email;
    private final String jobTitle;
    private final String phone;
    private final String imageUrl;
    private final UUID employeeCode;

    private EmployeeDto(EmployeeBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.jobTitle = builder.jobTitle;
        this.phone = builder.phone;
        this.imageUrl = builder.imageUrl;
        this.employeeCode = builder.employeeCode;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class EmployeeBuilder {
        private UUID id;
        private String name;
        private String email;
        private String jobTitle;
        private String phone;
        private String imageUrl;
        private UUID employeeCode;

        public EmployeeBuilder setId(UUID id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public EmployeeBuilder setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public EmployeeBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public EmployeeBuilder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public EmployeeBuilder setEmployeeCode(UUID employeeCode) {
            this.employeeCode = employeeCode;
            return this;
        }

        public EmployeeDto build() {
            return new EmployeeDto(this);
        }
    }


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UUID getEmployeeCode() {
        return employeeCode;
    }
}
