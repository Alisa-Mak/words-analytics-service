package com.adaptavist.fileanalytics.controller;

import com.adaptavist.fileanalytics.service.WordsCounterService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/analytics")
@Slf4j
@RequiredArgsConstructor
public class FileAnalyticsController {

    final WordsCounterService analyticService;

    @ApiOperation(value = "Retrieve words frequency for provided file", response = LinkedHashMap.class)
    @PostMapping("/frequency")
    public List<Map.Entry<String, Integer>> calcWordsForFile(@RequestBody String filePath) {
        log.info("calcWordsForFile of FileAnalyticsService");
        return analyticService.calcWordsForFile(filePath);
    }
}
