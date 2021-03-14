package SOLID.Controllers;

import SOLID.Interfaces.LayoutFactory;

public class Layout  implements LayoutFactory {
    @Override
    public SOLID.Interfaces.Layout produce(String type) {
        return switch (type) {

            case "SimpleLayout" -> new SimpleLayout();
            case "XmlLayout" -> new XmlLayout();
            default -> throw new IllegalArgumentException("Not valid type of layout for " + type);
        };
    }
}
