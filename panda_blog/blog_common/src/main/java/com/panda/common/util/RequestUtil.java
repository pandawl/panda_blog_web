package com.panda.common.util;

import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * request参数处理工具类
 *
 * @version 1.0
 */
public final class RequestUtil {
    private RequestUtil() {
    }

    public static int getIntParameter(final HttpServletRequest request, final String name, final int defaultVal) {
        return ServletRequestUtils.getIntParameter(request, name, defaultVal);
    }

    public static float getFloatParameter(final HttpServletRequest request, final String name, final int defaultVal) {
        return ServletRequestUtils.getFloatParameter(request, name, defaultVal);
    }

    public static String getStringParameter(final HttpServletRequest request, final String name, final String defaultVal) {
        return ServletRequestUtils.getStringParameter(request, name, defaultVal);
    }

    public static long getLongParameter(final HttpServletRequest request, final String name, final long defaultVal) {
        return ServletRequestUtils.getLongParameter(request, name, defaultVal);
    }

    public static boolean getBooleanParameter(final HttpServletRequest request,
                                              final String name,
                                              final boolean defaultVal) {
        return ServletRequestUtils.getBooleanParameter(request, name, defaultVal);
    }

    public static int getIntParameter(final HttpServletRequest request, final String name) {
        return getIntParameter(request, name, 0);
    }

    public static long getLongParameter(final HttpServletRequest request, final String name) {
        return getLongParameter(request, name, 0L);
    }

    public static String getStringParameter(final HttpServletRequest request, final String name) {
        return getStringParameter(request, name, null);
    }

    public static int[] getIntParameters(final HttpServletRequest request, final String name) {
        return ServletRequestUtils.getIntParameters(request, name);
    }

    public static short getShortParameter(HttpServletRequest request, String name, int defaultVal) {
        return (short) ServletRequestUtils.getIntParameter(request, name, defaultVal);
    }

    /**
     * 获取客户端真实的IP地址
     *
     * @param request 请求
     * @return
     */
    public static String getIpAddr(final HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.indexOf(",") > -1) {
            return ip.split(",")[0].trim();
        }

        return ip;
    }

    /**
     * 获取客户端真实的MAC地址
     *
     * @param
     * @return
     */
    public static String getMACAddress(final String ip) throws Exception {
        String line = "";
        String macAddress = "";
        final String MAC_ADDRESS_PREFIX = "MAC Address = ";
        final String LOOPBACK_ADDRESS = InetAddress.getLocalHost().getHostAddress();
        //如果本地MAC地址。
        if (LOOPBACK_ADDRESS.equals(ip)) {
            InetAddress inetAddress = InetAddress.getLocalHost();
            byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            //下面代码是把mac地址拼装成String
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                if (i != 0) {
                    sb.append("-");
                }
                //mac[i] & 0xFF 是为了把byte转化为正整数
                String s = Integer.toHexString(mac[i] & 0xFF);
                sb.append(s.length() == 1 ? 0 + s : s);
            }
            //把字符串所有小写字母改为大写成为正规的mac地址并返回
            macAddress = sb.toString().trim().toUpperCase();
            return macAddress;
        }
        //获取非本地IP的MAC地址
        Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
        InputStreamReader isr = new InputStreamReader(p.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        while ((line = br.readLine()) != null) {
            if (line != null) {
                int index = line.indexOf(MAC_ADDRESS_PREFIX);
                if (index != -1) {
                    macAddress = line.substring(index + MAC_ADDRESS_PREFIX.length()).trim().toUpperCase();
                }
            }
        }
        br.close();
        return macAddress;
    }

    /**
     * 获取客户端真实的端口号
     *
     * @param request 请求
     * @return
     */
    public static int getPort(final HttpServletRequest request) {
        int port = request.getRemotePort();
        return port;
    }


    /**
     * 获取所有request请求参数key-value
     *
     * @param request
     * @return
     */
    public static Map<String, String> getRequestParams(final HttpServletRequest request) {

        final Map<String, String> params = new HashMap<String, String>();
        if (null != request) {
            final Set<String> paramsKey = request.getParameterMap().keySet();
            for (final String key : paramsKey) {
                params.put(key, request.getParameter(key));
            }
        }
        return params;
    }

    /**
     * 如果是int类型的，那么正常返回包装类，否则，返回null
     *
     * @param request
     * @param name
     * @return
     * @author wangzhankui
     * @date 2017年12月9日
     * @see
     */
    public static Integer getIntegerParameterNullable(final HttpServletRequest request, final String name) {

        try {
            return ServletRequestUtils.getIntParameter(request, name);
        } catch (final Throwable e) {
            return null;
        }
    }

    public static Long getLongParameterNullable(final HttpServletRequest request, final String name) {
        try {
            return ServletRequestUtils.getLongParameter(request, name);
        } catch (final Throwable e) {
            return null;
        }
    }

    public static Short getShortParameterNullable(final HttpServletRequest request, final String name) {
        final String stringParameter = getStringParameter(request, name, "");
        try {
            return Short.valueOf(stringParameter);
        } catch (final Throwable e) {
            return null;
        }
    }

    /**
     * 从流中获取请求的参数
     *
     * @param request 请求
     * @return
     */
    public static  String getParmsByReader(HttpServletRequest request) {

        String str, wholeStr = "";
        try {
            System.out.println("获取reader之前");
            BufferedReader br = request.getReader();
            System.out.println("获取reader之后");
            System.out.println("reader:"+br);
            while ((str = br.readLine()) != null) {
                wholeStr += str;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wholeStr;
    }
}
