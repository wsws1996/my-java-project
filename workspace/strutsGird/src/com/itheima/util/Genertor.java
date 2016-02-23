package com.itheima.util;

import java.io.File;

public class Genertor {
	public static String genChildDir(String root, String filename) {
		int hashCode = filename.hashCode();
		int dir1 = hashCode & 0xf;
		int dir2 = (hashCode & 0xf0) >> 4;
		String dir=dir1+File.separator+dir2;
		File file=new File(root,dir);
		if (!file.exists()) {
			file.mkdirs();
		}
		return dir;
	}
}
