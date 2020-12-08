# RESTfulOntologyAPI

This repository contains sample code demonstrating the creation of a RESTful API for accessing an ontology residing in a triplestore.


## Components

The diagram below illustrates the key components in the current implementation:

<p align="center">
  <img align="center" src="/src/main/resources/RESTfulOntologyAPI.png">
</p>


* **RESTful API implementation**: Based on [Spark](https://sparkjava.com/), it starts a RESTful server accepting requests at the specified endpoints.
* **Query Engine**: Based on [Apache Jena](https://jena.apache.org/), it converts the request to a (parameterized) SPARQL query.
* **Triplestore**: Used for storing and accessing the ontology by exposing a SPARQL endpoint. Can be any RDF triplestore, like e.g. [Ontotext's GraphDB](https://www.ontotext.com/products/graphdb/). 
* **Ontology**: A `.ttl` or `.owl` ontology, containing schema and data. Sample ontology is available in folder `src\main\resources`.


## Usage

Run `Main.java` in order to start the server on the defined port. By default Spark runs on port `4567`, but the code manually sets the port to `8080`.
