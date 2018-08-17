package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "shoppingCartServlet", urlPatterns = {"/cart"})
public class ShoppingCartServlet extends HttpServlet {
    /*
    This should list the content of ItemStore's static list.
    It should render a HTML list or a table with the items in it.
    It should render a Sum of Price field as well.
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Item> items = ItemStore.getItems();
        StringBuilder cart = new StringBuilder();

        cart.append("<table>");

        for (Item item : items) {
            cart.append("<tr><td>");
            cart.append(item.getName());
            cart.append("</td>");
            cart.append("<td>");
            cart.append(item.getPrice());
            cart.append("</td></tr>");
        }

        cart.append("<tr><td><b>Sum of Price:</b></td>");
        cart.append("<td><b>");
        cart.append(items.stream().mapToDouble(Item::getPrice).sum());
        cart.append("</b></td>");
        cart.append("</table>");


        PrintWriter out = response.getWriter();

        out.println(
                "<html>\n" +
                "<head><title>WebShop</title></head>\n" +
                "<body>\n" +
                "<h1 align = \"center\">WebShop</h1>\n" +
                cart.toString() +
                "</body></html>"
        );
    }
}
