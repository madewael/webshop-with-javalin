import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Context;
import io.javalin.Javalin;
import io.javalin.translator.json.JavalinJacksonPlugin;

import java.util.Collections;

public class Server {

    public static void main(String[] args) {
        new Server().run();
    }

    ShoppingApp app = new ShoppingApp();

    private void run() {


        Javalin app = Javalin.create()
                .enableStandardRequestLogging()
                .enableStaticFiles("/web")
                .port(8000)
                .start();



        app.get("/API/products", this::getProducts);
        app.get("/API/customers", this::getCustomers);
        app.get("/API/products/stock", this::getStock);
        app.get("/API/cart/:customerId", this::getCartOfCustomer);

        app.post("/API/cart/:customerId/add/:productName", this::addToCartOfCustomer);
        app.post("/API/cart/:customerId/del/:productName", this::removeFromCartOfCustomer);

        app.post("/API/cart/:customerId/buy", this::buy);
        app.post("/API/cart/:customerId/drop", this::dropCart);

        app.exception(IllegalArgumentException.class, this::sendExceptionAsErrorMessage);


    }

    private  Context sendExceptionAsErrorMessage(IllegalArgumentException ex, Context ctx) {
        return ctx.json(Collections.singletonMap("error",ex.getMessage()));
    }

    private Customer getCustomer(Context ctx) {
        String customer = ctx.param("customerId");
        try {
            int customerId = Integer.parseInt(customer);
            return app.findCustomer(customerId);
        } catch (NumberFormatException ex) {
            return app.findCustomer(customer);
        }

    }

    private Product getProduct(Context ctx) {
        String productName = ctx.param("productName");
        return app.findProduct(productName);
    }

    private Context buy(Context ctx) {
        Customer customer = getCustomer(ctx);
        app.buy(customer);
        return ctx.json(app.getStockAndCart(customer));
    }

    private Context dropCart(Context ctx) {
        Customer customer = getCustomer(ctx);
        app.dropCartOf(customer);
        return ctx.json(app.getStockAndCart(customer));
    }

    private Context addToCartOfCustomer(Context ctx) {
        Customer customer = getCustomer(ctx);
        Product product = getProduct(ctx);
        app.addToCart(customer, product);
        return ctx.json(app.getStockAndCart(customer));
    }

    private Context removeFromCartOfCustomer(Context ctx) {
        Customer customer = getCustomer(ctx);
        Product product = getProduct(ctx);

        app.removeFromCart(customer, product);
        return ctx.json(app.getStockAndCart(customer));
    }

    private Context getProducts(Context ctx) {
        return ctx.json(app.getProducts());
    }

    private Context getCustomers(Context ctx) {
        return ctx.json(app.getCustomers());
    }

    private Context getStock(Context ctx) {
        return ctx.json(app.getStock());
    }

    private Context getCartOfCustomer(Context ctx) {
        Customer customer = getCustomer(ctx);
        return ctx.json(app.getStockAndCart(customer));
    }

}