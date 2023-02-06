package com.harbourspace.java;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/inbox/items")
public class InboxController {

    @GetMapping("")
    public ResponseEntity<ArrayList<ItemRecord>> index() {
        var response = new ArrayList<ItemRecord>();
        response.add(new ItemRecord(1, "item1"));
        response.add(new ItemRecord(2, "item2"));
        response.add(new ItemRecord(3, "item3"));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ItemRecord> store(@PathVariable int id, @RequestBody ItemRecord item) {
        if (id != item.id())
            return new ResponseEntity<> (item, HttpStatus.BAD_REQUEST);

        if (item.status() == null) // Missing parameter status
            return new ResponseEntity<> (item, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(item, HttpStatus.OK);
    }
}
