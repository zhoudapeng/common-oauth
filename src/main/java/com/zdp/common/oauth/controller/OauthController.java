package com.zdp.common.oauth.controller;

import com.zdp.common.oauth.RedirectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URLEncoder;

/**
 * @author <a href="mailto:zhoudapeng8888@126.com">zhoudapeng</a>
 * Date 2018/6/14
 * Time 上午10:30
 */
@Controller
@RequestMapping("/oauth")
public class OauthController implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(OauthController.class);
    @Value("${oauth.domain}")
    private String localDomain;
    private static final String WECHAT_AUTH_CALLBACK_URL = "https://%s/callback/wechat?redirect_url=%s";
    private static final String WECHAT_AUTH_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect";

    @RequestMapping("/wechat")
    public RedirectView wechat(@RequestParam("redirect_url") String redirect_url, @RequestParam("appid") String appid) throws Exception{
        logger.info("receive oauth ,redirect_url=" + redirect_url + ",appid=" + appid);
        String url = String.format(WECHAT_AUTH_CALLBACK_URL,localDomain,URLEncoder.encode(redirect_url,"utf-8"));
        return RedirectUtil.build(String.format(WECHAT_AUTH_URL,appid,URLEncoder.encode(url,"utf-8")));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(localDomain);
    }
}
