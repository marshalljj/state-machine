package com.majian.statemachine;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by majian on 2017/7/19.
 */
@Api
@RestController
@RequestMapping("/v2")
public class Controller {

    @Autowired
    private CaseService caseService;

    @ApiOperation("")
    @PostMapping("cases/_orderin")
    public void orderIn(@ApiParam @RequestParam String caseId, @RequestParam @ApiParam String orderId) {
        caseService.orderIn(caseId, orderId);
    }

    @ApiOperation("")
    @PostMapping("cases/_distribute")
    public void distribute(@ApiParam @RequestParam String caseId, @ApiParam @RequestParam String recipient) {
        caseService.distribute(caseId, recipient);
    }

    @ApiOperation("")
    @PostMapping("cases/_submit")
    public void ditribute(@ApiParam @RequestParam String caseId, @ApiParam @RequestParam String result) {
        caseService.submit(caseId, result);
    }

}
