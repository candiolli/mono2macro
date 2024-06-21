package com.silascandiolli.transactions;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class TransactionsCategory extends PanacheEntity {

    public String name;
}
