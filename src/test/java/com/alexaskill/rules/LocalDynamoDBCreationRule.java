package com.alexaskill.rules;

import org.junit.rules.ExternalResource;

/**
 * Creates a local DynamoDB instance for testing.
 */
public class LocalDynamoDBCreationRule extends ExternalResource {

//    private DynamoDBProxyServer server;
//    private AmazonDynamoDB amazonDynamoDB;
//
    public LocalDynamoDBCreationRule() {
        // This one should be copied during test-compile time. If project's basedir does not contains a folder
        // named 'native-libs' please try '$ mvn clean install' from command line first
        //System.setProperty("sqlite4java.library.path", "native-libs");
    }
//
//    @Override
//    protected void before() {
//
//        try {
//            final String port = "8000";
//            this.server = ServerRunner.createServerFromCommandLineArgs(new String[]{"-inMemory", "-port", port});
//            server.start();
//
//            amazonDynamoDB = new AmazonDynamoDBClient(new BasicAWSCredentials("user", "password"));
//            amazonDynamoDB.setEndpoint("http://localhost:" + port);
//            amazonDynamoDB.setRegion(Region.getRegion(Regions.EU_CENTRAL_1));
//
//            createTable(amazonDynamoDB, "TheUniverseMessages", "group", "timestamp");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    protected void after() {
//
//        if (server == null) {
//            return;
//        }
//
//        try {
//            server.stop();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public AmazonDynamoDB getAmazonDynamoDB() {
//        return amazonDynamoDB;
//    }
//
//    private static CreateTableResult createTable(AmazonDynamoDB ddb, String tableName, String hashKeyName, String rangeKey) {
//        List<AttributeDefinition> attributeDefinitions = new ArrayList<>();
//        attributeDefinitions.add(new AttributeDefinition(hashKeyName, ScalarAttributeType.S));
//        attributeDefinitions.add(new AttributeDefinition(rangeKey, ScalarAttributeType.N));
//
//        List<KeySchemaElement> ks = new ArrayList<>();
//        ks.add(new KeySchemaElement(hashKeyName, KeyType.HASH));
//        ks.add(new KeySchemaElement(rangeKey, KeyType.RANGE));
//
//        ProvisionedThroughput provisionedthroughput = new ProvisionedThroughput(5L, 5L);
//
//        CreateTableRequest request =
//                new CreateTableRequest()
//                        .withTableName(tableName)
//                        .withAttributeDefinitions(attributeDefinitions)
//                        .withKeySchema(ks)
//                        .withProvisionedThroughput(provisionedthroughput);
//
//        return ddb.createTable(request);
//    }
}