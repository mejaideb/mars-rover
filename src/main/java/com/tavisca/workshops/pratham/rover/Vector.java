package com.tavisca.workshops.pratham.rover;

import java.security.InvalidParameterException;
import java.util.HashMap;

public class Vector {
    public final int x;
    public final int y;
    public final char direction;

    public Vector(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Vector left() {
//        char dir=0;
//        switch(direction){
//
//            case 'N':dir='W';break;
//            case 'E':dir='N';break;
//            case 'W':dir='S';break;
//            case 'S':dir='E';break;

        return new Vector(this.x, this.y, leftMap.get(this.direction));
    }

    public Vector right() {
        return new Vector(this.x, this.y, rightMap.get(this.direction));
    }

    private static HashMap<Character, Character> leftMap = new HashMap<>() {{
        put('N', 'W');
        put('W', 'S');
        put('S', 'E');
        put('E', 'N');
    }};
    private static HashMap<Character, Character> rightMap = new HashMap<>() {{
        put('N', 'E');
        put('W', 'N');
        put('S', 'W');
        put('E', 'S');
    }};

    public Vector OneMove() {
        switch (direction) {
            case 'N':
                return new Vector(x, y + 1, 'N');
            case 'E':
                return new Vector(x + 1, y, 'E');
            case 'W':
                return new Vector(x - 1, y, 'N');
            case 'S':
                return new Vector(x, y - 1, 'N');
            default:
                throw new InvalidParameterException("Invalid direction: " + direction);
        }
    }


}
