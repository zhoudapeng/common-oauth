package com.zdp.common.oauth.controller;

import com.zdp.common.oauth.RedirectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author <a href="mailto:zhoudapeng8888@126.com">zhoudapeng</a>
 * Date 2018/6/14
 * Time 上午10:39
 */
@Controller
@RequestMapping("/callback")
public class CallbackController {
    private static final Logger logger = LoggerFactory.getLogger(CallbackController.class);
    @RequestMapping("/wechat")
    public RedirectView wechat(@RequestParam("redirect_url") String redirect_url, @RequestParam("code") String code) {
        logger.info("receive callback,redirect_url=" + redirect_url + ",code=" + code);
        int index = redirect_url.indexOf("?");
        StringBuilder sb = new StringBuilder(redirect_url);
        if (index == -1) {
            sb.append(redirect_url).append("?code=").append(code).append("&connect_redirect=1#wechat_redirect");
            return RedirectUtil.build(sb.toString());
        }
        if (!redirect_url.endsWith("&")) {
            sb.append("&");
        }
        sb.append("code=").append(code).append("&connect_redirect=1#wechat_redirect");
        return RedirectUtil.build(sb.toString());
    }


}
