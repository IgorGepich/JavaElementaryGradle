package lesson21.Observer.Mqtt;

import lesson21.Observer.IObserver;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class PublisherClient implements IObserver {

	IMqttClient publisher;
	public void createMqttClient(){
		try {
			publisher = new MqttClient("tcp://77.122.9.2:1883", "TestSecondMqtt");
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onHandleEvent(int second) {
		try {
			IMqttClient publisher = new MqttClient("tcp://77.122.9.2:1883", "TestSecondMqtt");
			publisher.connect();
			MqttMessage message = new MqttMessage();
			publisher.publish("SecondTopic", message);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}
}
