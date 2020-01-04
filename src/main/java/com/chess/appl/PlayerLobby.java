package com.chess.appl;

import com.chess.model.Player;

import java.util.HashMap;
import java.util.LinkedList;

public class PlayerLobby {
    private LinkedList<Player> lobby;

    public PlayerLobby()
    {
        this.lobby=new LinkedList<Player>();
    }


    /**
     * This function adds a player to the linked list of players.
     * @param player
     * @return
     */
    public boolean addPlayer(Player player) {


        //todo - throw an error or exception or whatever it is


        if (this.lobby.contains(player)) {
            System.out.println(player.getUsername() + "is already signed in");
            return false;
        }
        else {
            this.lobby.add(player);
            System.out.println("Added player "+player.getUsername());
            return true;
        }
    }

    public boolean signOut(Player player)
    {
        if(this.lobby.contains(player)) {
            this.lobby.remove(player);
            return true;
        }
        else
            return false;
    }

    public int playerCount()
    {
        return this.lobby.size();
    }

    public LinkedList getPlayers()
    {
        return this.lobby;
    }



}
