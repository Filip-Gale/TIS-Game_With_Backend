package hr.tis.academy.command;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
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
}
