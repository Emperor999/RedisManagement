package com.softbank.redismanagement.controller;

import com.softbank.redismanagement.service.RedisManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class RedisDataController {

    private final RedisManagementService redisManagementService;

    @GetMapping(value = "/export")
    public ResponseEntity<Void> exportFileCSV() throws IOException {
        redisManagementService.exportFileCSV();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteDataCSV() {
        redisManagementService.deleteDataCSV();
        return ResponseEntity.noContent().build();
    }

}
