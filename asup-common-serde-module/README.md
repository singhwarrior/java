
### MAVEN Dependency
```xml
<!-- For producing Kafka Messages -->
<dependency>
  <groupId>org.apache.kafka</groupId>
  <artifactId>kafka-clients</artifactId>
  <version>2.8.1</version>
</dependency>
<!-- For compilation of protobuf generated files -->
<dependency>
  <groupId>com.google.protobuf</groupId>
  <artifactId>protobuf-java</artifactId>
  <version>3.21.1</version>
</dependency>
<!-- For parsing incoming JSON messages -->
<dependency>
  <groupId>com.googlecode.json-simple</groupId>
  <artifactId>json-simple</artifactId>
  <version>1.1.1</version>
</dependency>
```

### References 
- https://developers.google.com/protocol-buffers/docs/proto3
- 
### Generate Java files from .proto
- Define a schema aggregate.proto 
- Download protoc compiler https://github.com/protocolbuffers/protobuf/releases
- Use following command to generate Protobuf POJO Java files
```shell
$ ./bin/protoc --proto_path=/Users/singg/openws/java/asup-common-serde-module/proto --java_out=/Users/singg/openws/java/asup-common-serde-module/src/main/java /Users/singg/openws/java/asup-common-serde-module/proto/aggregate.proto
```
