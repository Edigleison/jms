package jms;

import java.util.Scanner;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.naming.InitialContext;

public class RegistraTratadorMensagensTopico {

	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		Topic topic = (Topic) ic.lookup("jms/TOPICO.LIVRARIA");
		
		JMSContext jmsContext = factory.createContext("jms", "jms");
		jmsContext.setClientID("Financeiro2");
		JMSConsumer consumer = jmsContext.createDurableConsumer(topic, "AssinaturaNotas");
		consumer.setMessageListener(new TratadorMensagens());
		jmsContext.start();
		
		Scanner teclado = new Scanner(System.in);
		
		teclado.nextLine();
		
		teclado.close();
		jmsContext.stop();
	}
}
