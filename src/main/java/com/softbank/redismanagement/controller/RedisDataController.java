package com.softbank.redismanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisDataController {

    @PostMapping("/export")
    public ResponseEntity<Void> exportFileCSV() {

        return ResponseEntity.noContent().build();
    }


}
