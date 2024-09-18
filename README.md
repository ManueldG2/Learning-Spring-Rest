# Progetto Spring per gestione articoli cancelleria 

tabelle :
			- articolo
			- categorie
			- magazzino (fatta warehouse)
   
dipendenze 
		
- spring-boot-starter-web
- mysql-connector-j
- spring-boot-starter-data-jpa
- spring-boot-starter-tomcat
- spring-boot-starter-test
- super-csv
- opencsv
- spring-boot-starter-tomcat
- spring-boot-starter-validation
		

eventualmente librerie per report internamente 
- (fatto) csv  
- pdf


 ## Endpoint article: 
   - localhost:8080/api/article/csv (get): crea un'esport in csv
   
   - localhost:8080/api/article (get): stampa a video lista articoli in json 
   
   - localhost:8080/api/article/{id} (get): stampa a video l'articolo con id 

   - localhost:8080/api/article/join (get): stampa a video lista articoli in json facendo una join sia con warehouse che con category
   
   - localhost:8080/api/article/join/{id} (get): stampa a video articolo di id in json facendo una join sia con warehouse che con category 
   
   - (post): aggiunge articolo tramite query string per usarlo con form html
   - localhost:8080/api/article/add?title={string}&description={string}&characteristic={string}&category={string}&quantity={string}&unity={string}&code={string}&price={string}  
   - localhost:8080/api/article/{id} (put): aggiornamento con json
   - (post): aggiornamento query string    
   - localhost:8080/api/article/update?title={string}&description={string}&characteristic={string}&category={string}&quantity={string}&unity={string}&code={string}&price={string} 
   
   - localhost:8080/api/article/delete/{id} (delete) -> cancella elemento di id

   ### endpoint di test 
   - localhost:8080/api/article/hello (get): restiruisce Hello World con http http status ok
   - localhost:8080/api/article/query?id={string} (get): restiruisce la stampa del valore id

  ## Endpoint: warehouse:
   - localhost:8080/api/warehouse/csv (get): crea un'esport in csv
   - localhost:8080/api/warehouse (get): stampa a video lista articoli in json
   - localhost:8080/api/warehouse/{id} (get): stampa a video l'articolo con id
   - localhost:8080/api/warehouse/join (get): stampa a video lista articoli in json facendo una join sia con warehouse che con category
	- localhost:8080/api/warehouse/join/{id} (get): stampa a video articolo di id in json facendo una join sia con warehouse che con category
	- (post): aggiunge articolo tramite query string per usarlo con form html
   - localhost:8080/api/warehouse/add?title={string}&description={string}&characteristic={string}&category={string}&quantity={string}&unity={string}&code={string}&price={string}
   - localhost:8080/api/warehouse/{id} (put): aggiornamento con json
   - (post): aggiornamento query string
   - localhost:8080/api/update?title={string}&description={string}&characteristic={string}&category={string}&quantity={string}&unity={string}&code={string}&price={string}
   - localhost:8080/api/delete/{id} (delete) -> cancella elemento di id
   ### endpoint di test 
   
   - localhost:8080/api/hello (get): restiruisce Hello World con http http status ok
   - localhost:8080/api/query?id={string} (get): restiruisce la stampa del valore idendpoint: article
   

 create entity warehouse e category con relative CRUD 
 ho provato a usare hibernate ma ho notato che non effettua una join ma due distint select che poi unisce quindi ho preferito creare delle procedure su mysql che richiamo dal repository tramite le query native @query

imparare validation per controllo dei valori nulli sembra funzionare
documentazione consultata
 - https://stackoverflow.com/questions/48508285/how-to-handle-internal-server-error-500-on-spring-rest-api
 - https://salithachathuranga94.medium.com/validation-and-exception-handling-in-spring-boot-51597b580ffd
 - https://github.com/spring-guides/gs-validating-form-input/tree/main
 - https://journaldev.nyc3.cdn.digitaloceanspaces.com/spring/SpringFormValidation.zip

da fare
 - creare test per API 
 


