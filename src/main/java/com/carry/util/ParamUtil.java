package com.carry.util;

import java.util.List;

/**
 * Created by Seven on 17/8/6.
 */
public class ParamUtil {

    public static String list2String(List<Long> ids){
        StringBuffer result = new StringBuffer();

        if (null == ids || ids.isEmpty()) {
            return result.toString();
        } else {
            for (Long id : ids) {
                result.append("" + id + ",");
            }
        }

        return result.toString().substring(0, result.length() - 1);
    }
}
