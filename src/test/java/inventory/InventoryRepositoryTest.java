package inventory;

import inventory.model.Product;
import inventory.repository.InventoryRepositoryFile;
import inventory.repository.InventoryRepositoryInMemory;
import inventory.service.InventoryService;
import inventory.validator.PartValidator;
import inventory.validator.ProductValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Timeout;

public class InventoryRepositoryTest {

    private InventoryRepositoryInMemory repo;

    @BeforeEach
    void setUp() {
        repo = new InventoryRepositoryInMemory();

    }


    @Test
    void lookupProduct_WBT_1(){
        assertNull(repo.lookupProduct(""));
    }

    @Test
    void lookupProduct_WBT_2(){
        repo.addProduct(new Product(1,"Cutie", 5, 2,20,50));
        repo.addProduct(new Product(1,"Usa", 20, 2,20,50));
        assertEquals(new Product(1,"Cutie", 5, 2,20,50),repo.lookupProduct("Cutie"));
    }

    @Test
    void lookupProduct_WBT_3(){
        repo.addProduct(new Product(1,"Cutie", 5, 2,20,50));
        repo.addProduct(new Product(1,"Usa", 20, 2,20,50));
        assertNull(repo.lookupProduct("Masa"));
    }



    @Test
    void lookupProduct_WBT_4(){
        assertEquals(new Product(0, null, 0.0, 0, 0, 0, null),repo.lookupProduct("Cutie"));
    }


}
