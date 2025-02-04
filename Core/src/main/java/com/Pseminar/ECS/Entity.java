package com.Pseminar.ECS;

import java.util.List;
import java.util.ArrayList;

/**
*Klasse Entity ist Container für verschiedene Components
*welche ihr eigenschaften und Verhaltensweisen verleihen
*(z.B.kann ein Component ein PositionsComponent sein, was die Position definiert)
*/
@SuppressWarnings("unused")
public class Entity {
    private int id;
    private List<Component> components;

    private Scene scene;//Szene zu der die Entity gehört
    public Transform transform;

    /**
    *Konstruktor erstellt eine neue Entity mit einer ID
    *leere Liste der Components wird initialisiert
    */
    public Entity() {
        this.id = Scene.CreateEntityId();
        this.transform = new Transform();
        this.components = new ArrayList<>();
    }
    
    //legt fest zu welcher Szene die Entity angehört
    public final void SetScene(Scene scene){
        this.scene = scene;
    }

    public int getId() {
        return id;
    }

    public void AddComponent(Component component) {
        component.setEntity(this);
        components.add(component);

        this.scene.RegisterComponentInTypeComponentMap(component);
    }

    public List<Component> getComponents() {
        return components;
    }

}
