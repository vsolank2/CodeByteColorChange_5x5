package com.codebyte.codebytecolorchange;

public class ClsBtnPosition {
    int position;
    int color;
    int oppPosition;
    Boolean click;

    public ClsBtnPosition(int position, int color, int oppPosition, Boolean click) {
        this.position = position;
        this.color = color;
        this.oppPosition = oppPosition;
        this.click = click;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getOppPosition() {
        return oppPosition;
    }

    public void setOppPosition(int oppPosition) {
        this.oppPosition = oppPosition;
    }


}
