package com.zdp.common.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author <a href="mailto:zhoudapeng8888@126.com">zhoudapeng</a>
 * Date 2018/6/14
 * Time 下午4:09
 */
public class RedirectUtil {
    private static Logger logger = LoggerFactory.getLogger(RedirectUtil.class);

    public static RedirectView build(String url) {
        RedirectView view = new RedirectView(url);
        view.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        logger.info("send redirect to " + url);
        return view;
    }
}
