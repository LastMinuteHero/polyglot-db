# PolyG-DBP - [PolyG]lot - [D]ata[B]ase[P]erformance
## Big Data Traineeship SuSe 2018

See https://dbs.uni-leipzig.de/study/ss_2018/bigdprak

## Contributor
* Hyeon Ung Kim (LastMinuteHero)
* Tim Niehoff (regexpr)
## Teacher
* J. Zschache

# Requirements
* Maven
* MongoDB
* Neo4J
* Mongo Connector + Neo4j doc manager

You can install mongo connector and neo4j doc manger with 
<pre>
pip install -r utils/pip-requirements.txt   
</pre>

Please visit our Wiki to find out which Versions of the requiremental software we have used:
https://github.com/regexpr/polyglot-db/wiki/

# Installing
<pre>
git clone https://github.com/regexpr/polyglot-db
cd polyglot-db/PolyG-DBP/
mvn install
</pre>

# Run
1. Run one Neo4j database in the background:
<pre>
neo4j/bin/neo4j console
</pre>

2.a Run one mongod replica set in the background
<pre>
mongod --replSet exSet 
</pre>
2.b For the first time, initialize the replica set
<pre>
mongo
rs.initiate()
</pre>

3. Run PolyG-DBP
<pre>
cd polyglot-db/PolyG-DBP/target
java -jar PolyG-DBP-0.1.jar
</pre>

# Usage
* java -jar PolyG-DBP-0.1.jar help:
            Displays this help;
* java -jar PolyG-DBP-0.1.jar list:
            lists all queries provided by PolyG-DBP.;
* java -jar PolyG-DBP-0.1.jar QUERY [Options]
            Benchmark with the given query. Example
            <pre>java -jar PolyG-DBP-0.1.jar q1</pre>
* java -jar PolyG-DBP-0.1.jar custom [Options]
	Benchmark with a custom query from PolyG-DBP. 
            You will be asked to specify your queries for Mongo and Neo4j afterwards.
Example: java -jar PolyG-DBP-0.1.jar custom.
# Options (can be given in any order)
* -i, --inputPath to the directory with JSON file(s). Example: 
<pre>java -jar PolyG-DBP-0.1.jar q1 -i yelp</pre>
* -nb, --neo4jAddressBolt1Adress of the neo4j instance with the bolt address. Example: 
<pre>java -jar PolyG-DBP-0.1.jar q1 -nb localhost:7687</pre>
* -nr, --neo4jAddressRemoteAdress of the neo4j instance with the remote address. Example: 
<pre>java -jar PolyG-DBP-0.1.jar q1 -nr localhost:7474</pre>
* -m, --mongoAddressAdress of the mongodb instance. Example: 
<pre>java -jar PolyG-DBP-0.1.jar q1 -m localhost:27017</pre>
* -md, --mongoDatabaseName of the mongodb database. Example: 
<pre>java -jar PolyG-DBP-0.1.jar q1 -md yelp</pre>
* -r, --reduceImport just a certain amount of lines of each input JSON. Example: 
<pre>java -jar PolyG-DBP-0.1.jar q1 -r 300</pre>
    
 # Available Queries for Yelp Dataset for both Databases:
* q1:	Output all business names and ids a <specific user> rated with minumum of <stars>
* q2:	Output the average stars of all businesses
* q3:	Output the average stars of all businesses that grouped by category
* q4:	Output the average stars of all businesses grouped by category descending order
* q5:	Output all businesses that are in the category Cannabis Tours and return the average of all stars grouped by all the categories that they are in
* q6:	Output all businesses that were reviewed more than 700 times
* q7:	The same query as above, but this time we count the reviews in the reviews collection
* qa:	Run all queries above.

# Furthermore
* Why not testing the efficiency of the neo4j data model created by mongo-connector + neo4j doc manager?
You can import the YELP dataset into the Neo4j directly by inserting the commands given in utils/Neo4jImportYelpJsons.txt into a cypher shell.
