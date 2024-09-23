package org.example.Factories;

import org.example.AbstractFactory;
import org.example.CoffeeTable.ArtDecoTable;
import org.example.CoffeeTable.ModernTable;
import org.example.CoffeeTable.VictorianTable;
import org.example.Furniture;
import org.example.Type;

public class CoffeeTableFactory implements AbstractFactory {
    @Override
    public Furniture createFurniture(Type type) {
        if (type == Type.ArtDeco) return new ArtDecoTable();
        if (type == Type.Victorian) return new VictorianTable();
        if (type == Type.Modern) return new ModernTable();
        return null;
    }
}
