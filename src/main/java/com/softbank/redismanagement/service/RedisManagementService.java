package com.softbank.redismanagement.service;

import java.io.IOException;

public interface RedisManagementService {
    void exportFileCSV() throws IOException;

    void deleteDataCSV();
}
