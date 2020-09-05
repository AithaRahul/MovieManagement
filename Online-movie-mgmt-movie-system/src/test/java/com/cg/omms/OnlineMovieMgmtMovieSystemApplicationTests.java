package com.cg.omms;

 

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

 

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

 

import com.cg.omms.dao.MovieDao;
import com.cg.omms.entity.Movie;
import com.cg.omms.exception.MovieException;

import antlr.collections.List;

 

@SpringBootTest
class OnlineMovieMgmtMovieSystemApplicationTests {
    
    @Autowired
    MovieDao movieDao;

 

    @Test
    void testFindMovieById() throws MovieException {
        Movie movie = movieDao.findMovieById(1001);
        assertNotNull(movie);
    }
    @Test
    void testFindMovieByDiffId() throws MovieException{
    	Movie movie = movieDao.findMovieById(1006);
    	assertNull(movie);
    }
    @Test
    void testDeleteMovieById() throws MovieException {
        Movie movie = movieDao.deleteMovieById(1010);
        assertNull(movie);
    }  

}