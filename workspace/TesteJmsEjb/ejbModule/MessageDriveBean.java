import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig={
		@ActivationConfigProperty(propertyName="destinationLookup", propertyValue="jms/TOPICO.LIVRARIA"),
		@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Topic"),
		@ActivationConfigProperty(propertyName="subscriptionDurability", propertyValue="Durable")
})
public class MessageDriveBean implements MessageListener{

	@Override
	public void onMessage(Message msg) {
		TextMessage textMessage = (TextMessage) msg;
		try {
			System.out.println("Mensagem recebida: "+textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
