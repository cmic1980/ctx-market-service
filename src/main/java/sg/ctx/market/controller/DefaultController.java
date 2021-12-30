package sg.ctx.market.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultController.class);

    @GetMapping("/index")
    @ResponseBody
    public ResponseEntity<?> index() {
        LOGGER.info("This is a test ...");

        var response = new JSONObject();
        return ResponseEntity.ok().body(response);
    }

}
