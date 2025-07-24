package com.grote.integration.omdb.feign;

import com.grote.DTOs.OmdbSearchIntegration;
import com.grote.DTOs.OmdbTitleIntegration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "omdbClient", url = "${omdb.url}")
@Component
public interface OmdbFeign {
    @GetMapping("/")
    OmdbSearchIntegration getSearch(@RequestParam(value="apiKey") String apiKey,
                                    @RequestParam(value="s", required = false) String search,
                                    @RequestParam(value="type", required = false) String type,
                                    @RequestParam(value="y", required = false) String year,
                                    @RequestParam(value="page", required = false) String page);
    @GetMapping("/")
    OmdbTitleIntegration getTitle(@RequestParam(value="apiKey") String apiKey,
                                  @RequestParam(value="t", required = false) String title,
                                  @RequestParam(value="i", required = false) String id,
                                  @RequestParam(value="type", required = false) String type,
                                  @RequestParam(value="y", required = false) String year,
                                  @RequestParam(value="plot", required = false) String plot,
                                  @RequestParam(value="page", required = false) String page);
}
