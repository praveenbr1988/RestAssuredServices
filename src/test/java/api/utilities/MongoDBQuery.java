package api.utilities;

import com.google.gson.Gson;
import org.bson.Document;

import java.util.List;

public class MongoDBQuery {
	public static String getCollectionDataAsJson(String dbName, String collectionName) {
		List<Document> documents = MongoDBUtils.getCollectionData(dbName, collectionName);
		Gson gson = new Gson();
		return gson.toJson(documents);
	}
}
