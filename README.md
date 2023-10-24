## Contacts manager
This is the small console training app (Java 19+Spring)

Available commands for user:

- SHOW -> prints current list of contacts;
- ADD -> adds contact to the current list;
- REMOVE -> removes contact from the current list by user's email;
- SAVE -> saves current list of contacts to file; 
- EXIT -> finishes execution;


=== Download and run:

git clone https://github.com/AndreySerK/ContactsApp

cd */ContactsApp

mvn clean package          # To create jar file

java -jar –Dspring.profiles.active=default */target/contacts-1.0-SNAPSHOT-jar-with-dependencies.jar   # To run this service with default profile

java -jar –Dspring.profiles.active=init */target/contacts-1.0-SNAPSHOT-jar-with-dependencies.jar    # To run this service with init profile (contacts will be loaded from init file)
