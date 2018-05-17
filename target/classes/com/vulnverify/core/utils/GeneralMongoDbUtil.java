package com.vulnverify.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.validation.constraints.Null;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.model.Filters;

/**
 * MongoDB 工具类
 * 方便进行文件的上传与下载
 * 共提供上传、下载、删除文件工具类
 * 
 * @author LiuFeng
 * @since 20170517
 */
public class GeneralMongoDbUtil {

	private final static Properties PROPERTIES = new Properties();
	private final static Logger logger = LoggerFactory.getLogger(GeneralMongoDbUtil.class);

	static {
		try {
			URL url = GeneralMongoDbUtil.class.getClassLoader().getResource("mongodb.properties");
			if (url != null) {
				logger.info("Found 'mongodb.properties' file in local classpath");
				InputStream inputStream = url.openStream();
				try {
					PROPERTIES.load(inputStream);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					inputStream.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("Could not load 'mongo_db.properties' file from local classpath: " + e);
		}
	}

	public GeneralMongoDbUtil() {
	}

	private static class Config {

		/**
		 * MongoDB connection properties
		 */
		public static String ip = null;
		public static int port = 27017;
		public static String database = null;

		/**
		 * MongoDB connection pool properties
		 */
		public static int connectionsPerHost = 10;
		public static int maxWaitTime = 120000;
		public static int connectTimeout = 0;
		public static boolean socketKeepAlive = true;
		public static int socketTimeout = 150000;

		public static MongoClientOptions mongoClientOptions = null;

		/**
		 * 用户及凭证
		 */
		public static List<MongoCredential> credentialList = new ArrayList<MongoCredential>();

		static {
			ip = PROPERTIES.getProperty("mongoip");
			port = Integer.parseInt(PROPERTIES.getProperty("mongoport"));
			database = PROPERTIES.getProperty("mongodatabase");

			connectionsPerHost = Integer.parseInt(PROPERTIES.getProperty("connections_per_host"));
			maxWaitTime = Integer.parseInt(PROPERTIES.getProperty("max_wait_time"));
			connectTimeout = Integer.parseInt(PROPERTIES.getProperty("connect_timeout"));
			socketKeepAlive = true;
			socketTimeout = 150000;

			mongoClientOptions = MongoClientOptions.builder()
					.connectTimeout(connectTimeout)
					.maxWaitTime(maxWaitTime)
					.connectionsPerHost(connectionsPerHost)
					.socketKeepAlive(socketKeepAlive)
					.socketTimeout(socketTimeout)
					.build();

			/**
			 * 认证与凭证
			 * 
			 */
			MongoCredential credential = MongoCredential.createCredential(
					PROPERTIES.getProperty("mongo_user"), database,
					PROPERTIES.getProperty("mongo_pass").toCharArray());

			credentialList.add(credential);

		}
	}

	private static final class MongoInstance {
		public final static MongoClient client;
		static {
			// client = new MongoClient(new ServerAddress(Config.ip,
			// Config.port), Config.credentialList, Config.mongoClientOptions);
			client = new MongoClient(new ServerAddress(Config.ip, Config.port), Config.mongoClientOptions);
		}
	}

	/**
	 * destroy pool
	 */
	public static final void destroy() {
		MongoInstance.client.close();
	}

	/**
	 * get a MongoDatabase
	 * 
	 * @return
	 */
	public static MongoDatabase getDatabase() {
		return MongoInstance.client.getDatabase(Config.database);
	}
	
	public static MongoDatabase getGridFsDatabase() {
		return MongoInstance.client.getDatabase("gridfs");
	}

	/**
	 * get a MongoDatabase by Name
	 * 
	 * @param databaseName
	 * @return
	 */
	public static MongoDatabase getDatabase(String databaseName) {
		return MongoInstance.client.getDatabase(databaseName);
	}

	// //////////////////以下为上传内容//////////////////////////////

	/**
	 * 上传文件 到 MongoDB
	 * 
	 * @param destinationName
	 * @param inputStream
	 * @return
	 */
	public static String uploadFileToGridFS(String destinationName, InputStream inputStream, String bucketName) {
		/**
		 * 缺省桶名是 fs
		 */
		GridFSBucket bucket = GridFSBuckets.create(getDatabase(), bucketName);
		ObjectId fileId = bucket.uploadFromStream(destinationName, inputStream);
		return fileId.toHexString();
	}

	/**
	 * 上传文件 到 MongoDB，可以选择关闭流
	 * 
	 * @param destinationName
	 * @param inputStream
	 * @param close
	 * @return
	 */
	public static String uploadFileToGridFS(String destinationName, InputStream inputStream, String bucketName, boolean close) {
		String fileId = null;
		try {
			fileId = uploadFileToGridFS(destinationName, inputStream, bucketName);
		} finally {
			if (close) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.info("close inputstream fail:" + e);
				}
			}
		}
		return fileId;
	}

	/**
	 * 上传文件 到 MongoDB，参数为 File
	 * 
	 * @param destinationName
	 * @param file
	 * @return
	 */
	public static String uploadFileToGridFs(String destinationName, File file, String bucketName) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			String fileId = uploadFileToGridFS(destinationName, inputStream, bucketName, true);
			return fileId;
		} catch (IOException e) {
			logger.info("upload fail:" + e);
		}
		return null;
	}

	/**
	 * 上传文件 到 MongoDB，文件名不变上传
	 * 
	 * @param file
	 * @return
	 */
	public static String uploadFileToGridFs(File file, String bucketName) {
		return uploadFileToGridFs(file.getName(), file, bucketName);
	}

	/**
	 * 上传文件 到 MongoDB，文件名加入UUID
	 * 
	 * @param file
	 * @return
	 */
	public static String uploadFileToGridFSByUUID(File file, String bucketName) {
		return uploadFileToGridFs(UUID.randomUUID().toString(), file, bucketName);
	}

	// //////////////////以下为下载内容//////////////////////////////
	
	/**
	 * 通过 文件名 从MongoDB 下载文件
	 * 
	 * @param sourceName
	 * @param outputStream
	 */
	public static void downloadFileByName(String sourceName, OutputStream outputStream, String bucketName) {
		GridFSBucket bucket = GridFSBuckets.create(getDatabase(), bucketName);
		bucket.downloadToStream(sourceName, outputStream);

	}

	/**
	 * 通过 objectid 从MongoDB 下载文件
	 * 
	 * @param objectId
	 * @param outputStream
	 */
	public static void downloadFile(String objectId, OutputStream outputStream, String bucketName) {
		/**
		 * 缺省桶名是 fs
		 */
		GridFSBucket bucket = GridFSBuckets.create(getDatabase(), bucketName);
		bucket.downloadToStream(new ObjectId(objectId), outputStream);
	}
	
	/**
	 * 从mongodb获取文件名称
	 * @param objectId
	 * @param outputStream
	 * @param 文件名称
	 */
	public static String getFileName(String objectId, String bucketName) {
		GridFSBucket bucket = GridFSBuckets.create(getDatabase(), bucketName);
		String fileName = bucket.find(Filters.eq("_id",new ObjectId(objectId))).first().getFilename();
		return fileName;
	}
	
	/**
	 * 通过 objectid 从MongoDB 下载文件
	 * 
	 * @param objectId
	 * @param outputStream
	 */
	public static String downloadTaskResultFile(String objectId, OutputStream outputStream) {
		/**
		 * 缺省桶名是 fs
		 */
		GridFSBucket bucket = GridFSBuckets.create(getGridFsDatabase(), "bucketme");
		String fileName = bucket.find(Filters.eq("_id",new ObjectId(objectId))).first().getFilename();
		bucket.downloadToStream(new ObjectId(objectId), outputStream);
		return fileName;
	}
	
	/**
	 * 通过 objectid 从MongoDB 下载文件
	 * 
	 * @param objectId
	 * @param destinationFile
	 */
	public static void downloadFile(String objectId, File destinationFile, String bucketName) {
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(destinationFile);
			downloadFile(objectId, outputStream, bucketName);
		} catch (IOException e) {
			logger.info("download fail:" + e);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					logger.info("close outputstream fail:" + e);
				}
			}
		}
	}

	/**
	 * 通过 objectid 从MongoDB 下载文件
	 * 
	 * @param objectId
	 * @param destinationName
	 */
	public static void downloadFile(String objectId, String destinationName, String bucketName) {
		File destinationFile = new File(destinationName);
		downloadFile(objectId, destinationFile, bucketName);
	}


	/**
	 * 通过 objectId 从MongoDB 删除文件
	 * 
	 * @param objectId
	 */
	public static void deleteByObjectId(String objectId, String bucketName) {
		GridFSBucket bucket = GridFSBuckets.create(getDatabase(), bucketName);
		bucket.delete(new ObjectId(objectId));
	}

}


