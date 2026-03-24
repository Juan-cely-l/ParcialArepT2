package org.example;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MathController {
    private final MathService mathService;

    public MathController(MathService service) {
        this.mathService = service;
    }

    @GetMapping("/linearsearch")
    String linearSearch(@RequestParam List<Integer> list, @RequestParam Integer value) {
        Integer output = mathService.linearSearch(list, value);
        return "output: " + output;
    }

    @GetMapping("/binarysearch")
    String binarySearch(@RequestParam List<Integer> list, @RequestParam Integer value) {
        String output = MathService.binarysearch(list, value);
        return "output: " + output;
    }

}



