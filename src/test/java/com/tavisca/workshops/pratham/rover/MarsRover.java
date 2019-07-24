package com.tavisca.workshops.pratham.rover;

public class MarsRover {
    private Vector vector;

    public MarsRover(Vector initialVector) {
        vector = initialVector;
    }


    public void rove(char command) {
        switch (command) {
            case 'M':
                vector = vector.OneMove();
                break;
            case 'R':
                vector = vector.right();
                break;
            case 'L':
                vector = vector.left();
                break;
        }

//        return vector;
    }

    public Vector vector(){
        return vector;
    }
}
