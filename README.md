Progetto Spring per gestione articoli cancelleria 

tabelle :
			-articolo
			-categorie
			-magazzino (da fare)
   
dipendenze 
		
-spring-boot-starter-web
-mysql-connector-j
-spring-boot-starter-data-jpa
-spring-boot-starter-tomcat

eventualmente librerie per report internamente 
			-(fatto) csv  
			-pdf


   endpoint:
   -localhost:8080/api/csv (get): crea un'esport in csv
   -localhost:8080/api/articolo (get): stampa a video lista articoli in json 
   -localhost:8080/api/articolo/{id} (get): stampa a video l'articolo con id 
   
   -localhost:8080/api/articolo/{id} (put) 
   
   -localhost:8080/api/add?title={string}&description={string}&characteristic={string}&category={string}&quantity={string}&unity={string}&code={string}&price={string}  (post): aggiunge articolo tramite query string per usarlo con form html

   
   -localhost:8080/api/delete/{id} (post) -> da implementere per richieste json(delete)
   -localhost:8080/api/delete (post) 
