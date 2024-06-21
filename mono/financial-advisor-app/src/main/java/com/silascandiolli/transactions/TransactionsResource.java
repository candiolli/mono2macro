package com.silascandiolli.transactions;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("transactions")
public class TransactionsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transactions> findAll() {
        return Transactions.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Transactions findById(@PathParam("id") Long id) {
        return Transactions.findById(id);
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Transactions save(Transactions transactions) {
        transactions.id = null;
        transactions.persist();
        return transactions;
    }
}
