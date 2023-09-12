package uk.gov.dwp.uc.pairtest;

import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;
import uk.gov.dwp.uc.pairtest.exception.InvalidPurchaseException;
import

public class TicketServiceImpl implements TicketService {
    /**
     * Should only have private methods other than the one below.
     */


    @Override
    public void purchaseTickets(Long accountId, TicketTypeRequest... ticketTypeRequests) throws InvalidPurchaseException {
        if (accountId < 0){// if invalid account ID
            throw InvalidPurchaseException;
        }
        if (ticketTypeRequests.length > 20){
            throw InvalidPurchaseException;
        }
        boolean adult = false;
        int total_price = 0;
        int total_seats = 0;
        for (TicketTypeRequest ticket:ticketTypeRequests) {
            if (ticket.getTicketType() == Type.ADULT){
                total_price += 20 * ticket.getNoOfTickets();
                total_seats += ticket.getNoOfTickets();
                adult = true;
            } else if (ticket.getTicketType() == Type.CHILD) {
                total_price += 10 * ticket.getNoOfTickets();
                total_seats += ticket.getNoOfTickets();
            }
        }
        if (adult == false){// If no adult tickets are bought
            throw InvalidPurchaseException;
        }

        //import and call seat reservation

        //import and call payment






    }

    //Think about tests
    //Check for invalid ID
    //Check for length of ticket list
    //Check to see if infant/child tickets are bought with adult ones
    //Test for actual use

}
