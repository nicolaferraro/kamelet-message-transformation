# Kamelet Message Transformation

This example shows how the Kamelet can be used for doing single message transformation.

The repo contains:
- `simulation-source`: a Kamelet that produces JSON data
- `log-sink`: a Kamelet that shows the content of the messages in the flow
- `insert-field`: a Kamelet that transforms an in-flow message by adding a specific field

## Running

Create the Kamelets:

```
kubectl apply -f simulation-source.kamelet.yaml
kubectl apply -f log-sink.kamelet.yaml
kubectl apply -f insert-field.kamelet.yaml
```

Create a plain binding:

```
kubectl apply -f flow-binding-plain.yaml
```

This should print a JSON with two fields. To see it:

```
kamel logs flow-binding
```

Augment the binding with a new field:

```
kubectl apply -f flow-binding-transformed.yaml
```

Now the JSON should have three fields. To see it:

```
kamel logs flow-binding
```

Example:

```

[2] 2021-03-15 14:20:19,558 INFO  [info] (Camel (camel-1) thread #0 - timer://tick) Exchange[Id: 47468FEDB70046B-0000000000000008, ExchangePattern: InOnly, Properties: {CamelTimerCounter=9, CamelTimerFiredTime=Mon Mar 15 14:20:19 GMT 2021, CamelTimerName=tick, CamelTimerPeriod=1000, CamelToEndpoint=log://info?showAll=true, field=team, value=Fuse}, Headers: {Content-Type=application/json, firedTime=Mon Mar 15 14:20:19 GMT 2021}, BodyType: byte[], Body: {"name":"Nicola Ferraro","username":"nicolaferraro","team":"Fuse"}]
```
