package com.silascandiolli.expenses;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("expenses")
public class ExpensesResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Expenses> orders() {
        return Expenses.listAll();
    }

    @GET @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Expenses findById(@PathParam("id") Long id) {
        return Expenses.findById(id);
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Expenses save(Expenses expenses) {
        expenses.id = null;
        expenses.persist();
        return expenses;
    }
}
