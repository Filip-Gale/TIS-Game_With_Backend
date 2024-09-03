package hr.tis.academy.command;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;


public class ImageCommand {
    private String text = "Hello TIS";

    @Min(value = 1, message = "Width must be greater than 0")
    private int width;

    @Min(value = 1, message = "Height must be greater than 0")
    private int height;

    @Min(value = 0, message = "Red value must be between 0 and 255")
    @Max(value = 255, message = "Red value must be between 0 and 255")
    private int red;

    @Min(value = 0, message = "Green value must be between 0 and 255")
    @Max(value = 255, message = "Green value must be between 0 and 255")
    private int green;

    @Min(value = 0, message = "Blue value must be between 0 and 255")
    @Max(value = 255, message = "Blue value must be between 0 and 255")
    private int blue;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Min(value = 1, message = "Width must be greater than 0")
    public int getWidth() {
        return width;
    }

    public void setWidth(@Min(value = 1, message = "Width must be greater than 0") int width) {
        this.width = width;
    }

    @Min(value = 1, message = "Height must be greater than 0")
    public int getHeight() {
        return height;
    }

    public void setHeight(@Min(value = 1, message = "Height must be greater than 0") int height) {
        this.height = height;
    }

    @Min(value = 0, message = "Red value must be between 0 and 255")
    @Max(value = 255, message = "Red value must be between 0 and 255")
    public int getRed() {
        return red;
    }

    public void setRed(@Min(value = 0, message = "Red value must be between 0 and 255") @Max(value = 255, message = "Red value must be between 0 and 255") int red) {
        this.red = red;
    }

    @Min(value = 0, message = "Green value must be between 0 and 255")
    @Max(value = 255, message = "Green value must be between 0 and 255")
    public int getGreen() {
        return green;
    }

    public void setGreen(@Min(value = 0, message = "Green value must be between 0 and 255") @Max(value = 255, message = "Green value must be between 0 and 255") int green) {
        this.green = green;
    }

    @Min(value = 0, message = "Blue value must be between 0 and 255")
    @Max(value = 255, message = "Blue value must be between 0 and 255")
    public int getBlue() {
        return blue;
    }

    public void setBlue(@Min(value = 0, message = "Blue value must be between 0 and 255") @Max(value = 255, message = "Blue value must be between 0 and 255") int blue) {
        this.blue = blue;
    }
}
