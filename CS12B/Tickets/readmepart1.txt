Name: Joshua Alvarado
Date: 2/14/17
PA3 Part 1

  My Part 1 of PA3 entailed that I design a class hierarchy of different types
of tickets using superclasses and subclasses in order to eliminate code
redundancy and practice proper code reuse. First, I created the main
superclass, RegularTicket, which solely had the number value of the ticket
in the constructor, as well as a price and String representation method for the
object. The WalkupTicket is a subclass of RegularTicket, which differs in
price ($10 more) and the String representation indicating it is a walk up
ticket. The AdvanceTicket is a subclass of RegularTicket as well, which differs
in the constructor as it also includes the amount of days in advance the ticket
was purchased, the price since it is dependent on the amount of days in advance
the client purchased the ticket, and the String representation including how
many days in advance it was purchased in. The final ticket object, in which
being StudentAdvanceTicket, is a subclass of AdvanceTicket, which is a subclass
of RegularTicket. StudentAdvanceTicket differs as the price for the client is
cut in half, not matter how many days in advance it was purchased in. The client
code TestTicket creates an array of size 15, which is then populated with
different ticket objects in corresponding indices. Also, the client code, takes
the array of tickets and prints each tickets String representation, as well as
calculating the total profit of all tickets, then printing it.
