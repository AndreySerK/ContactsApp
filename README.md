## Contacts manager
This is the small console training app

Available commands for user:

- SHOW -> prints current list of contacts;
- ADD -> adds contact to the current list;
- REMOVE -> removes contact from the current list by user's email;
- SAVE -> saves current list of contacts to file; 
- EXIT -> finishes execution;


=== Download and run:

git clone https://github.com/AndreySerK/ContactsApp

cd */ContactsApp

mvn package    # To create jar file

java -jar */target/contacts-1.0-SNAPSHOT.jar – spring.profiles.active=default    # To run this service with deafult profile

java -jar */target/contacts-1.0-SNAPSHOT.jar – spring.profiles.active=init     # To run this service with init profile (contacts will be loaded form init file)
