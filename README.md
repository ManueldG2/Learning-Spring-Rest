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
   -localhost:8080/api/csv (get)
   -localhost:8080/api/articolo (get)
   -localhost:8080/api/articolo/{id} (get)
   
   -localhost:8080/api/articolo/{id} (put)
   -localhost:8080/api/add?title={string}&description={string}&characteristic={string}&category={string}&quantity={string}&unity={string}&code={string}&price={string} 	 (post)

   
   -localhost:8080/api/delete/{id} (post) -> da implementere per richieste json(delete)
   -localhost:8080/api/delete (post) 
