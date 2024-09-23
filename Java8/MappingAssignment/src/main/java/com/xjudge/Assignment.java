package com.xjudge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assignment {

    private final List<Customer> customerList;

    public Assignment() {
        customerList = List.of(
                new Customer(1,"Ahmed", 30,
                        Arrays.asList(
                                new Order("Laptop", 1),
                                new Order("Headphones", 2),
                                new Order("Book", 3),
                                new Order("Coffee", 1),
                                new Order("Camera", 1)
                        )
                ),
                new Customer(2, "Sara", 25,
                        Arrays.asList(
                                new Order("Shoes", 2),
                                new Order("Bag", 1),
                                new Order("Dress", 1),
                                new Order("Perfume", 2),
                                new Order("Watch", 1)
                        )
                ),
                new Customer(3, "John", 28,
                        Arrays.asList(
                                new Order("Tablet", 1),
                                new Order("Smartphone", 1),
                                new Order("Charger", 3),
                                new Order("Earbuds", 2),
                                new Order("Keyboard", 1)
                        )
                ),
                new Customer(4, "Mona", 22,
                        Arrays.asList(
                                new Order("Book", 4),
                                new Order("Notebook", 3),
                                new Order("Pen", 10),
                                new Order("Lamp", 1),
                                new Order("Desk", 1)
                        )
                ),
                new Customer(5, "Ali", 35,
                        Arrays.asList(
                                new Order("Chair", 2),
                                new Order("Table", 1),
                                new Order("Couch", 1),
                                new Order("TV", 1)
                        )
                ),
                new Customer(6, "Fatima", 27,
                        Arrays.asList(
                                new Order("Phone Case", 1),
                                new Order("Screen Protector", 2),
                                new Order("USB Cable", 3),
                                new Order("Power Bank", 1)
                        )
                ),
                new Customer(7, "Omar", 33,
                        Arrays.asList(
                                new Order("Monitor", 2),
                                new Order("Keyboard", 1),
                                new Order("Mouse", 1),
                                new Order("Desk Lamp", 2)
                        )
                ),
                new Customer(8, "Aisha", 29,
                        Arrays.asList(
                                new Order("Shoes", 3),
                                new Order("Jacket", 1),
                                new Order("Hat", 2),
                                new Order("Gloves", 1)
                        )
                ),
                new Customer(9, "Rami", 31,
                        Arrays.asList(
                                new Order("Camera", 1),
                                new Order("Tripod", 1),
                                new Order("Memory Card", 2),
                                new Order("Lens", 1)
                        )
                ),
                new Customer(10, "Layla", 26,
                        Arrays.asList(
                                new Order("Backpack", 1),
                                new Order("Water Bottle", 2),
                                new Order("Notebook", 1),
                                new Order("Lunchbox", 1)
                        )
                ),
                new Customer(11, "Samir", 40,
                        Arrays.asList(
                                new Order("Grill", 1),
                                new Order("Tongs", 1),
                                new Order("Charcoal", 2),
                                new Order("Spatula", 1)
                        )
                ),
                new Customer(12, "Nadia", 23,
                        Arrays.asList(
                                new Order("Belt", 1),
                                new Order("Scarf", 2),
                                new Order("Sunglasses", 1),
                                new Order("Handbag", 1)
                        )
                ),
                new Customer(13, "Ziad", 32,
                        Arrays.asList(
                                new Order("Helmet", 1),
                                new Order("Gloves", 1),
                                new Order("Jacket", 1),
                                new Order("Knee Pads", 2)
                        )
                ),
                new Customer(14, "Hana", 24,
                        Arrays.asList(
                                new Order("Wristwatch", 1),
                                new Order("Bracelet", 2),
                                new Order("Earrings", 3),
                                new Order("Necklace", 1)
                        )
                ),
                new Customer(15, "Yusuf", 26,
                        Arrays.asList(
                                new Order("Book", 2),
                                new Order("Pen", 5),
                                new Order("Notebook", 1),
                                new Order("Highlighter", 3)
                        )
                ),
                new Customer(16, "Khadija", 34,
                        Arrays.asList(
                                new Order("Blender", 1),
                                new Order("Toaster", 1),
                                new Order("Microwave", 1),
                                new Order("Cookware Set", 1)
                        )
                ),
                new Customer(17, "Faris", 29,
                        Arrays.asList(
                                new Order("Gaming Console", 1),
                                new Order("Games", 5),
                                new Order("Headset", 1),
                                new Order("Controller", 1)
                        )
                ),
                new Customer(18, "Rana", 28,
                        Arrays.asList(
                                new Order("Sneakers", 1),
                                new Order("Sportswear", 2),
                                new Order("Water Bottle", 1),
                                new Order("Yoga Mat", 1)
                        )
                ),
                new Customer(19, "Nabil", 37,
                        Arrays.asList(
                                new Order("Fishing Rod", 1),
                                new Order("Tackle Box", 1),
                                new Order("Bait", 2),
                                new Order("Fishing Net", 1)
                        )
                ),
                new Customer(20, "Jana", 25,
                        Arrays.asList(
                                new Order("Camera Bag", 1),
                                new Order("Lens Cleaner", 2),
                                new Order("Memory Card", 3),
                                new Order("Tripod", 1)
                        )
                ),
                new Customer(21, "Mikhail", 31,
                        Arrays.asList(
                                new Order("Smartwatch", 1),
                                new Order("Wireless Charger", 1),
                                new Order("Fitness Tracker", 1),
                                new Order("Bluetooth Earphones", 2)
                        )
                )
        );
    }

    public List<Customer> getCustomerList() {
        return this.customerList;
    }

}
