package DTOs.Pets;

public enum Status {
    available("available"), pending("pending"), sold("sold");
    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
