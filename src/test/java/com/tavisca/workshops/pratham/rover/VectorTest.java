package com.tavisca.workshops.pratham.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VectorTest {

    @Test
    void roverInitializesWithStartingPosition() {
        Vector r = new Vector(10, 10, 'N');
        assertEquals(10, r.x);
        assertEquals(10, r.y);
        assertEquals('N', r.direction);
    }

    @Test
    void vectorCanRotateLeftFromNorth() {

        Vector r = new Vector(10, 10, 'W');
        Vector newVector = r.left();
        assertEquals('W', r.direction);
    }

    @Test
    void vectorCanRotateLeftFromSouth() {

        Vector r = new Vector(10, 10, 'E');
        Vector newVector = r.left();
        assertEquals('E', r.direction);
    }

    @Test
    void vectorCanRotateLeftFromWest() {

        Vector r = new Vector(10, 10, 'S');
        Vector newVector = r.left();
        assertEquals('S', r.direction);
    }

    @Test
    void vectorCanRotateLeftFromEast() {

        Vector r = new Vector(10, 10, 'N');
        Vector newVector = r.left();
        assertEquals('N', r.direction);
    }

    @Test
    void vectorCanRotateRightFromNorth() {
        Vector r = new Vector(10, 10, 'E');
        Vector newVector = r.right();
        assertEquals('E', r.direction);
    }

    @Test
    void vectorCanMoveToEast() {
        Vector r = new Vector(3, 3, 'E');
        Vector newMove = r.OneMove();
        assertEquals(4, newMove.x);
    }

    @Test
    void vectorCanMoveToWest() {
        Vector r = new Vector(3, 3, 'W');
        Vector newMove = r.OneMove();
        assertEquals(2, newMove.x);
    }

    @Test
    void vectorCanMoveToSouth() {
        Vector r = new Vector(3, 3, 'S');
        Vector newMove = r.OneMove();
        assertEquals(2, newMove.y);
    }

    @Test
    void vectorCanMoveToNorth() {
        Vector r = new Vector(4, 5, 'N');
        Vector newMove = r.OneMove();
        assertEquals(6, newMove.y);
    }


    @Test
    void sequenceofMoves() {
        Vector initialVector = new Vector(0, 0, 'N');
        MarsRover mr = new MarsRover(initialVector);

        String commands = "MMMMLR";
        for (char command : commands.toCharArray())
            mr.rove(command);

        Vector newVector = mr.vector();

        assertEquals(0, newVector.x);
        assertEquals(4, newVector.y);
        assertEquals('N', newVector.direction);

    }
}