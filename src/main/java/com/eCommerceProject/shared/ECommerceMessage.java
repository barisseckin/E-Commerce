package com.eCommerceProject.shared;

import java.util.Date;

public interface ECommerceMessage {

    String PRODUCT_NOT_FOUND = "Product Not Found!";

    String PRODUCT_DELETED = "Product Deleted";

    String PRODUCT_SAVED = "Product Saved";

    String NOT_FOUND_THIS_NAME = "No Product Found With This Name";

    String ADD_TO_CART = "Product Add To Cart";

    String REMOVE_FROM_CART = "Product Remove From Cart";

    String USER_CREATED = "User Created";

    String USERNAME_ALREADY_IN_USE = "Username Already In Use!";

    String REGISTER_TOPIC = "Welcome To Tiklakapinda";

    String REGISTER_BODY = "We are happy to have you among us, you are sure to find great discount deals";

    String REGISTER_TOPIC_EMOJI = new String(Character.toChars(0x1f60d	));

    String LOGIN_TOPIC = "New Login Process!";

    String LOGIN_BODY = String.valueOf(new Date().toString() + "If you are not logged in on this date, we recommend that you change your password.");
}
