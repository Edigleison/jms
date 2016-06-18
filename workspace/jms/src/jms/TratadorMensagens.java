package jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TratadorMensagens implements MessageListener{

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
