package org.example.Factories;

import org.example.AbstractFactory;
import org.example.Chair.ArtDecoChair;
import org.example.Chair.ModernChair;
import org.example.Chair.VictorianChair;
import org.example.Furniture;
import org.example.Type;

public class ChairFactory implements AbstractFactory {

    @Override
    public Furniture createFurniture(Type type) {
        if (type == Type.ArtDeco) return new ArtDecoChair();
        if (type == Type.Victorian) return new VictorianChair();
        if (type == Type.Modern) return new ModernChair();
        return null;
    }

}
