package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/** 
 * @author  wenchen 
 * @date 创建时间：2017年12月16日 下午12:29:44 
 * @version 1.0
 * 说明：
 * 	MongoDB连接助手 
 * @parameter
 */
public class MongoHelper {
	
	private static MongoClient mongoClient;
	
	private MongoHelper (){}
	
	public static MongoClient getMongoConnection (){
		if (mongoClient == null){
			InputStream in = MongoHelper.class.getResourceAsStream("/Mongo.properties");
			Properties p = new Properties();
			try {
				p.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (in != null){
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			List<ServerAddress> addressList = new ArrayList<ServerAddress>();
			ServerAddress address = new ServerAddress(p.getProperty("server_ip"),Integer.parseInt(p.getProperty("server_port")));
			addressList.add(address);
			List<MongoCredential> credentials = new ArrayList<MongoCredential>();
			MongoCredential credential = MongoCredential.createScramSha1Credential(p.getProperty("auth_name"), p.getProperty("auth_db"), p.getProperty("auth_pwd").toCharArray());
			credentials.add(credential);
			MongoClientOptions.Builder build = new MongoClientOptions.Builder();
			build.connectionsPerHost(Integer.valueOf(p.getProperty("maxConnect")));  
	        build.threadsAllowedToBlockForConnectionMultiplier(Integer.valueOf(p.getProperty("maxWaitThread")));  
	        build.connectTimeout(Integer.valueOf(p.getProperty("maxTimeOut")) * 1000);  
	        build.maxWaitTime(Integer.valueOf(p.getProperty("maxWaitTime")) * 1000);  
	        MongoClientOptions options = build.build();  
			mongoClient = new MongoClient(addressList,credentials,options);
		}
		return mongoClient;
	}
	
	public static void main(String[] args) {
		MongoClient mongo = MongoHelper.getMongoConnection();
		MongoDatabase db = mongo.getDatabase("user");
		MongoCollection<Document> collection = db.getCollection("user");
		BasicDBObject filter = new BasicDBObject();
		filter.append("_id", new ObjectId("5a3336647d0e5b2c2c0c78c5"));
		FindIterable<Document> iterables = collection.find(filter);
		MongoCursor<Document> cursor = iterables.iterator();
		List<Document> results = new ArrayList<Document>();
		while (cursor.hasNext()) {
            results.add(cursor.next());
        }
		System.out.println(results);
	}
	
}
