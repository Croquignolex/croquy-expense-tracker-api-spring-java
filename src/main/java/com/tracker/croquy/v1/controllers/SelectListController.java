package com.tracker.croquy.v1.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/select")
public class SelectListController {
//    private final CountriesService countriesService;
//
//    @GetMapping(path = "countries")
//    public ResponseEntity<List<Country>> countries() {
//        List<Country> enabledCountries = countriesService.getAllEnabledCountriesOrderByName();
//
//        return ResponseEntity.status(HttpStatus.OK).body(enabledCountries);
//    }
}
