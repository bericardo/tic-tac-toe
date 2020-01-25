package com.ricardo.tictactoe.unit;

import com.ricardo.tictactoe.shape.Circle;
import com.ricardo.tictactoe.shape.Cross;
import com.ricardo.tictactoe.shape.IShape;
import org.junit.Assert;
import org.junit.Test;

public class TestShape {

    @Test
    public void testCompareReturnTrueWhenShapesEqual(){
        IShape cross1 = new Cross();
        IShape cross2 = new Cross();

        boolean isEqual = cross1.compare(cross2);

        Assert.assertEquals(true, isEqual);
    }

    @Test
    public void testCompareReturnFalseWhenShapesDifferent(){
        IShape cross = new Cross();
        IShape circle = new Circle();

        boolean isEqual = cross.compare(circle);

        Assert.assertEquals(false, isEqual);
    }
}
