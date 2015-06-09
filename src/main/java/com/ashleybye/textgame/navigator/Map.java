package com.ashleybye.textgame.navigator;

import com.ashleybye.textgame.world.Location;

/**
 * Created by ashley on 08/06/2015.
 */
public class Map
{
    private int xAxisLength;
    private int yAxisLength;
    private Location[][] locations;
    private boolean[][] barriers;
    private int currentX;
    private int currentY;
    
    public Map(int xLength, int yLength) throws IllegalArgumentException
    {
        if ((xLength <= 0) || yLength <= 0)
        {
            throw new IllegalArgumentException("scene grid must have minimum dimensions of 1x1");
        }
        this.locations = new Location[xLength][yLength];
        this.barriers = new boolean[xLength + 1][yLength + 1]; // barriers need 2 more spaces than number of locations
        this.xAxisLength = xLength;
        this.yAxisLength = yLength;
    }

    public int getCurrentX()
    {
        return currentX;
    }

    public int getCurrentY()
    {
        return currentY;
    }

    public void addBarrier(float xPosition, float yPosition)
    {
        // position is valid if it is a whole number or a half number (e.g. 1.0, 1.5, etc)
        // this can be determined by multiplying by 4 (even numbers stay even, hals become whole evens)
        // and checking that there is no remainder (modulus)
        boolean validPositions = ((((xPosition * 4) % 2) == 0) && (((yPosition * 4) % 2) == 0));
        if (validPositions && (xPosition > 0) && (xPosition <= (xAxisLength + 1))
                && (yPosition > 0) && (yPosition <= (yAxisLength + 1)))
        {
            // index to store barrier is calculated by multiplying each position by 2, e.g.
            // barrier at 1.5, 1.0 equates to barriers[3][2] = true;
            int x = (int) (xPosition * 2);
            int y = (int) (yPosition * 2);
            barriers[x][y] = true;
        }
    }

    private boolean isBarrier(int x, int y, Compass direction)
    {
        boolean barrier = false;

        if (direction == Compass.NORTH)
        {
            if (y < (yAxisLength - 1))
            {
                int xPosition = x * 2;
                int yPosition = (int) ((y + 0.5F) * 2);
                barrier = barriers[xPosition][yPosition];
            }
        }
        else if (direction == Compass.EAST)
        {
            if (x < (xAxisLength - 1))
            {
                int xPosition = (int) ((x + 0.5F) * 2);
                int yPosition = y * 2;
                barrier = barriers[xPosition][yPosition];
            }
        }
        else if (direction == Compass.SOUTH)
        {
            if (y > 0)
            {
                int xPosition = x * 2;
                int yPosition = (int) ((y - 0.5F) * 2);
                barrier = barriers[xPosition][yPosition];
            }
        }
        else
        {
            if (x > 0)
            {
                int xPosition = (int) ((x - 0.5F) * 2);
                int yPosition = y * 2;
                barrier = barriers[xPosition][yPosition];
            }
        }

        return barrier;
    }

    public Location[][] getAllLocations()
    {
        return locations;
    }

    public void addLocation(Location location, int xPosition, int yPosition) throws IndexOutOfBoundsException
    {
        if ((xPosition < 0) || (xPosition >= xAxisLength) || (yPosition < 0)
                || (yPosition >= yAxisLength))
        {
            throw new IndexOutOfBoundsException("a location cannot be placed outside of the location grid; grid is "
                        + xAxisLength + "x" + yAxisLength + ", attempted to place location at position ("
                        + xPosition + ", " + yPosition + ")");
        }
        locations[xPosition][yPosition] = location;
    }

    public Location loadLoaction(int xPosition, int yPosition)
    {
        this.currentX = xPosition;
        this.currentY = yPosition;
        return locations[xPosition][yPosition];
    }

    public boolean isLocationAccessibleFrom(int currentX, int currentY, Compass direction)
    {
        boolean accessible = false;

        if (!isBarrier(currentX, currentY, direction))
        {
            switch (direction)
            {
                case NORTH:
                    accessible = (currentY < (yAxisLength - 1)) ? true : false;
                    break;
                case EAST:
                    accessible = (currentX < (xAxisLength - 1)) ? true : false;
                    break;
                case SOUTH:
                    accessible = (currentY > 0) ? true : false;
                    break;
                case WEST:
                    accessible = (currentX > 0) ? true : false;
                    break;
                default:
                    accessible = false;
                    break;
            }
        }

        return accessible;
    }
}
