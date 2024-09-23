package org.example.Factories;

import org.example.AbstractFactory;
import org.example.Furniture;
import org.example.Sofa.ArtDecoSofa;
import org.example.Sofa.ModernSofa;
import org.example.Sofa.VictorianSofa;
import org.example.Type;

public class SofaFactory implements AbstractFactory {
    @Override
    public Furniture createFurniture(Type type) {
        if (type == Type.ArtDeco) return new ArtDecoSofa();
        if (type == Type.Victorian) return new VictorianSofa();
        if (type == Type.Modern) return new ModernSofa();
        return null;
    }
}
