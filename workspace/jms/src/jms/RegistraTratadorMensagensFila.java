package jms;

import java.util.Scanner;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.InitialContext;

public class RegistraTratadorMensagensFila {

	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		Queue queue = (Queue) ic.lookup("jms/FILA.GERADOR");
		
		JMSContext jmsContext = factory.createContext("jms", "jms");
		JMSConsumer consumer = jmsContext.createConsumer(queue);
		consumer.setMessageListener(new TratadorMensagens());
		jmsContext.start();
		
		Scanner teclado = new Scanner(System.in);
		teclado.nextLine();
		
		teclado.close();
		jmsContext.stop();
		
	}
}
