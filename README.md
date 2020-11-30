# RESTfulOntologyAPI

This repository contains sample code demonstrating the creation of a RESTful API for accessing an ontology residing in a triplestore.


## Components

The diagram below illustrates the key components in the current implementation:

<img align="left" width="100" height="100" src="/src/main/resources/RESTfulOntologyAPI.png">



![RESTfulOntologyAPI](/src/main/resources/RESTfulOntologyAPI.png)

* **RESTful API implementation**: Based on [Spark](https://sparkjava.com/);
* **Query Engine**: Based on [Apache Jena](https://jena.apache.org/);
* **Triplestore**: Can be any RDF triplestore, like e.g. [Ontotext's GraphDB](https://www.ontotext.com/products/graphdb/), exposing a SPARQL endpoint. 
* **Ontology**: A `.ttl` or `.owl` ontology. Sample ontology is available in folder `src\main\resources`.