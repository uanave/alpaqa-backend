package com.alpaqinglist.alpaqa.controller;

import com.alpaqinglist.alpaqa.logic.ItemAdder;
import com.alpaqinglist.alpaqa.persistence.domain.Item;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/backpacks")
@Validated
public class NewItemEndpoint {
    private final ItemAdder itemAdder;

    public NewItemEndpoint(ItemAdder itemAdder) {
        this.itemAdder = itemAdder;
    }

    @PutMapping("/{backpackId}/add-new-item")
    void addItem(@PathVariable Long backpackId, @Valid @RequestBody Item item) {
        itemAdder.saveItemInBackpack(backpackId, item);
    }
}
