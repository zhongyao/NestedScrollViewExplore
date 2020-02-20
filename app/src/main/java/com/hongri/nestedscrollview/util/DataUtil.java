package com.hongri.nestedscrollview.util;

import java.util.ArrayList;

/**
 *
 * @author zhongyao
 * @date 2020-02-20
 */
public class DataUtil {

    public static ArrayList<String> getListData() {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add("Android " + i);
        }

        return list;
    }
}
