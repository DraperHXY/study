package com.jnshu.dreamteam.controller;

import com.jnshu.dreamteam.pojo.HotRecommend;
import com.jnshu.dreamteam.pojo.Response;
import com.jnshu.dreamteam.service.HotRecommendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author draper_hxy
 */
@RestController
public class HotRecommendController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HotRecommendService hotRecommendService;

    @RequestMapping(value = "/a/u/hotRc/{id}", method = RequestMethod.GET)
    public Response select(@PathVariable Long id) {
        try {
            return new Response(200,"OK", hotRecommendService.select(id));
        } catch (Throwable t) {
            t.printStackTrace();
            LOGGER.error(t.getMessage());
            return Response.error();
        }
    }

    @RequestMapping(value = "/a/u/hotRc", method = RequestMethod.PUT)
    public Response update(@RequestBody HotRecommend hotRc) {
        try {
            return new Response(200,"OK",hotRecommendService.update(hotRc));
        } catch (Throwable t) {
            t.printStackTrace();
            LOGGER.error(t.getMessage());
            return Response.error();
        }
    }

    @RequestMapping(value = "/a/u/hotRc", method = RequestMethod.POST)
    public Response insert(@RequestBody HotRecommend hotRc) {
        try {
            return new Response(200,"OK",hotRecommendService.insert(hotRc));
        } catch (Throwable t) {
            t.printStackTrace();
            LOGGER.error(t.getMessage());
            return Response.error();
        }
    }

    @RequestMapping(value = "/a/u/hostRc/{id}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable Long id) {
        try {
            return new Response(200,"OK",hotRecommendService.delete(id));
        } catch (Throwable t) {
            t.printStackTrace();
            LOGGER.error(t.getMessage());
            return Response.error();
        }
    }

}
