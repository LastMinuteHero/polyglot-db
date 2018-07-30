/*
 * Copyright 2018 Tim Niehoff, Hyeon Ung Kim.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.polygdbp;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Tim Niehoff, Hyeon Ung Kim
 */
public class MongoAPI {
  private MongoClient mongoClient;
  private MongoDatabase mongoDb;
  private MongoCollection<Document> currentMongoCollection;

  public MongoAPI(String database) {
    this.mongoClient = new MongoClient();
    this.mongoDb = mongoClient.getDatabase(database);
    this.currentMongoCollection = null;
  }

  public MongoCollection<Document> getCurrentMongoCollection() {
    return currentMongoCollection;
  }

  public void setCurrentMongoCollection(String currentMongoCollection) {
    this.currentMongoCollection = mongoDb.getCollection(currentMongoCollection);
  }
  
  
  
  
  

}