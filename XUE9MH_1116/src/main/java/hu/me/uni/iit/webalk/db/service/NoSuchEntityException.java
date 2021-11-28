package hu.me.uni.iit.webalk.db.service;

public class NoSuchEntityException extends RuntimeException {
    private Long id;

    public NoSuchEntityException(Long id) {
        super(String.format("No such entity",id));
        this.id=id;
    }

    public Long getId() {
        return id;
    }
}
