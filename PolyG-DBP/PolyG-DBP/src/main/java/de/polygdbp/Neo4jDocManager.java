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
import java.io.IOException;

/**
 *
 * @author Tim Niehoff, Hyeon Ung Kim
 */
public class Neo4jDocManager {
  
  /**
   *
   */
  public static void startMongoConnector(){
   ProcessBuilder pb = new ProcessBuilder("mongo-connector", "-m","localhost:27017","-t", "http://localhost:7474/db/data", "-d", "neo4j_doc_manager", "--verbose");  
    pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
    pb.redirectError(ProcessBuilder.Redirect.INHERIT);
    try {
      Process p = pb.start();
    } catch (IOException ex) {
      LOG.error(ex);
    }
  }
}
