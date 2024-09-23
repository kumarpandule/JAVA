function sellTickets(ticketType, numTickets, ticketInventory) {
    for (let ticket of ticketInventory) {
        if (ticket.ticketType === ticketType) {
            const availableTickets = ticket.count - ticket.sold;
            if (numTickets <= availableTickets) {
                ticket.sold += numTickets;
                const remainingTickets = ticket.count - ticket.sold;

                if (remainingTickets === 0) {
                    ticket.status = 'sold-out';
                } else if (remainingTickets < 10) {
                    ticket.status = 'few-left';
                } else {
                    ticket.status = 'available';
                }

                return true;
            } else {
                return false;
            }
        }
    }
    return false;
}

// Example usage:
const ticketInventory = [
    { ticketType: 'vip', price: 100, count: 50, sold: 25, status: 'available' },
    { ticketType: 'general', price: 60, count: 120, sold: 33, status: 'available' }
];

const result = sellTickets('vip', 5, ticketInventory);
console.log(result); // Output: true
console.log(ticketInventory); // Updated inventory