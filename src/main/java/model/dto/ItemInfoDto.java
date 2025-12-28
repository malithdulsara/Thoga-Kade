package model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemInfoDto {
    private String itemCode;
    private String description;
    private String category;
    private int quantityOnHand;
    private double unitPrice;
}
