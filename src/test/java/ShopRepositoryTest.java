import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveProductById() {
        Product product = new Product(1, "Tea", 100);
        Product secondProduct = new Product(2, "chair", 250);


        ShopRepository repo = new ShopRepository();
        repo.add(product);
        repo.add(secondProduct);
        repo.remove(2);


        Product[] expected = {product};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotFoundException() {
        Product product = new Product(1, "Tea", 100);
        Product secondProduct = new Product(2, "chair", 250);


        ShopRepository repo = new ShopRepository();
        repo.add(product);
        repo.add(secondProduct);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(3);
        });
    }

    @Test
    public void shouldAddProduct() {
        Product product = new Product(1, "Tea", 100);
        Product secondProduct = new Product(2, "chair", 250);


        ShopRepository repo = new ShopRepository();
        repo.add(product);
        repo.add(secondProduct);


        Product[] expected = {product, secondProduct};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowAlreadyExistsException() {
        Product product = new Product(1, "Tea", 100);
        Product secondProduct = new Product(2, "chair", 250);


        ShopRepository repo = new ShopRepository();
        repo.add(product);
        repo.add(secondProduct);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product);
        });
    }

}
