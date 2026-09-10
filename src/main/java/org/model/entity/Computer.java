package org.model.entity;

import org.model.vo.*;

public class Computer {

    private final ComputerId id;
    private final ComputerBrand brand;
    private final ComputerCategory category;
    private final ComputerProcessor processor;
    private final ComputerMemory memory;
    private final ComputerStorage storage;
    private final ComputerPorts ports;
    private final ComputerDisplay display;
    private final ComputerPrice price;

    private Computer(ComputerId id, ComputerBrand brand, ComputerCategory category, ComputerProcessor processor,
                     ComputerMemory memory, ComputerStorage storage, ComputerPorts ports, ComputerDisplay display, ComputerPrice price) {
        this.id = id;
        this.brand = brand;
        this.category = category;
        this.processor = processor;
        this.memory = memory;
        this.storage = storage;
        this.ports = ports;
        this.display = display;
        this.price = price;
    }

    public static Computer createComputer(ComputerId id, ComputerBrand brand, ComputerCategory category,
                                          ComputerProcessor processor, ComputerMemory memory, ComputerStorage storage,
                                          ComputerPorts ports, ComputerDisplay display, ComputerPrice price) {
        return new Computer(id, brand, category, processor, memory, storage, ports, display, price);
    }

    public static Computer createComputerWithoutId(ComputerBrand brand, ComputerCategory category,
                                                   ComputerProcessor processor, ComputerMemory memory, ComputerStorage storage,
                                                   ComputerPorts ports, ComputerDisplay display, ComputerPrice price) {
        return new Computer(null, brand, category, processor, memory, storage, ports, display, price);
    }

    public ComputerId getId() {
        return id;
    }

    public ComputerBrand getBrand() {
        return brand;
    }

    public ComputerCategory getCategory() {
        return category;
    }

    public ComputerProcessor getProcessor() {
        return processor;
    }

    public ComputerMemory getMemory() {
        return memory;
    }

    public ComputerStorage getStorage() {
        return storage;
    }

    public ComputerPorts getPorts() {
        return ports;
    }

    public ComputerDisplay getDisplay() {
        return display;
    }

    public ComputerPrice getPrice() {
        return price;
    }
}