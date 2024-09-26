configurazione PC con programmi

Servlet:

 - accesso al database con DAO usando DataSource
 - Prima ho provato l'accesso al database con DAO direttamente da
   applicazione Java perché la servlet non funzionava
 - ho configurato Tomcat
 - ho creato la classe per gestire i documenti XML
 - Servlet accede al DB tramite classe DAO e crea XML
 - entry point 	
	 - xml	 	
	 - getall 	
	 - getid 	
	 - insert  	
	 - delete
	 - List item
 - ottimizzato manageXML
 - su  index messo aggiungi e modifica

installato GitHub Desktop

 2 agosto venerdì ripasso Laravel passport per accesso Auth2.0 e accesso a 2 DB 

riparato il DB dava tabelle danneggiate 

lunedì 

 - iniziato Spring con JPA i controller non funzionavano sotto i package
   e altri errori sconosciuti

martedi  
 - sistemare Spring iniziare Front End

mercoledi
 - aggiunta la funzione update in spring e sistemato react da errori sconosciuti sto cercando di far apparire il form per l'update
	ripasso props state

giovedi 8-8
 - react correzione form studio test per javascript e junit

venerdi 9-8
 - studiato test per React e Spring ho realizzato test per le API di Spring 

 26 - 30 Java:
 	 studiato i EJB ho ripreso il progetto spring JPA, ho visto myBatis per sommi capi 
	- Php: ripassato PHP Laravel per vedere come fare per gestire due DB in parallelo
  
  - 1 - 4 settebre ripasso PHP / Laravel con autenticazione Passport Jetstream e gestione più DB con mysql e sqlite  
		database funzioni procedure viste normalizzazione 

	5 settembre studio jasper jsxml

	6 - 10 settembre studio stream pdf - csv - xls 

	10 settembre 
		Progetto Spring per gestione articoli cancelleria 

		tabelle :
			articolo
			categorie
			magazzino

		dipendenze 
		
			-spring-boot-starter-web
			-mysql-connector-j
			-spring-boot-starter-data-jpa
      		-spring-boot-starter-tomcat

			eventualmente librerie per report internamente 
			(fatto) csv  
			pdf

	12 settembre

		aggiunta cartella magazzino finito metodo per esport csv 

	13 - 14 settembre aggiunto warehouse e category entity con join sia con annotation che con query native 
	
	16 settembre hibernate non fa una vera join ma fa due select e unisce i risultati quindi sto modificando il progetto per usare quary native

	17 settembre inizio la creazione dei test junit e validazione ( per evitare campi vuoti )

	18  settembre provo a creare validazioni di spring studiando due progetti esempio

		https://github.com/spring-guides/gs-validating-form-input/tree/main 
		https://journaldev.nyc3.cdn.digitaloceanspaces.com/spring/SpringFormValidation.zip
	24 implementato entity Dto aggiornata documentazione ho cercato di strutturare le api e iniziato i test
	
	25 junit test iniziato le correzioni e formattazione output
	
	26 corretto database danneggiato riprendo la correzione e realizzazione test

		note varie
		Spring studiato Bean e connessione configurazione per mappare package
		@ConfigurationPropertiesScan({ "it.mdg.learnJpa.entity","it.mdg.learnJpa.service","it.mdg.learnJpa.component" })

		per output XML invece di Json nella classe entity
		// Importing required classes
		import lombok.Data;
 		// Annotation
		@Data
		

