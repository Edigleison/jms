import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

//@Singleton
//@Startup
public class EnviadorMensagemEJB {

//	@Schedule(hour="*", minute="*", second="0")
	public void enviarMensagem(){
		System.out.println("executou");
	}
}
