package jms;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.naming.InitialContext;

public class EnviadorParaFila {

	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		
		Queue queue = (Queue) ic.lookup("jms/FILA.GERADOR");
		
		JMSContext jmsContext = factory.createContext("jms", "jms");		
		JMSProducer producer = (JMSProducer) jmsContext.createProducer();
		
		producer.send(queue, "teste");
		
		jmsContext.close();
		ic.close();
	}
}
