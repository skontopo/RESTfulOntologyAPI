import org.apache.jena.query.*;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;
import java.util.Iterator;

/**
 * Created by Isai B. Cicourel - see https://www.codementor.io/@isaib.cicourel/sparql-query-using-endpoints-101-du10884g8
 */
public class QueryEngine {

    //Query an Endpoint using the given SPARQl query
    public String queryEndpoint(String szQuery, String szEndpoint) {

        // Create a Query with the given String
        Query query = QueryFactory.create(szQuery);

        // Create the Execution Factory using the given Endpoint
        QueryExecution qexec = QueryExecutionFactory.sparqlService(szEndpoint, query);

        // Set Timeout
        ((QueryEngineHTTP)qexec).addParam("timeout", "10000");

        // Execute Query
        String result = ""; // The result is a long string but could be anything else, like e.g. an ArrayList of objects
        ResultSet rs = qexec.execSelect();
        while (rs.hasNext()) {
            // Get Result
            QuerySolution qs = rs.next();

            // Get Variable Names
            Iterator<String> itVars = qs.varNames();

            // Display Result
            while (itVars.hasNext()) {
                String szVar = itVars.next();
                String szVal = qs.get(szVar).toString();

                result += "[" + szVar + "]: " + szVal + "\n";
            }
        }
        return result;
    }

    // Submit a query with a given parameter
    public String query (String name) {
        // SPARQL Query
        String szQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX ex: <http://example.org/employees#>\n" +
                "select ?s ?p ?o where { \n" +
                "    ?s ?p ?o .\n" +
                "\t?s rdf:type ex:Employee .\n" +
                "    ?s ex:hasName ?n .\n" +
                "    FILTER regex(?n, \"" + name + "\") .\n" +
                "}";

        //String szEndpoint = "http://dbpedia.org/sparql"; //DBpedia Endpoint
        String szEndpoint = "http://192.168.1.3:7200/repositories/de4a"; //Local triplestore

        // Query the endpoint
        return queryEndpoint(szQuery, szEndpoint);
    }
}