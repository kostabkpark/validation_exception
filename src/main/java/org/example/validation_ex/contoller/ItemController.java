package org.example.validation_ex.contoller;

import lombok.extern.slf4j.Slf4j;
import org.example.validation_ex.dto.ErrorResult;
import org.example.validation_ex.dto.Item;
import org.example.validation_ex.exception.ItemValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
@Slf4j
public class ItemController {

    @PostMapping
    public Object createItem(@Validated @RequestBody Item item,
                             BindingResult bindingResult) {
        if(item.getCost() >= item.getPrice()) {
            //bindingResult.reject("costAndPrice", "cost exceeds price");
            throw new ItemValidationException("cost exceeds price");
        }
//        if(bindingResult.hasErrors()) {
//            log.error("Validation errors: {}", bindingResult.getAllErrors());
//            return bindingResult.getAllErrors();
//        }

        log.info("Creating new item: {}", item);
        return item;
    }
}
