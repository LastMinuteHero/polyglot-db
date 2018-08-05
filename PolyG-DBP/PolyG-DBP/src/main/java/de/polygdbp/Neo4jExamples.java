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

import static de.polygdbp.Main.LOG;

/**
 * Contains all hard-coded querying examples for the Neo4j to make Querying easier. 
 * They refer to the <code>Yelp Dataset</code>.
 */
public class Neo4jExamples {
  // Output me all business names and ids a <specific user> rated with minumum of <stars>
//  private final String q1 = "MATCH (u:user)--(r:review)--(b:business) where u._id=\"nOTl4aPC4tKHK35T3bNauQ\" and r.stars > 4 return b.name, b._id";
  private final String q1 ="MATCH (u:User)-[:WROTE]-(r:Review)-[:REVIEWS]-(Business) WHERE u.id = 'nOTl4aPC4tKHK35T3bNauQ' AND r.stars > 4 Return Business.name, Business.id";
  
  //Output the average stars of all businesses
  //private final String q2 = "match (b:business) return avg(b.stars)";
  private final String q2 = "MATCH (b:Business) return avg(b.stars)";
  
  //Output the average stars of all businesses that grouped by category
  private final String q3 = "MATCH (b:Business)--(c:Category) return c.id, avg(b.stars)";
  
  //Output all businesses that are in the category Cannabis Tours and return the average of all stars grouped by all the categories that they are in
  private final String q4 = "MATCH (c1:Category)--(Business)--(c2:Category) WHERE c1.id ='Cannabis Tours' RETURN c2.id, avg(Business.stars)";
  
  /**
   * Get the Query by the related shortcut.
   * @param q Shortcut for the Query. Valid Example: "q1".
   * @return Query result in String.
   */
  public String getQuery(String q) {
    switch(q) {
    case "q1": return q1;
    case "q2": return q2; 
    case "q3": return q3;
    case "q4": return q4;
    case "qa": return "";
    default: {
      LOG.error("Could not find query for Neo4j.");
      System.exit(-1);
    }
    }
    return q;
  }
}
