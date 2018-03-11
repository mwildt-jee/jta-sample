# JTA Sample

Diese Projekt dient der beispielhaften Implementierung der Transaktionssteuerung mit CDI und JPA bzw. JTA.

Folgende Stragegieen werden implementiert:

1. Application-Managed Persistence
2. Container-Managed Persistence


## Aufgaben

### Aufgabe 1
Erstellen Sie eine Implementierung des GuestbookRepository, welches unter verwendung con JPA die Datenbank zugreift.

### Aufgabe 2
Konfigurieren und Implentieren Sie eine Lösung mit Transaction-Handling, welche auf der Standalone Variante und RESOURCE_LOCAL basiert 

### Aufgabe 3 
Verwenden Sie zur Steuerung der Transaction JTA unter @Inject der UserTransaction

### Aufgabe 4
Implementieren Sie eine einfachen Interceptor für das Binding @WithTransaction, welcher eine Transaction startet und diese auch commitet oder zurückrollt.

### Aufgabe 5
Steuern die die Transaction mithilfe der JTA-Annotation @Transactional.