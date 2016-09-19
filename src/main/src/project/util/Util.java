package project.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 15.08.2016.
 */
public class Util {
    public static String getString(HttpServletRequest request, String param) {
        String value = request.getParameter(param);
        return value;
    }

    public static Integer getInteger(HttpServletRequest request, String param) {
        String s = request.getParameter(param);
        Integer result = null;
        try {
            result = Integer.parseInt(s);
        } catch (NumberFormatException ignored) {
        }
        return result;
    }

    public static Double getDouble(HttpServletRequest request, String param) {
        String s = request.getParameter(param);
        Double result = null;
        try {
            result = Double.parseDouble(s);
        } catch (Exception ignored) {
        }
        return result;
    }
}
