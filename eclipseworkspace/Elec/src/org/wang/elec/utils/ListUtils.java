package org.wang.elec.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ListUtils {

	public static List<String> stringToList(String name, String flag) {
		List<String> list = new ArrayList<String>();
		if (StringUtils.isNotBlank(name)) {
			String[] arrays = name.split(flag);
			if (arrays != null && arrays.length > 0) {
				for (String array : arrays) {
					list.add(array);
				}
			}
		}
		return list;
	}

}
