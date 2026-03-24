package org.example;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/proxy")
public class ProxyController {
    private final ProxyService proxyService;
    public ProxyController(ProxyService service){
        this.proxyService=service;
    }


    @GetMapping("/linearsearch")
    public Integer linearsearch(@RequestParam List<Integer> list, @RequestParam Integer value) throws IOException {
    return  proxyService.searchLinearSearch(list,value);
    }

    @GetMapping("/binarysearch")
    public String binarySearch(@RequestParam List<Integer> list, @RequestParam Integer value) throws IOException {
        return proxyService.searchBinarySearch(list,value);
    }

}
