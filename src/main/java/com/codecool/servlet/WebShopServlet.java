package com.codecool.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "webShopServlet", urlPatterns = {"/webshop"})
public class WebShopServlet extends HttpServlet {
    /*
    This should list at least 3-5 different available Items with different properties
    (eg. [0, "Asus Laptop", 1600.0], [1, "Harry Potter Ebook", 50.0], etc.).
    Generate these Items in the init() method, for example.
    Render every Item's name and price on the screen, with an Add and a Remove button OR link (if it's easier for you).
    When these buttons are pressed, the content of ItemStore's static list should be modified with the belonging item.
    You shouldn't give any feedback on the screen from the modifications (yet)!
    */
    private String items;
    private Item[] itemsAvailable;

    @Override
    public void init() {
        itemsAvailable = new Item[]{ new Item("Asus Laptop", 1600.0),
                                     new Item("Harry Potter Ebook", 50.0),
                                     new Item("Hot Dog Slicer", 15.0),
                                     new Item("Java Cookbook", 25.0),
                                     new Item("I have no creativity for this shit", 1.99)};
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (Item item : itemsAvailable) {
            sb.append("<div>");
            sb.append("<h3>");
            sb.append(item.getName());
            sb.append("</h3>");
            sb.append("<p>");
            sb.append(item.getPrice());
            sb.append("</p>");
            sb.append("<a href=\"/webshop?item=");
            sb.append(item.getId());
            sb.append("&remove=false\">Buy</a>");
            sb.append("<a href=\"/webshop?item=");
            sb.append(item.getId());
            sb.append("&remove=true\">Remove</a>");
            sb.append("</div>");
        }
        items = sb.toString();

        PrintWriter out = response.getWriter();

        String item = request.getParameter("item");
        if (item != null) {
            if (request.getParameter("remove").equals("true")) {
                ItemStore.remove(itemsAvailable[Integer.parseInt(item) - 1]);
            } else ItemStore.add(itemsAvailable[Integer.parseInt(item) - 1]);
        }
        System.out.println(ItemStore.size());

        out.println(
                "<html>\n" +
                "<head><title>WebShop</title></head>\n" +
                "<body>\n" +
                "<h1 align = \"center\">WebShop</h1>\n" +
                items +
                "</body></html>"
        );
    }
}
