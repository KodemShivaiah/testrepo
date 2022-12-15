package com.jdbc.example;

import com.jdbc.example.model.Book;
import com.jdbc.example.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JdbcExampleServiceApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JdbcExampleServiceApplication.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("namedParameterJdbcBookRepository")
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(JdbcExampleServiceApplication.class);
    }

    @Override
    public void run(String... args){
        log.info("Start Application....");
        //runJdbc();
        //Read properties file automatically
    }

    private void runJdbc() {
        log.info("Creating table for testing");
        //drop table if table already exist
        jdbcTemplate.execute("DROP TABLE IF EXISTS books");
        //create table after drop table
        jdbcTemplate.execute("CREATE TABLE books (" +
                "id SERIAL, name varchar(255), price numeric(15,2))");
        //create books list for inserting purpose
        List<Book> books = Arrays.asList(
                Book.builder().name("Thinking in Java").price(BigDecimal.valueOf(34.23)).build(),
                Book.builder().name("MyBook In Java").price(BigDecimal.valueOf(54.43)).build(),
                Book.builder().name("Getting Closure").price(BigDecimal.valueOf(321.2)).build(),
                Book.builder().name("Head First Android Devepment").price(BigDecimal.valueOf(343.33)).build()
        );
        log.info("[SAVE]");
        books.forEach(book -> {
            log.info("Saving...{}", book.getName());
            bookRepository.save(book);
        });

        //count of books
        log.info("[COUNT] Total books: {}", bookRepository.count());

        //find all
        log.info("[FIND_ALL] {}", bookRepository.findAll());

        //find by Id
        log.info("[FIND_BY_ID] : 2L");
        Book book = bookRepository.findById(2L).orElseThrow(IllegalArgumentException::new);
        log.info("{}",book);

        //find by name and price
        log.info("[FIND_BY_NAME_AND_PRICE] : like  '%Java%' and price <= 100");
        log.info("{}", bookRepository.findByNameAndPrice("Java", new BigDecimal(100)));

        //get name(string) by id
        log.info("[GET_NAME_BY_ID] :1L = {}", bookRepository.getNameById(1L));

        //update
        log.info("[UPDATE] 2L: 99.99");
        book.setPrice(BigDecimal.valueOf(99.99));
        log.info("row affected : {}", bookRepository.update(book));

        //delete
        log.info("[DELETE] :3L");
        log.info("rows affected : {}", bookRepository.deleteById(3L));

        //find all
        log.info("[FIND_ALL] {}", bookRepository.findAll());

    }

}
