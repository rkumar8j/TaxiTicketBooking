package ibm;

import ibm.dao.TaxiTicketDao;
import ibm.handler.TaxiTicketHandler;
import ibm.service.TaxiTicketService;
import ibm.service.TaxiTicketServiceImpl;
import ibm.vo.TaxiTicketRequestVo;
import ibm.vo.TaxiTicketResponseVo;

public class TaxiTicketClient {
	
	static TaxiTicketHandler handler;
	
	//Manual Dependency Injection
	static {
		TaxiTicketDao taxiTicketDao = new TaxiTicketDao();
		TaxiTicketService taxiTicketService = new TaxiTicketServiceImpl(taxiTicketDao);
		handler = new TaxiTicketHandler(taxiTicketService);
	}
	
	public static void main(String[] args) throws Exception {
		
		TaxiTicketRequestVo request = new TaxiTicketRequestVo("PUNE", "NASIK", 2);
		TaxiTicketResponseVo response = handler.generateTicket(request);
		
		System.out.println(response);
	}

}
