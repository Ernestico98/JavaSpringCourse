package com.example.finalExam;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CalcController {

    /**
     * @param numbers: List of integers. They should be comma separated without spaces in the request
     * @apiNote Product is not defined for empty list of elements, so in this case is a bad request.
     * @apiNote Example of request: localhost:8080/multiply?numbers=20,2,3
     * @return Product of the numbers
     */
    @GetMapping("multiply")
    public ResponseEntity<Integer> multiply(@RequestParam("numbers") List<Integer> numbers) {

        if (numbers.isEmpty() || numbers.size() > 10) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var product = Integer.valueOf(1);
        for (var factor : numbers)
            product *= factor;

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * @param numbers: List of integers. They should be comma separated without spaces in the request
     * @apiNote Example of request: localhost:8080/sum?numbers=20,2,3
     * @return Sum of the numbers
     */
    @GetMapping("sum")
    public ResponseEntity<Integer> sum(@RequestParam("numbers") List<Integer> numbers) {

        if (numbers.size() > 10) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var sum = Integer.valueOf(0);
        for (var term : numbers)
            sum += term;

        return new ResponseEntity<>(sum, HttpStatus.OK);
    }
}
