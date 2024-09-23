package org.example;

import org.example.Factories.ChairFactory;
import org.example.Factories.CoffeeTableFactory;
import org.example.Factories.SofaFactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory chairFactory = new ChairFactory();

        Furniture artDecoChair = chairFactory.createFurniture(Type.ArtDeco);
        artDecoChair.details();

        Furniture victoriaChair = chairFactory.createFurniture(Type.Victorian);
        victoriaChair.details();

        Furniture modernChair = chairFactory.createFurniture(Type.Modern);
        modernChair.details();

        System.out.println("------------------------");

        AbstractFactory sofaFactory = new SofaFactory();

        Furniture artDecoSofa = sofaFactory.createFurniture(Type.ArtDeco);
        artDecoSofa.details();

        Furniture victorianSofa = sofaFactory.createFurniture(Type.Victorian);
        victorianSofa.details();

        Furniture modernSofa = sofaFactory.createFurniture(Type.Modern);
        modernSofa.details();

        System.out.println("------------------------");

        AbstractFactory coffeeTableFactory = new CoffeeTableFactory();

        Furniture artDecoTable = coffeeTableFactory.createFurniture(Type.ArtDeco);
        artDecoTable.details();

        Furniture victorianTable = coffeeTableFactory.createFurniture(Type.Victorian);
        victorianTable.details();

        Furniture modernTable = coffeeTableFactory.createFurniture(Type.Modern);
        modernTable.details();
    }
}