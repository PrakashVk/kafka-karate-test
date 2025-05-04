Feature: Kafka Integration Test

  Background:
    * def KafkaTestContainer = Java.type('utils.KafkaTestContainer')
    * def KafkaUtils = Java.type('utils.KafkaUtils')
    * eval KafkaTestContainer.start()
    * def bootstrap = KafkaTestContainer.getBootstrapServers()
    * def topic = 'karate-test'
    * def groupId = 'karate-group'

  Scenario: Send and receive message from Kafka
    * def message = 'Hello Kafka!'
    * eval KafkaUtils.sendMessage(topic, message, bootstrap)
    * def received = KafkaUtils.consumeMessage(topic, bootstrap, groupId, 10)
    * match received == message
    * eval KafkaTestContainer.stop()
