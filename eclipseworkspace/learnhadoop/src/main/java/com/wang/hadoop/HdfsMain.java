package com.wang.hadoop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

/**
 * 
 * @author wang
 *
 */
public class HdfsMain {
	static Configuration conf = null;
	static FileSystem hdfs = null;
	static {
		conf = new Configuration();
		conf.set("dfs.replication", "3");
		try {
			hdfs = FileSystem.get(new URI("hdfs://172.18.0.2:9000"), conf, "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
		//fileList();
		//printConfig();
		CopyToLocalFile();
	}

	private static void CopyFromLocalFile() throws IOException {
		Path dstPath = new Path("/E/developerpackage/hadoop-2.6.1-by-wangshuang.tar.gz");
		Path srcPath = new Path("/sandbox/wang/hadoop-2.6.1-by-wangshuang.tar.gz");
		hdfs.copyToLocalFile(srcPath, dstPath);
	}
	
	private static void CopyToLocalFile() throws IOException {
		Path dstPath = new Path("/home/wang/桌面/hadoop-2.6.1-by-wangshuang.tar.gz");
		Path srcPath = new Path("/sandbox/wang/hadoop-2.6.1-by-wangshuang.tar.gz");
		hdfs.copyToLocalFile(srcPath, dstPath);
		System.out.println();
	}
	
	private static void printConfig() {
		Configuration configuration=new Configuration();
		Iterator<Entry<String, String>> iterator = configuration.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			
		}
	}

	private static void fileList() throws IOException, InterruptedException, URISyntaxException, FileNotFoundException {
		RemoteIterator<LocatedFileStatus> fileLists = hdfs.listFiles(new Path("/"), true);
		while (fileLists.hasNext()) {
			LocatedFileStatus locatedFileStatus = fileLists.next();
			String fileType = "-";
			System.out.println(fileType);
			String authority = locatedFileStatus.getPermission().toString();
			System.out.println(authority + "\t");
			String user = locatedFileStatus.getOwner();
			System.out.println(user + "\t");

			long size = locatedFileStatus.getLen();
			System.out.println(size + "\t");
			long date = locatedFileStatus.getModificationTime();
			System.out.println(date + "\t");
			String path = locatedFileStatus.getPath().toString();
			System.out.println(path + "\t");
			System.out.println();

			for (BlockLocation blockLocation : locatedFileStatus.getBlockLocations()) {
				System.out.println("CachedHosts:");
				for (String hosts : blockLocation.getCachedHosts()) {
					System.out.println(hosts + ",");
				}
				
				System.out.println("Hosts:");
				for (String hosts : blockLocation.getHosts()) {
					System.out.println(hosts + ",");
				}
				System.out.println();
				System.out.println("block size: ");
				System.out.println(blockLocation.getLength());
				System.out.println("block start offset: ");
				System.out.println(blockLocation.getOffset());
				System.out.println("---------------------------------------");
				System.out.println(blockLocation);
			}
		}
	}
}
