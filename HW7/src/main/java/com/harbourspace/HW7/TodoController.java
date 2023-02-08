package com.harbourspace.HW7;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @GetMapping("")
    public ResponseEntity<ArrayList<ListItem>> index() {
        var response = new ArrayList<ListItem>();
        response.add(new ListItem(1, 1, 4, "item1", "20/4/2023"));
        response.add(new ListItem(2, 1, 4, "item2", "21/5/2023"));
        response.add(new ListItem(3, 2, 3, "item3", "22/6/2023"));
        response.add(new ListItem(4, 2, 1, "item4", "23/7/2023"));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @PostMapping("/{id}")
//    public ResponseEntity<ItemRecord> store(@PathVariable int id, @RequestBody ItemRecord item) {
//        if (id != item.id())
//            return new ResponseEntity<> (item, HttpStatus.BAD_REQUEST);
//
//        if (item.status() == null) // Missing parameter status
//            return new ResponseEntity<> (item, HttpStatus.BAD_REQUEST);
//
//        return new ResponseEntity<>(item, HttpStatus.OK);
//    }
}