import java.util.Objects;


public class Laptop {

    private String model;
    private int ram;
    private int hdd;
    private String operatingSystem;
    private String color;

    public Laptop(String model, int ram, int hdd, String operatingSystem, String color) {
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getColor() {
        return color;
    }
    
    @Override
    public String toString() {
        String newLine = System.lineSeparator();
        String result = newLine + "Модель ноутбука: " + model + newLine +
                "Оперативная память (RAM): " + ram + "ГБ" + newLine + "Объем жесткого диска (HDD): " + hdd + "ГБ"
                + newLine + "Операционная система: " + operatingSystem + newLine +
                "Цвет ноутбука: " + color + newLine + newLine +
                "**********************************************************";
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Laptop laptop = (Laptop) obj;
        return model.equals(laptop.model) && ram == laptop.ram && hdd == laptop.hdd &&
                operatingSystem.equals(laptop.operatingSystem) && color.equals(laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, ram, hdd, operatingSystem, color);
    }

}