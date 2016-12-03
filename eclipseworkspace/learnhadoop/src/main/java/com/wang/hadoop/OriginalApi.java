package com.wang.hadoop;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

public class OriginalApi {
	private static FileSystem fileSystem;

	@Before
	public void init() throws Exception {
		fileSystem = FileSystem.get(new URI("hdfs://172.18.0.2:9000"), new Configuration(), "root");
	}

	@Test
	public void getFileByHdfsStream() throws Exception {
		FSDataInputStream fsDataInputStream = fileSystem
				.open(new Path("/sandbox/wang/hadoop-2.6.1-by-wangshuang.tar.gz"));
		FileOutputStream fileOutputStream = new FileOutputStream(new File("/home/wang/桌面/hadoop.tar.gz"));
		IOUtils.copyBytes(fsDataInputStream, fileOutputStream, 4096);

	}

	@Test
	public void getFileByHdfsStreamAndRandomRead() throws Exception {
		FSDataInputStream fsDataInputStream = fileSystem
				.open(new Path("/sandbox/wang/hadoop-2.6.1-by-wangshuang.tar.gz"));
		fsDataInputStream.seek(134217728);
		FileOutputStream fileOutputStream = new FileOutputStream(new File("/home/wang/桌面/hadoop.tar.gz.block2"));
		IOUtils.copyBytes(fsDataInputStream, fileOutputStream, 1024, true);

	}

	@Test
	public void getFileByHdfsSreamAndReadBlock1() throws Exception {
		FSDataInputStream fsDataInputStream = fileSystem
				.open(new Path("/sandbox/wang/hadoop-2.6.1-by-wangshuang.tar.gz"));
		FileOutputStream fileOutputStream = new FileOutputStream(new File("/home/wang/桌面/hadoop.tar.gz.block1"));
		long offset = 0;
		byte[] b = new byte[4096];
		while (fsDataInputStream.read(offset, b, 0, 4096) != -1) {
			if (offset >= 134217728) {
				return;
			}
			fileOutputStream.write(b);
			offset += 4096;
		}
	}
}
