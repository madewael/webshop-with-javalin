import java.util.HashSet;
import java.util.Set;

public class CategoryCatalogue {

    Set<Category> categories;

    public CategoryCatalogue() {
        categories = new HashSet<>();

        categories.add(new Category("fruit", 6));
        categories.add(new Category("vegetables", 6));
        categories.add(new Category("bread", 6));

        categories.add(new Category("spreads", 12));


        categories.add(new Category("electronics", 21));

    }

    public Category find(String name) {
        for(Category c : categories) {
            if (c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

}
