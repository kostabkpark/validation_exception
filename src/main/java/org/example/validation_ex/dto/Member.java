package org.example.validation_ex.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private Long id;
    @NotNull(message="아이템의 name 항목은 반드시 값을 입력해야 합니다.") //  null(X), ""(X), " " (X)
    private String name;
    @NotNull(message="아이템의 cost 항목에는 반드시 값을 입력해야 합니다.")
    @Range(min=10, max=10000, message = "cost는 10~10000 사이의 값을 입력해야 합니다.")
    private Integer cost;
    @NotNull
    @Range(min=100, max=20000, message="price는 100~20000 사이의 값을 입력해야 합니다.")
    private Integer price;
    @NotNull
    @Max(10000)
    private Integer quantity;
}

//{
//        "id" : null,
//        "name" : "test",
//        "cost" : 100,
//        "price" : 200,
//        "quantity" : 1000
//        }
