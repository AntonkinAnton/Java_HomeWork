package HomeWork6;

public class Laptop {

    public enum OperatingSystem{
        Windows11,
        Windows10,
        Linux,
        MacOS,
    }

    private String name;
    private double price;
    private OperatingSystem operatingSystem;
    private int hardDiskSize;
    private int RAMSize;
    private String color;

    public Laptop(String name, double price, OperatingSystem operatingSystem, int hardDiskSize, int RAMSize, String color) {
        this.name = name;
        this.price = price;
        this.operatingSystem = operatingSystem;
        this.hardDiskSize = hardDiskSize;
        this.RAMSize = RAMSize;
        this.color = color;
        this.color = color;
    }

    public String getName() {
        return name;
    }
    
    
    public double getPrice() {
        return price;
    }
    
    
    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }
    
    
    public int getHardDiskSize() {
        return hardDiskSize;
    }
    
    
    public int getRAMSize() {
        return RAMSize;
    }
    
    
    public String getColor() {
        return color;
    }
    
    
    public String toString() {
        return "Ноутбук: " + name + ", Цена: " + price + " руб., Операционная система: " + operatingSystem +
                ", Объем жесткого диска: " + hardDiskSize + " ГБ, Объем ОЗУ: " + RAMSize + " ГБ, Цвет: " + color;
    }
}

