package com.libraryapp.library.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.libraryapp.library.borrow.Borrow;
import com.libraryapp.library.borrow.BorrowRepository;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

@Component
public class FineCron {

    private final BorrowRepository borrowRepository;

    private Double finePerDayPLN = 2.0;

    @Autowired
    public FineCron(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;

        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Scheduled(fixedDelay = 20000)
    public void increaseFine() {

        NBPcurrency NBPcurrency = new NBPcurrency();

        Double currencyRate = 0.0;

        try {
            HttpResponse<NBPcurrency> httpResponse = Unirest.get("http://api.nbp.pl/api/exchangerates/rates/A/{code}?format=json")
                    .routeParam("code", "eur")
                    .asObject(NBPcurrency.class);
            NBPcurrency = httpResponse.getBody();
            currencyRate = NBPcurrency.getRates().get(0).getMid();
        } catch (UnirestException e) {
            e.printStackTrace();
            return;
        }

        LocalDate currentDate = LocalDate.now();

        List<Borrow> borrows = borrowRepository.findAllByRequiredReturnDateBefore(currentDate);

        Double finalCurrencyRate = currencyRate;
        borrows.forEach(b -> {
            if (b.isActive()){
                Long daysOfDelay = ChronoUnit.DAYS.between(b.getRequiredReturnDate(), currentDate);

                b.setFine(finalCurrencyRate * daysOfDelay * finePerDayPLN);

                try {
                    borrowRepository.save(b);
                } catch (Exception e) {
                    System.out.println("Error during saving borrow to db");
                    e.printStackTrace();
                }
            }
        });
    }
}
