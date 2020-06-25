package com.pcz.o2o.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
    public static boolean checkVerifyCode(HttpServletRequest request) {
        String expectedVerifyCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String inputVerifyCode = HttpServletRequestUtil.getString(request, "verifyCode");
        return inputVerifyCode != null &&
                inputVerifyCode.equalsIgnoreCase(expectedVerifyCode);
    }
}
