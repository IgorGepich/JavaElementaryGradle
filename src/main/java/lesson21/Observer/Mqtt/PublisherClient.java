package lesson21.Observer.Mqtt;

import lesson21.Observer.IObserver;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.ArrayList;
import java.util.List;

public class PublisherClient implements IObserver {
	private List<String> mqttSeconds = new ArrayList<>();

	@Override
	public void onHandleEvent(int second) {
		try {
			mqttSeconds.add("Mqtt second: " + second);
			IMqttClient publisher = new MqttClient("tcp://77.122.9.2:1883", "TestSecondMqtt");
			publisher.connect();
			MqttMessage message = new MqttMessage();
			for (int i = 0; i < mqttSeconds.size(); i ++) {
			message.setPayload(mqttSeconds.toString()
					.getBytes());
			}
			publisher.publish("SecondTopic", message);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}
}
