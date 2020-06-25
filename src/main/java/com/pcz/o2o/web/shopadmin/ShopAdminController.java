package com.pcz.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author picongzhi
 */
@RequestMapping("/shopAdmin")
@Controller
public class ShopAdminController {
    @RequestMapping(value = "/shopOperation", method = RequestMethod.GET)
    public String shopOperation() {
        return "shop/shop-operation";
    }
}
