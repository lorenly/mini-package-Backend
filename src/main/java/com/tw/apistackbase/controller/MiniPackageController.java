package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.MiniPackage;
import com.tw.apistackbase.service.MiniPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/miniPackage")
public class MiniPackageController {
    @Autowired
    MiniPackageService miniPackageService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MiniPackage> getPackageList(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                @RequestParam (required = false, defaultValue = "10") Integer pageSize){
        return miniPackageService.getPackageList(page, pageSize);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public MiniPackage addMiniPackage(@RequestBody MiniPackage miniPackage){
        return miniPackageService.addMiniPackage(miniPackage);
    }



}
