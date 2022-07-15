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

    String EMAIL_ALREADY_IN_USE = "Email Already In Use!";

    String REGISTER_TOPIC = "Welcome To Tiklakapinda";

    String REGISTER_BODY = "We are happy to have you among us, you are sure to find great discount deals";

    String REGISTER_TOPIC_EMOJI = new String(Character.toChars(0x1f60d	));

    String LOGIN_TOPIC = "New Login Process!";

    String LOGIN_BODY = String.valueOf(new Date().toString() + " If you are not logged in on this date, we recommend that you change your password.");

    String AUTH_DELETE_TOPIC = " We are sorry you left us ";

    String AUTH_DELETE_TOPIC_EMOJI = new String(Character.toChars(0x1f615));

    String AUTH_DELETE_BODY = "Please let us know what caused you to make this decision";

    String USER_DELETED= "User Deleted";

    String CATEGORY_NAME_ALREADY_IN_USE = "Category Name Already In Use!";

    String SELLER_SAVED = "Seller Saved...";

    String SELLER_DELETED = "Seller Deleted.";

    String SELLER_COMMENT_CREATED = "Seller Comment Created...";

    String SELLER_COMMENT_DELETED = "Seller Comment Deleted.";

    String PRODUCT_COMMENT_CREATED = "Product Comment Created...";

    String PRODUCT_COMMENT_DELETED = "Product Comment Deleted.";

    String ITEMS_IN_THE_CART_HAVE_BEEN_PURCHASED = "Items In The Cart Have Been Purchased...";

    String ADDRESS_CREATED = "Address Created";

    String ADDRESS_DELETED = "Address deleted";

    String ADDED_TO_FAVORITES = "Added To Favorites";

    String REMOVE_FROM_FAVORITES = "Remove From Favorites";
}
