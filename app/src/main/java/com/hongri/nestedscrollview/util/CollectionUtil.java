package com.hongri.nestedscrollview.util;

import java.util.Collection;

/**
 * @author zhongyao
 * @date 2020-02-20
 */
public class CollectionUtil {

    public static boolean isEmpty(Collection<?> container) {
        return container == null || container.isEmpty();
    }
}
