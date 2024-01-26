public class Notebook {
    private String brand;
    private String os;
    private String cpu;
    private int ram;
    private int storage;

    public Notebook(String brand, String os, String cpu, int ram, int storage) {
        this.brand = brand;
        this.os = os;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getOs() {
        return this.os;
    }

    public String getCpu() {
        return this.cpu;
    }

    public int getRam() {
        return this.ram;
    }

    public int getStorage() {
        return this.storage;
    }

    @Override
    public String toString() {
        return  "Брэнд: " + brand +
                ", Операционная система: " + os +
                ", Процессор: " + cpu +
                ", ОЗУ: " + ram + "Гб" +
                ", Накопитель: " + storage + "Гб";
    }

    // создал сеттеры на случай дальнейшего расширения функционала программы
    /*
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
    */
}
