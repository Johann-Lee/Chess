package com.chess.model;

public class Player {

    private String username;

    public Player(String username)
    {
        this.username=username;
    }

    public String getUsername()
    {
        return this.username;
    }


    /**
     * This function creates a unique hashcode to distinguish between two player objects
     * @return int - hashcode
     */
    @Override
    public int hashCode()
    {
        int hash=7;
        for(int i=0; i<username.length();i++)
        {
            hash=hash*31+username.charAt(i);
        }

        return hash;
    }

    /**
     * This function compares to player objects and returns a boolean whether they are equal or not.
     * @param obj Player obj to be compared to
     * @return boolean
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj==this)
            return true;

        if(!(obj instanceof Player))
            return false;

        final Player that = (Player) obj;
        return this.username.compareTo(that.username)==0;

    }
}
