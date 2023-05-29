

import com.mongodb.*;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;

public class Employee {

	public static void main(String[] args) {
		//creating mongodb client
		try
		{
MongoClient mongo = new MongoClient( "localhost" , 27017 );
// Accessing the database 
DB db = mongo.getDB("giraffe"); 
DBCollection mc = db.getCollection("student");
//insert data in collection

BasicDBObject d1=new BasicDBObject("Name", "Bunny").append("usn", "01").append("age","22");
BasicDBObject d2=new BasicDBObject("Name", "kajal").append("usn","02").append("age", "23");

BasicDBObject d3=new BasicDBObject("Name", "asha").append("usn","03").append("age", "24");

mc.insert(d1);
mc.insert(d2);
mc.insert(d3);

//display data
System.out.println("after inserting");
DBCursor c1=mc.find();
while(c1.hasNext())
{
	System.out.println(c1.next());
}
//remove
BasicDBObject r1=new BasicDBObject("Name","Bunny");
mc.remove(r1);

System.out.println("after removing");
c1=mc.find();
while(c1.hasNext())
{
	System.out.println(c1.next());
}
}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
