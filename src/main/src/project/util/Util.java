package project.util;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Util {
    public static String getString(HttpServletRequest request, String param) {
        return request.getParameter(param);
    }

    public static Integer getInteger(HttpServletRequest request, String param) {
        Integer result = null;
        try {
            result = Integer.parseInt(request.getParameter(param));
        } catch (NumberFormatException ignored) {
        }
        return result;
    }

    public static Long getLong(HttpServletRequest request, String param) {
        Long result = null;
        try {
            result = Long.parseLong(request.getParameter(param));
        } catch (NumberFormatException ignored) {
        }
        return result;
    }

    public static Double getDouble(HttpServletRequest request, String param) {
        Double result = null;
        try {
            result = Double.parseDouble(request.getParameter(param));
        } catch (NumberFormatException ignored) {
        }
        return result;
    }

    public static Date getDate(HttpServletRequest request, String param) {
        java.sql.Date result = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = null;
        try {
            parsed = format.parse(request.getParameter(param));
        } catch (ParseException ignored) {
        }

        if (parsed != null) {
            result = new java.sql.Date(parsed.getTime());
        }
        return result;
    }
}
