
# Beispiel-Implamentierung

### Bauen der einzelnen Artefakte

```shell
mvn clean install -f template
mvn clean install -f producer
mvn clean install -f consumer
```

### Starten der Umgebung

Vorbereitung: unter /tmp das Verzeichnis "payara-apps" erstellen.
Dieses Verzeichnis enthält die Artefacte, die beim Payara-Start automatisch deployt werden.

```shell
docker-compose -f docker-payara up -d
docker-compose -f docker-kafka up -d
```

### Deployen der Artefakte

```shell
./script/deploy.sh deploy template-web.war
./script/deploy.sh deploy producer-web.war
./script/deploy.sh deploy consumer-web.war
```

Wenn bereits ein Artefakt deployt ist muss statt "deploy" "redeploy" verwendet werden.
Mit "undeploy" wird das Artefakt entfernt.

Beim Deployen der Artefakte mit dem Script werden die Artefacte auch in /tmp/payara-apps abgelegt,
damit sie beim Neustart automatisch deployt werden.

### Beispielaufruf

```shell
curl http://localhost:5080/thaso/sample/producer/api/greeting
```
