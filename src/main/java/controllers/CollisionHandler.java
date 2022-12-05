package controllers;

import UI.presenters.ViewModel;
import entities.character.Character;

import java.awt.*;

/**
 * An abstract class outlining Collision handling methodology
 */
public abstract class CollisionHandler {
    protected Rectangle self;
    protected Character character;
    public CollisionHandler(Rectangle rectangle, Character character){
        self = rectangle;
        this.character = character;
    }
    public abstract void handleCollision(Rectangle object);
}
