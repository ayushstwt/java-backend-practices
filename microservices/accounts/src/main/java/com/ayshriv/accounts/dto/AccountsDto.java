package com.ayshriv.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;

@Data
public class AccountsDto {

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number should be 10 digits")
    @NotEmpty(message = "Account number should not be empty")
    private Long accountNumber;

    @NotEmpty(message = "Account type should not be empty")
    private String accountType;

    @NotEmpty(message = "Branch address should not be empty")
    private String branchAddress;
}
