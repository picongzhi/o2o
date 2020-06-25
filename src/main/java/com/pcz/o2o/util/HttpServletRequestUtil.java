package com.pcz.o2o.util;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * @author picongzhi
 */
public class HttpServletRequestUtil {
    public static int getInt(HttpServletRequest request, String key) {
        try {
            return Integer.decode(request.getParameter(key));
        } catch (Exception e) {
            return -1;
        }
    }

    public static long getLong(ServletRequest request, String key) {
        try {
            return Long.decode(request.getParameter(key));
        } catch (Exception e) {
            return -1L;
        }
    }

    public static double getDouble(ServletRequest request, String key) {
        try {
            return Double.valueOf(request.getParameter(key));
        } catch (Exception e) {
            return -1.0;
        }
    }

    public static boolean getBoolean(ServletRequest request, String key) {
        try {
            return Boolean.valueOf(request.getParameter(key));
        } catch (Exception e) {
            return false;
        }
    }

    public static String getString(ServletRequest request, String key) {
        try {
            String result = request.getParameter(key);
            if (result != null) {
                result = result.trim();
            }

            if ("".equals(result)) {
                result = null;
            }

            return result;
        } catch (Exception e) {
            return null;
        }
    }
}
