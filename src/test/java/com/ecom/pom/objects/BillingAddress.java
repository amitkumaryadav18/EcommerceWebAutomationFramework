package com.ecom.pom.objects;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter @Setter
@Jacksonized
public class BillingAddress {

    private String firstName;
    private String lastName;
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String email;

}
