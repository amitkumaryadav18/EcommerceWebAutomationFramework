package com.ecom.pom.objects;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class User {
    private String username;
    private String password;
}
