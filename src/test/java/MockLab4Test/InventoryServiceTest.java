package MockLab4Test;
import inventory.model.InhousePart;
import inventory.model.Part;
import inventory.model.Product;
import inventory.repository.InventoryRepositoryFile;
import inventory.service.InventoryService;
import inventory.validator.PartValidator;
import inventory.validator.ProductValidator;
import inventory.validator.ValidationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


public class InventoryServiceTest {
    InventoryService service;
    InventoryRepositoryFile repo;

    @BeforeEach
    void setUp() {
        repo = mock(InventoryRepositoryFile.class);
        service = new InventoryService(repo);
    }

    @Test
    void testGetAllProducts() {
        Product prod = mock(Product.class);
        Mockito.when(repo.getAllProducts()).thenReturn(FXCollections.observableArrayList(prod));
        assertEquals(service.getAllProducts().size(), 1);
    }

    @Test
    void testGetAllParts() {
        Part part = mock(Part.class);
        Mockito.when(repo.getAllParts()).thenReturn(FXCollections.observableArrayList(part));
        assertEquals(service.getAllParts().size(), 1);
    }
}