package com.grote.integration.omdb.feign;

import com.grote.DTOs.OmdbSearchIntegration;
import com.grote.DTOs.OmdbTitleIntegration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${omdb.url}")
public interface OmdbFeign {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    OmdbSearchIntegration getSearch(@RequestParam("s") String search,
                                    @RequestParam("apiKey") String apiKey,
                                    @RequestParam("type") String type,
                                    @RequestParam("y") String year,
                                    @RequestParam("page") Integer page);
    @RequestMapping(method = RequestMethod.GET, value = "/")
    OmdbTitleIntegration getTitle(@RequestParam("t") String title,
                                  @RequestParam("apiKey") String apiKey,
                                  @RequestParam("type") String type,
                                  @RequestParam("y") String year,
                                  @RequestParam("page") Integer page);
}
