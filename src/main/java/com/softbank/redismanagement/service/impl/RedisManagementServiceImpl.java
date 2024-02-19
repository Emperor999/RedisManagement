package com.softbank.redismanagement.service.impl;

import com.softbank.redismanagement.service.RedisManagementService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;


@Service
@Slf4j
public class RedisManagementServiceImpl implements RedisManagementService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Value("${system.files.csv.path}")
    private String CSV_FILE_PATH;

    @Override
    public void exportFileCSV() throws IOException {
        Set<String> allKeys = getAllKeys();
        FileWriter fileWriter = new FileWriter(CSV_FILE_PATH);
        CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader("Key", "Status"));
        allKeys.forEach(key -> {
            try {
                csvPrinter.printRecord(key, redisTemplate.opsForValue().get(key));
            } catch (IOException exception) {
                log.error(exception.getMessage());
            }
        });
        csvPrinter.flush();
    }

    private Set<String> getAllKeys() {
       return redisTemplate.keys("*");
    }


    @Override
    public void deleteDataCSV() {
        redisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.flushDb();
            return null;
        });
    }

}








