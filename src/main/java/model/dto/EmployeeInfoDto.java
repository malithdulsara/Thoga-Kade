package model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeInfoDto {
    private String employeeId;
    private String name;
    private  String nic;
    private String dob;
    private String position;
    private double salary;
    private String contactNumber;
    private String address;
    private String joinDate;
    private String status;
}
