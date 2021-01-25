package com.tenk.milion.Repository;

import com.tenk.milion.Models.Currency;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ApiRepo {

    private List<Currency> db = new ArrayList<>();

    public List<Currency> getAll() {
        return db;
    }

    public void add(Currency currency) {
        db.add(currency);
    }
}
