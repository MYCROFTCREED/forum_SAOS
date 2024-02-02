La seguente applicazione fornisce all'utente un sito web nel quale creare e condividere dei topic. 

Per poter accedere al sito è necessario essere in possesso di un account GitHub al fine di eseguire correttamente l'autenticazione al sistema tramite quest'ultimo.

Dopo aver eseguito il login sarà visibile l'homepage con un elenco di tutti i topic. Cliccandoci sopra sarà possibile legger il contenuto. 
Oltre la visualizzazione globale è possibile filtrare e vedere unicamente i topic creati dall'utente loggato tramite il pulsante nella homepage my topic. 

Infine è presente anche una funzionalità per l'inserimento dei topic, accessibile tramite la home page cliccando il pulsante new topic.


### DATABASE 
```
Il database utilizzato è mySql.

Il nome del db dovrà essere "forum".

All'interno del file application.properties sono presenti i seguenti campi che andranno popolati con le credenziaLi del proprio database:

spring.datasource.username={nome_utente}
spring.datasource.password={password}

Per far funzionare correttamente il database bisogna creare la seguente tabella.

create table topic
(
    title   varchar(256) not null,
    email   varchar(256) not null,
    content varchar(256) null,
    primary key (title, email)
);
```
### OAuth2 
```
per generare clientid e secret compatibili con l'app è necessario:
avere un profilo github
eseguire il login
entrare in "settings"
"developer settings"
"oauth apps"
"new oauth app"

le impostazioni da inserire saranno le seguenti:

Application name:
forum

Homepage URL:
http://localhost:8081/login

Authorization callback URL:
http://localhost:8081/homepage

```
### OAuth2 modifica parametri nel codice
```
E' necessario inserire il client id e il client secret generati da github dei seguenti file 

HomePage.vue
LoginForum.vue
NewTopic.vue
TopicContent.vue

al posto del placeholder_oauth2

```

### Avvio applicazione

```

Per il corretto funzionamento dell'applicazione è necessario avviare prima il server e successivamente il client.


Assicurarsi che le porte utilizzate siano 8080 per il BE (JAVA) e 8081 per il FE (VUE.JS).

per testare l'applicazione è necessario avviare chrome con i cors disabilitati.

Per farlo basta cliccare win + R, 
incollare quanto segue: chrome.exe --user-data-dir="C://Chrome dev session" --disable-web-security
cliccare invio.

L'entry point dell'applicazione è il link: http://localhost:8081/login

```