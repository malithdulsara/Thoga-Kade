package model.dto;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class CustomerInfoDto {
    private String id;
    private String title;
    private String name;
    private String dob;
    private double salary;
    private String address;
    private String city;
    private String province;
    private String postalCode;


}
