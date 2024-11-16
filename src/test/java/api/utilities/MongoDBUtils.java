package api.utilities;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class MongoDBUtils {
	private static final String CONNECTION_STRING = "mongodb://localhost:27017"; // Replace with your MongoDB URI
	private static MongoClient mongoClient;

	static {
		mongoClient = MongoClients.create(CONNECTION_STRING);
	}

	public static MongoDatabase getDatabase(String dbName) {
		return mongoClient.getDatabase(dbName);
	}

	public static List<Document> getCollectionData(String dbName, String collectionName) {
		MongoDatabase database = getDatabase(dbName);
		MongoCollection<Document> collection = database.getCollection(collectionName);
		return StreamSupport.stream(collection.find().spliterator(), false).collect(Collectors.toList());
	}

	public static void closeConnection() {
		mongoClient.close();
	}
}
