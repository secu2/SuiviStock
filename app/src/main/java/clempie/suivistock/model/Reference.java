package clempie.suivistock.model;

/**
 * Created by pierrick on 23/03/16.
 */
public class Reference {

    private long reference_id;
    private String reference_name;
    private String reference_image;
    private String reference_brand;
    private String reference_conditioning;
    private int reference_quantity;
    private int reference_weight;
    private String reference_barcode;
    private int reference_price;
    private Category reference_category;

    public Reference(long reference_id) {
        this.reference_id = reference_id;
    }

    public Reference(int reference_id, String reference_name, String reference_image, String reference_brand, String reference_conditioning, int reference_quantity, int reference_weight, String reference_barcode, int reference_price, Category reference_category) {
        this.reference_id = reference_id;
        this.reference_name = reference_name;
        this.reference_image = reference_image;
        this.reference_brand = reference_brand;
        this.reference_conditioning = reference_conditioning;
        this.reference_quantity = reference_quantity;
        this.reference_weight = reference_weight;
        this.reference_barcode = reference_barcode;
        this.reference_price = reference_price;
        this.reference_category = reference_category;
    }

    public long getId() {
        return reference_id;
    }

    public void setId(long id) {
        this.reference_id = id;
    }

    public String getName() {
        return reference_name;
    }

    public void setName(String name) {
        this.reference_name = name;
    }

    public String getImage() {
        return reference_image;
    }

    public void setImage(String reference_image) {
        this.reference_image = reference_image;
    }

    public String getBrand() {
        return reference_brand;
    }

    public void setBrand(String reference_brand) {
        this.reference_brand = reference_brand;
    }

    public String getConditioning() {
        return reference_conditioning;
    }

    public void setConditioning(String reference_conditioning) {
        this.reference_conditioning = reference_conditioning;
    }

    public int getQuantity() {
        return reference_quantity;
    }

    public void setQuantity(int reference_quantity) {
        this.reference_quantity = reference_quantity;
    }

    public int getWeight() {
        return reference_weight;
    }

    public void setWeight(int reference_weight) {
        this.reference_weight = reference_weight;
    }

    public String getBarcode() {
        return reference_barcode;
    }

    public void setBarcode(String reference_barcode) {
        this.reference_barcode = reference_barcode;
    }

    public int getPrice() {
        return reference_price;
    }

    public void setPrice(int reference_price) {
        this.reference_price = reference_price;
    }

    public Category getCategory() {
        return reference_category;
    }

    public void setCategory(Category reference_category) {
        this.reference_category = reference_category;
    }

    @Override
    public String toString() {
        return "Reference{" +
                "reference_id=" + reference_id +
                ", reference_name='" + reference_name + '\'' +
                ", reference_image='" + reference_image + '\'' +
                ", reference_brand='" + reference_brand + '\'' +
                ", reference_conditioning='" + reference_conditioning + '\'' +
                ", reference_quantity=" + reference_quantity +
                ", reference_weight=" + reference_weight +
                ", reference_barcode='" + reference_barcode + '\'' +
                ", reference_price=" + reference_price +
                ", reference_category=" + reference_category +
                '}';
    }
}
